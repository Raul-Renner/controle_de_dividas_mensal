package com.casa.contas.projeto_contas.controller;

import com.casa.contas.projeto_contas.util.AutenticacaoRequisicao;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {

    @ApiOperation(
            value = "Realizar login",
            notes = "Este método é responsável por realizar o login do usuário no sistema"
    )
    ResponseEntity signIn(AutenticacaoRequisicao data);

}
