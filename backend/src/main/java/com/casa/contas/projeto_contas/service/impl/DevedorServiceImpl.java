package com.casa.contas.projeto_contas.service.impl;

import com.casa.contas.projeto_contas.model.Devedor;
import com.casa.contas.projeto_contas.model.enums.Papel;
import com.casa.contas.projeto_contas.repository.DevedorRepository;
import com.casa.contas.projeto_contas.service.DevedorService;
import com.casa.contas.projeto_contas.service.UsuarioService;
import com.casa.contas.projeto_contas.util.Mensagens;
import com.casa.contas.projeto_contas.util.exception.ExceptionMensage;
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
    private DevedorRepository devedorRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Devedor buscarDevedorPorId(Integer id) throws Exception {
        Optional<Devedor> devedorOptional = devedorRepository.findById(id);

        if(!devedorOptional.isPresent()){
            throw new Exception("Deu Ruim aqui!");
        }
        return devedorOptional.get();
    }


    public List<Map<String, Object>> buscarDevedores(Integer id) throws ExceptionMensage {
        if(this.devedorRepository.findDividasDevedor(id) != null){
            return this.devedorRepository.findDividasDevedor(id);
        }
        throw new ExceptionMensage(Mensagens.ERRO_DEVEDOR_INEXISTENTE);

    }

    @Override
    public Devedor salvarDevedor(Devedor devedor) throws Exception {
        if(devedor.getNome() == null || devedor.getNome().isEmpty()){
            throw new ExceptionMensage(Mensagens.ERRO_CAMPO_NOME_DEVEDOR_VAZIO);
        }else{
            devedor.getUsuario().setNome(devedor.getNome());
            devedor.getUsuario().adicionarPapel(Papel.DEVEDOR);
            usuarioService.salvarUsuario(devedor.getUsuario());
            devedor.setUsuario(usuarioService.buscarUsuarioPorEmail(devedor.getUsuario().getEmail()));
            return devedorRepository.save(devedor);
        }

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
