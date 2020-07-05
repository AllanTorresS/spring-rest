package br.com.spring.restreview.service;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CidadeService {

    private CidadeRepository  cidadeRepository;

    @Transactional
    public Cidade salvar(Cidade cidade){
        return this.cidadeRepository.save(cidade);
    }

    public List<Cidade> listarTodos(){
        return this.cidadeRepository.findAll();
    }

    @Transactional
    public Integer remover(Long cidadeId){
         this.cidadeRepository.deleteById(cidadeId);
         return HttpStatus.OK.value();
    }

    public Cidade procurarPorId(Long cidadeId){
        return this.cidadeRepository.findById(cidadeId).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }


}
