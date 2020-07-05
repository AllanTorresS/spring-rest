package br.com.spring.restreview.service;

import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.repository.CidadeRepository;
import br.com.spring.restreview.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Transactional
    public Cozinha salvar(Cozinha cozinha){
        return this.cozinhaRepository.save(cozinha);
    }

    public List<Cozinha> listarTodos(){
        return this.cozinhaRepository.findAll();
    }

    @Transactional
    public Integer remover(Long cozinhaId){
         this.cozinhaRepository.deleteById(cozinhaId);
         return HttpStatus.OK.value();
    }

    public Cozinha procurarPorId(Long cozinhaId){
        return this.cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new RuntimeException("Cozinha não encontrada"));
    }


}
