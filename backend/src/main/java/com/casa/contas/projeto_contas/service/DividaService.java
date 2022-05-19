package com.casa.contas.projeto_contas.service;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.Divida;

import java.util.List;
import java.util.Map;

public interface DividaService {
 public Divida buscarDividaPorId(Integer devedorId) throws Exception;

 // Map<String, Object> buscarDevedor(int id);
    List<Map<String, Object>> buscarDividasDevedor(Integer id);

    Divida salvarDivida(Integer id, Divida divida) throws Exception;
    void atualizarDivida(Integer idDevedor, Divida divida) throws Exception;
    void excluirDivida(int id) throws Exception;

    List<Divida> mostrarDividas();
}
