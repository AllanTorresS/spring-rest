package br.com.spring.restreview.repository;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha,Long> {

    List<Cozinha> findCozinhaByNome(String nome);
    List<Cozinha> findCozinhaByNomeContaining(String nome);
}
