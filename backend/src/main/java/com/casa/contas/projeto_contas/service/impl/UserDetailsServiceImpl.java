package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Usuario;
import com.casa.contas.projeto_contas.service.UsuarioService;
import com.casa.contas.projeto_contas.util.Mensagens;
import com.casa.contas.projeto_contas.util.exception.ExceptionMensage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //refatorar
        try {

            Usuario usuario = usuarioService.buscarUsuarioPorEmail(username);
            if (usuario == null) {
                throw new UsernameNotFoundException(Mensagens.ERRO_USUARIO_NAO_EXISTE);
            }
            return usuario;

        } catch (ExceptionMensage exceptionMensage) {
            throw new UsernameNotFoundException(Mensagens.ERRO_USUARIO_NAO_EXISTE);
        }

    }

}