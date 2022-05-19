package com.casa.contas.projeto_contas.controller;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.Divida;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DividaController {

    @ApiOperation(value = "Cadastrar Divida",
            notes = "Este método é responsável por realizar o cadastro de uma Divida")
    ResponseEntity<Divida> salvar(Integer id, Divida divida) throws Exception;

    @ApiOperation(value = "Lista de dividas de um devedor",
            notes = "Este método é responsavel por listar todos as dividas de um devedor do sistema")
    ResponseEntity<List<Map<String, Object>>> listarDividasDevedor(Integer id);

    @ApiOperation(value = "Excluir um Divida",
            notes = "Este método é responsável por excluir  uma divida")
    ResponseEntity<?> deletarDivida(Integer dividaId) throws Exception;

    @ApiOperation(value = "Atualizar informações de uma divida",
            notes = "Este método é responsável por atualizar as informações de um usuário")
    ResponseEntity<String> atualizarDivida(Integer id, Divida divida) throws Exception;

    @ApiOperation(value = "Mostrar dividas",
            notes = "Este método é responsável por exibir todas as dividas do sistema")
    ResponseEntity<List<Divida>> mostrarDividas() throws Exception;

    @ApiOperation(value = "Mostrar dados de uma divida",
            notes = "Este método é responsável por exibir os dados de uma divida a partir do seu id")
    ResponseEntity<Divida> buscarDadosDivida(Integer id) throws Exception;
}
