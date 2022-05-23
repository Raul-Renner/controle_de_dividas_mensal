package com.casa.contas.projeto_contas.config;

import com.casa.contas.projeto_contas.util.exception.InvalidJwtAuthenticationException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtProvider {

    @Value("${security.jwt.token.secret-key: secret}")
    private String keySecret;

    @Value("${security.jwt.token.expire-length:3600000}")
    private final long validatyInMilliSeconds = 3600000;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostConstruct
    protected void init(){
        keySecret = Base64.getEncoder().encodeToString(keySecret.getBytes());
    }

    public String createToken(String username, List<String> rolesUser){

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", rolesUser);

        Date now = new Date();
        Date validityTime = new Date(now.getTime() + validatyInMilliSeconds);

        return Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(validityTime).signWith(SignatureAlgorithm.HS256, keySecret).compact();
    }

    public Authentication getAuthentication(String token){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));

        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
                userDetails.getAuthorities());
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(keySecret).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req){
        String bearerToken = req.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

    public boolean validateToken(String token) throws InvalidJwtAuthenticationException {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(keySecret).parseClaimsJws(token);

            if(claims.getBody().getExpiration().before(new Date())){
                return false;
            }
            return true;
        }catch ( JwtException | IllegalArgumentException e){
            throw new InvalidJwtAuthenticationException ("Token inválido ou expirado!");
        }
    }

    public String createRefreshToken(String token){
        Jws<Claims> claims = Jwts.parser().setSigningKey(keySecret).parseClaimsJws(token);
        Claims newClaims = Jwts.claims().setSubject(claims.getBody().getSubject());

        newClaims.put("roles", claims.getBody().get("roles"));

        Date now = new Date();
        Date validityTime = new Date(now.getTime() + validatyInMilliSeconds);

        return Jwts.builder().setClaims(newClaims).setIssuedAt(now).setExpiration(validityTime)
                .signWith(SignatureAlgorithm.HS256, keySecret).compact();

    }


}
