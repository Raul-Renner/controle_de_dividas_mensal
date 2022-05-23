package com.casa.contas.projeto_contas.config;

import com.casa.contas.projeto_contas.util.exception.InvalidJwtAuthenticationException;
import com.casa.contas.projeto_contas.util.exception.StandardError;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JwtTokenFilter extends GenericFilterBean {

    @Autowired
    private JwtProvider jwtProvider;

    public JwtTokenFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException{


            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            try {
                String token = jwtProvider.resolveToken(request);
                if(token != null && jwtProvider.validateToken(token)){
                    Authentication auth = jwtProvider.getAuthentication(token);

                    String refreshToken = jwtProvider.createRefreshToken(token);
                    response.setHeader("Access-Control-Expose-Headers", "Authorization");
                    response.setHeader("Authorization", "Bearer " + refreshToken);

                    if(auth != null){
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }else{
                    throw new InvalidJwtAuthenticationException("Token inválido ou expirado!");
                }
            } catch (InvalidJwtAuthenticationException ex){
                StandardError error = new StandardError(HttpStatus.UNAUTHORIZED.value(),
                        "Token inválido ou expirado!", ex.getMessage(), request.getHeader("Referer"));
                response.setStatus(error.getStatus());
                response.setContentType("application/json");

                ObjectMapper mapper = new ObjectMapper();
                PrintWriter out = response.getWriter();
                String json = mapper.writeValueAsString(error);
                out.print(json);
                out.flush();

                return;
            }

            filterChain.doFilter(request, response);
        }
    }

