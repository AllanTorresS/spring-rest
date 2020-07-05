package br.com.spring.restreview.service;

import br.com.spring.restreview.model.Estado;
import br.com.spring.restreview.model.FormaPagamento;
import br.com.spring.restreview.repository.EstadoRepository;
import br.com.spring.restreview.repository.FormaPagamnetoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormaPagamentoService {

    private FormaPagamnetoRepository formaPagamnetoRepository;

    @Transactional
    public FormaPagamento salvar(FormaPagamento formaPagamento){
        return this.formaPagamnetoRepository.save(formaPagamento);
    }

    public List<FormaPagamento> listarTodos(){
        return this.formaPagamnetoRepository.findAll();
    }

    @Transactional
    public Integer remover(Long formaPagamentoId){
         this.formaPagamnetoRepository.deleteById(formaPagamentoId);
         return HttpStatus.OK.value();
    }

    public FormaPagamento procurarPorId(Long formaPagamentoId){
        return this.formaPagamnetoRepository.findById(formaPagamentoId).orElseThrow(() -> new RuntimeException("Forma de pagamento não encontrada"));
    }


}
