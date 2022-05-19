package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.repository.DevedorRepository;
import com.casa.contas.projeto_contas.service.DevedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DevedorServiceImpl implements DevedorService {

    @Autowired
    DevedorRepository devedorRepository;

    @Override
    public Devedor buscarDevedorPorId(Integer id) throws Exception {
        Optional<Devedor> devedorOptional = devedorRepository.findById(id);

        if(!devedorOptional.isPresent()){
            throw new Exception("Deu Ruim aqui!");
        }
        return devedorOptional.get();
    }


    public List<Map<String, Object>> buscarDevedores(Integer id) {
        return this.devedorRepository.findDividasDevedor(id);
    }

    @Override
    public Devedor salvarDevedor(Devedor devedor) throws Exception {
        return devedorRepository.save(devedor);
    }

    @Override
    public void atualizarDevedor(Devedor devedor) {
        devedorRepository.save(devedor);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void excluirDevedor(int id) throws Exception {
        this.devedorRepository.deleteById(id);
    }

    public List<Devedor> mostrarDevedores(){
        return devedorRepository.findAll();
    }
}
