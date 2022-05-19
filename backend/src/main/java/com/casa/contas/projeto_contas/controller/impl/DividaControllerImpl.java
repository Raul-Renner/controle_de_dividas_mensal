package com.casa.contas.projeto_contas.controller.impl;

import com.casa.contas.projeto_contas.controller.DividaController;
import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.Divida;
import com.casa.contas.projeto_contas.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("systemDebtors/api/v1")
public class DividaControllerImpl implements DividaController {

    @Autowired
    DividaService dividaService;

    @Override
    @PostMapping("/{devedorId}/addDivida")
    public ResponseEntity<Divida> salvar(@PathVariable("devedorId") Integer id, @RequestBody Divida divida) throws Exception {
        return new ResponseEntity<>( dividaService.salvarDivida(id, divida), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/excluir-divida/{dividaId}")
    public ResponseEntity<?> deletarDivida(@PathVariable("dividaId") Integer dividaId) throws Exception {
        dividaService.excluirDivida(dividaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{devedorId}/atualizar_divida")
    public ResponseEntity<String> atualizarDivida(@PathVariable("devedorId") Integer id,@RequestBody  Divida divida) throws Exception {
        dividaService.atualizarDivida(id, divida);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/dividas")
    public ResponseEntity<List<Divida>> mostrarDividas() throws Exception {
        return new ResponseEntity<List<Divida>>(dividaService.mostrarDividas(),HttpStatus.OK);
    }

    @Override
    @GetMapping("/divida/{divida_id}")
    public ResponseEntity<Divida> buscarDadosDivida(@PathVariable("divida_id") Integer id) throws Exception {
        return new ResponseEntity<Divida>(dividaService.buscarDividaPorId(id), HttpStatus.OK);
    }

    @Override
    @GetMapping("/{devedorId}/dividas-devedor")
    public ResponseEntity<List<Map<String, Object>>> listarDividasDevedor(@PathVariable("devedorId") Integer id) {
        List<Map<String, Object>> divida = this.dividaService.buscarDividasDevedor(id);
        System.out.println("ex: "+divida.toString());
        return new ResponseEntity<>(divida, HttpStatus.OK);
    }


}
