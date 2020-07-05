package br.com.spring.restreview.repository;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
