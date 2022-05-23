package com.casa.contas.projeto_contas.controller.impl;

import com.casa.contas.projeto_contas.controller.UsuarioPublicControlller;
import com.casa.contas.projeto_contas.model.Token;
import com.casa.contas.projeto_contas.model.Usuario;
import com.casa.contas.projeto_contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioPublicControllerImpl implements UsuarioPublicControlller {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ResponseEntity<Boolean> recuperarSenha(String Emailusuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> validarToken(String Emailusuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<String> mudarSenha(Token token) throws Exception {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) throws Exception {
        usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
