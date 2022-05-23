package com.casa.contas.projeto_contas.service;

import com.casa.contas.projeto_contas.model.Usuario;
import com.casa.contas.projeto_contas.util.exception.ExceptionMensage;

public interface UsuarioService {

    Usuario buscarUsuarioPorEmail(String email) throws ExceptionMensage;
    void salvarUsuario(Usuario usuario) throws ExceptionMensage;
}
