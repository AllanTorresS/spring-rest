package br.com.spring.restreview.repository;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamnetoRepository extends JpaRepository<FormaPagamento,Long> {
}
