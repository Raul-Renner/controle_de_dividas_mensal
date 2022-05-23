package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Usuario;
import com.casa.contas.projeto_contas.repository.UsuarioRepository;
import com.casa.contas.projeto_contas.service.UsuarioService;
import com.casa.contas.projeto_contas.util.Mensagens;
import com.casa.contas.projeto_contas.util.exception.ExceptionMensage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarUsuarioPorEmail(String email) throws ExceptionMensage {
        if(email != null && usuarioRepository.findByEmail(email) != null){
            return usuarioRepository.findByEmail(email);
        }
        throw  new ExceptionMensage(Mensagens.ERRO_EMAIL_INEXISTENTE);

    }

    @Override
    public void salvarUsuario(Usuario usuario) throws ExceptionMensage {
        if(usuario.getEmail() == null || usuario.getEmail().isEmpty()){
            throw  new ExceptionMensage(Mensagens.ERRO_CAMPO_EMAIL);
        }
        if(usuario.getEmail() != null && usuarioRepository.findByEmail(usuario.getEmail()) != null){
            throw  new ExceptionMensage(Mensagens.ERRO_EMAIL_JA_CADASTRADO);
        }
        if(usuario.getSenha() == null || usuario.getSenha().isEmpty()
                || usuario.getSenha().length() < 8){
            throw new ExceptionMensage(Mensagens.ERRO_TAMANHO_SENHA_INCORRETA);
        }
        if(usuario.getSenha() != null || !usuario.getSenha().isEmpty()){
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            usuarioRepository.save(usuario);
        }

    }
}
