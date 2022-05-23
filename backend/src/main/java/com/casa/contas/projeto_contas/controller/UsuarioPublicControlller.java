package com.casa.contas.projeto_contas.controller;

import com.casa.contas.projeto_contas.model.Token;
import com.casa.contas.projeto_contas.model.Usuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface UsuarioPublicControlller {

    @ApiOperation(
            value = "Recuperação de senha: criação do token",
            notes = "Este é método é responsável por receber o email do usuário, " +
                    "verificar se ela existe no banco e criar um token e mandar o email " +
                    " para o usuário solicitante da recuperação de senha")
    ResponseEntity<Boolean> recuperarSenha(String Emailusuario) throws Exception;

    @ApiOperation(
            value = "Verificação do token e mudança de senha",
            notes = "Este é método é responsável por receber um token do frontend e verificar " +
                    "se ainda é válido. Se estiver válido, ele manda um OK para o usuario via frontend," +
                    " chamando a pagina de alterar senha. Caso contrário ele vai para pagina de" +
                    " acesso expirado")
    ResponseEntity<?> validarToken(String Emailusuario) throws Exception;

    @ApiOperation(
            value = "Alterar senha e exclusao de token",
            notes = "Este é método verifica se o token ainda é válido e altera a senha" +
                    "do usuario. Se o token estiver válido, o controller salva a nova senha do usuario")
    ResponseEntity<String> mudarSenha(Token token) throws Exception;

    @ApiOperation(
            value = "Verificação do token e mudança de senha",
            notes = "Este método é responsável por cadastrar um usuário do tipo(papel) 'DEVEDOR' no sistema")
    ResponseEntity<String> createUsuario(Usuario usuario) throws Exception;
}
