package br.com.spring.restreview.repository.specifations;

import br.com.spring.restreview.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;

public class EspecificationsFactory {

    public static Specification<Restaurante> fretesGratis() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("taxaFrete"), BigDecimal.ZERO);
    }
}
