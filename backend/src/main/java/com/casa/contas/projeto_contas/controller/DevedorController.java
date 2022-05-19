package com.casa.contas.projeto_contas.controller;

import com.casa.contas.projeto_contas.model.Devedor;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DevedorController {
    @ApiOperation(value = "Cadastrar Devedor",
    notes = "Este método é responsável por realizar o cadastro de um devedor")
    ResponseEntity<Devedor> salvar(Devedor devedor) throws Exception;

    @ApiOperation(value = "Lista de todos os devedores",
    notes = "Este método é responsavel por listar todos os devedores do sistema")
    ResponseEntity<List<Map<String, Object>>> listarDevedores(Integer id);

    @ApiOperation(value = "Excluir um devedor",
    notes = "Este método é responsável por remover um usuário")
    ResponseEntity<?> deletarDevedor(Integer devedorId) throws Exception;

    @ApiOperation(value = "Atualizar informações de um devedor",
            notes = "Este método é responsável por atualizar as informações de um usuário")
    ResponseEntity<String> atualizarDevedor(Devedor devedor) throws Exception;

    @ApiOperation(value = "Mostrar dados de um usuário",
    notes = "Este método é responsável por exibir os dados de um devedor a partir do seu id")
    ResponseEntity<Devedor> mostrarDadosDevedor(Integer id) throws Exception;

    @ApiOperation(value = "Atualizar divida total de um devedor",
            notes = "Este método é responsável por atualizar a divida total de um usuário")
    ResponseEntity<String> atualizarTotalDividaDevedor(float valorDivida, Devedor devedor) throws Exception;

    ResponseEntity<List<Devedor>> showDevedores();


}
