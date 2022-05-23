package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.Divida;
import com.casa.contas.projeto_contas.repository.DividaRepository;
import com.casa.contas.projeto_contas.service.DividaService;
import com.casa.contas.projeto_contas.util.Mensagens;
import com.casa.contas.projeto_contas.util.exception.ExceptionMensage;
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
        if(divida.getValor() <= 0){
            throw new ExceptionMensage(Mensagens.ERRO_CAMPO_VALOR_DIVIDA_VAZIO);
        }
        if(divida.getDescricao() == null || divida.getDescricao().isEmpty()){
            throw new ExceptionMensage(Mensagens.ERRO_CAMPO_DESCRICAO_DIVIDA_VAZIO);
        }
        if(divida.getDescricao().length() < 4){
            throw new ExceptionMensage(Mensagens.ERRO_CAMPO_DESCRICAO_DIVIDA_LENGTH);
        }

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
            throw new ExceptionMensage(Mensagens.ERRO_DIVIDA_NAO_ENCONTRADA);
        }
        return devedorOptional.get();
    }

    public List<Map<String, Object>> buscarDividasDevedor(Integer devedor_id) throws ExceptionMensage {
        if(this.dividaRepository.findDividasDevedor(devedor_id) != null){
            return this.dividaRepository.findDividasDevedor(devedor_id);
        }
        throw new ExceptionMensage(Mensagens.ERRO_DEVEDOR_INEXISTENTE);
    }


}
