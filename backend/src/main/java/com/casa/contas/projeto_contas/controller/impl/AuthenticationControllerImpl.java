package com.casa.contas.projeto_contas.controller.impl;

import com.casa.contas.projeto_contas.config.JwtProvider;
import com.casa.contas.projeto_contas.controller.AuthenticationController;
import com.casa.contas.projeto_contas.model.enums.Papel;
import com.casa.contas.projeto_contas.repository.UsuarioRepository;
import com.casa.contas.projeto_contas.util.AutenticacaoRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping
public class AuthenticationControllerImpl implements AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    @PostMapping("/login")
    public ResponseEntity signIn(@RequestBody AutenticacaoRequisicao data) {
        try {
            String username = data.getUsername();
            System.out.println(username);
            System.out.println(data.getPassword());
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(username, data.getPassword()));

            List<String> roles = new ArrayList<>();

            for(Papel papel : this.usuarioRepository.findByEmail(username).getPapeis()){
                roles.add(papel.name());
            }
            String token = jwtProvider.createToken(username, new ArrayList<>());

            Map<Object, Object>  model = new HashMap<>();

            model.put("username", username);
            model.put("papeis", roles);
            model.put("token", "Bearer " + token);
            return ok(model);

        } catch (AuthenticationException e){
            throw new BadCredentialsException("Email/Senha fonercido não são válidos!");
        }
    }


}
