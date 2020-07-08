package br.com.spring.restreview.repository;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long>, JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

    /**
     * a query que deveria ficar aki foi externalizada para o arquivo src/resources/orm.xml
     * é possivel usar esse estrategia quando tiver querys enormes e vc não quer jogalas no repository
     */
    List<Restaurante>consultarPorNome(String nome, @Param("id") Long cozinhaId);
}
