package br.com.spring.restreview.service;

import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.model.Estado;
import br.com.spring.restreview.repository.CozinhaRepository;
import br.com.spring.restreview.repository.EstadoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

    private EstadoRepository estadoRepository;

    @Transactional
    public Estado salvar(Estado estado){
        return this.estadoRepository.save(estado);
    }

    public List<Estado> listarTodos(){
        return this.estadoRepository.findAll();
    }

    @Transactional
    public Integer remover(Long estadoId){
         this.estadoRepository.deleteById(estadoId);
         return HttpStatus.OK.value();
    }

    public Estado procurarPorId(Long estadoId){
        return this.estadoRepository.findById(estadoId).orElseThrow(() -> new RuntimeException("Cozinha não encontrada"));
    }


}
