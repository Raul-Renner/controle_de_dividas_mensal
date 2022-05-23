package com.casa.contas.projeto_contas.controller.impl;

import com.casa.contas.projeto_contas.controller.UsuarioController;
import com.casa.contas.projeto_contas.model.Usuario;
import com.casa.contas.projeto_contas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public ResponseEntity<?> createUsuario(Usuario usuario) throws Exception {
        usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deletarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<String> atualizarUsuario(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> mostrarDadosUsuarioLogado(Usuario usuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, Object>> mostrarDadosUsuario(Integer idUsuario) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<?> alterarSenha(Usuario usuario, Map<String, String> map) throws Exception {
        return null;
    }
}
