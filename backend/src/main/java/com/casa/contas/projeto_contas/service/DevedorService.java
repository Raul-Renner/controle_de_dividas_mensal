package com.casa.contas.projeto_contas.service;

import com.casa.contas.projeto_contas.model.Devedor;

import java.util.List;
import java.util.Map;

public interface DevedorService {
    public Devedor buscarDevedorPorId(Integer devedorId) throws Exception;

    //List<Devedor> buscarDevedor(Integer id);
    List<Map<String, Object>> buscarDevedores(Integer id);

    Devedor salvarDevedor(Devedor devedor) throws Exception;
    void atualizarDevedor(Devedor devedor);
    void excluirDevedor(int id) throws Exception;
    List<Devedor> mostrarDevedores();
}
