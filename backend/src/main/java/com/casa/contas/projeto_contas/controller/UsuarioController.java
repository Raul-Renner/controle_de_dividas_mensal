package com.casa.contas.projeto_contas.controller;

import com.casa.contas.projeto_contas.model.Usuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UsuarioController {
    @ApiOperation(
            value = "Adicionar um usuário do tipo DEVEDOR",
            notes = "Este é método é responsável por cadastrar um usuário do papel 'DEVEDOR' no sitema")
    ResponseEntity<?> createUsuario(Usuario usuario) throws Exception;

    /*
    @ApiOperation(
            value = "Listar todos usuarios",
            notes = "Este é método é responsável por listar todos os usuarios do sitema")
    ResponseEntity<String> listarUsuarios() throws Exception; */


    @ApiOperation(
            value = "Deletar um usuário do tipo DEVEDOR",
            notes = "Este é método é responsável por deletar um usuário do sitema")
    ResponseEntity<?> deletarUsuario(Usuario usuario) throws Exception;

    @ApiOperation(
            value = "Atualizar um usuário ",
            notes = "Este é método é responsável por atualizar dados de um usuário do sitema")
    ResponseEntity<String> atualizarUsuario(Usuario usuario) throws Exception;

    @ApiOperation(
            value = "Mostrados dados do usuário logado",
            notes = "Este é método é responsável por exibir os dados do usuário logado no sitema")
    ResponseEntity<Map<String, Object>> mostrarDadosUsuarioLogado(Usuario usuario) throws Exception;

    @ApiOperation(
            value = "Mostrados dados de um usuário",
            notes = "Este é método é responsável por exibir os dados de um usuário do sitema")
    ResponseEntity<Map<String, Object>> mostrarDadosUsuario(Integer idUsuario) throws Exception;

    @ApiOperation(
            value = "Alterar Senha",
            notes = "Este é método é responsável por alterar senha de um usuário do sitema")
    ResponseEntity<?> alterarSenha(Usuario usuario, Map<String, String> map) throws Exception;

    /*@ApiOperation(
            value = "Adicionar um usuário do tipo DEVEDOR",
            notes = "Este é método é responsável por cadastrar um usuário do papel 'DEVEDOR' no sitema")
    ResponseEntity<String> redefinirSenha(Usuario usuario) throws Exception; */

}
