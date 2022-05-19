package com.casa.contas.projeto_contas.controller.impl;

import com.casa.contas.projeto_contas.controller.DevedorController;
import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.service.DevedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("systemDebtors/api/v1")
public class DevedorControllerImpl implements DevedorController {

    @Autowired
    DevedorService devedorService;

    @Override
    @PostMapping("/devedor")
    public ResponseEntity<Devedor> salvar(@RequestBody Devedor devedor) throws Exception {
        devedor.setValor_total(0);
        return new ResponseEntity<>(devedorService.salvarDevedor(devedor), HttpStatus.OK);
    }

    @Override
    @GetMapping("{devedorId}/devedor-dividas")
    public ResponseEntity<List<Map<String, Object>>> listarDevedores(@PathVariable("devedorId") Integer id) {
        List<Map<String, Object>> devedor = this.devedorService.buscarDevedores(id);
        System.out.println(devedor.toString());
        return new ResponseEntity<>(devedor, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/devedor/{devedorId}")
    public ResponseEntity<?> deletarDevedor(@PathVariable("devedorId") Integer devedorId) throws Exception {
        devedorService.excluirDevedor(devedorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/atualiza-devedor")
    public ResponseEntity<String> atualizarDevedor(@RequestBody Devedor devedor) throws Exception {
        Devedor devedor1 = devedorService.buscarDevedorPorId(devedor.getId());
        devedor.setDividas(devedor1.getDividas());
        devedorService.atualizarDevedor(devedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/devedor/{devedor_id}")
    public ResponseEntity<Devedor> mostrarDadosDevedor(@PathVariable("devedor_id") Integer devedor_id) throws Exception {
        return new ResponseEntity<Devedor>(devedorService.buscarDevedorPorId(devedor_id), HttpStatus.OK);

    }

    @Override
    @PutMapping("/devedor/atualizar-divida-total")
    public ResponseEntity<String> atualizarTotalDividaDevedor(@RequestBody  float valorDivida,@RequestBody Devedor devedor) throws Exception {
        Devedor devedor1 = devedorService.buscarDevedorPorId(devedor.getId());
        devedor.setDividas(devedor1.getDividas());
        devedor.setValor_total(valorDivida);
        devedorService.atualizarDevedor(devedor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/devedores")
    public ResponseEntity<List<Devedor>> showDevedores(){
        return new ResponseEntity<List<Devedor>>(devedorService.mostrarDevedores(),HttpStatus.OK);
    }



}
