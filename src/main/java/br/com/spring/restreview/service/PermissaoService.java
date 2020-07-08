package br.com.spring.restreview.service;

import br.com.spring.restreview.model.FormaPagamento;
import br.com.spring.restreview.model.Permissao;
import br.com.spring.restreview.repository.FormaPagamnetoRepository;
import br.com.spring.restreview.repository.PermissaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissaoService {

    private PermissaoRepository permissaoRepository;

    @Transactional
    public Permissao salvar(Permissao permissao){
        return this.permissaoRepository.save(permissao);
    }

    public List<Permissao> listarTodos(){
        return this.permissaoRepository.findAll();
    }

    @Transactional
    public Integer remover(Long permissaoId){
         this.permissaoRepository.deleteById(permissaoId);
         return HttpStatus.OK.value();
    }

    public Permissao procurarPorId(Long permissaoId){
        return this.permissaoRepository.findById(permissaoId).orElseThrow(() -> new RuntimeException("Permissão não encontrada"));
    }


}
