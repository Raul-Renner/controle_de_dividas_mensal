package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.Divida;
import com.casa.contas.projeto_contas.repository.DividaRepository;
import com.casa.contas.projeto_contas.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DividaServiceImpl implements DividaService {

    @Autowired
    DividaRepository dividaRepository;

    @Autowired
    DevedorServiceImpl devedorService;


    @Override
    public Divida salvarDivida(Integer id, Divida divida) throws Exception {
        divida.setDevedor(devedorService.buscarDevedorPorId(id));
        return dividaRepository.save(divida);
    }

    @Override
    public void atualizarDivida(Integer idDevedor, Divida divida) throws Exception {
        divida.setDevedor(devedorService.buscarDevedorPorId(idDevedor));
        dividaRepository.save(divida);
    }

    @Override
    public void excluirDivida(int id) throws Exception {
        dividaRepository.deleteById(id);
    }

    @Override
    public List<Divida> mostrarDividas() {
        return dividaRepository.findAll();
    }

    @Override
    public Divida buscarDividaPorId(Integer dividaId) throws Exception {
        Optional<Divida> devedorOptional = dividaRepository.findById(dividaId);

        if(!devedorOptional.isPresent()){
            throw new Exception("Deu Ruim aqui!");
        }
        return devedorOptional.get();
    }

    public List<Map<String, Object>> buscarDividasDevedor(Integer devedor_id) {
        return this.dividaRepository.findDividasDevedor(devedor_id);
    }


}
