package br.com.spring.restreview.estatica.cozinha;

import br.com.spring.restreview.RestReviewApplication;
import br.com.spring.restreview.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CozinhaComponent {

    @PersistenceContext
    private  EntityManager entityManager;

    @Transactional
    public void salvar(Cozinha c){
        entityManager.persist(c);
    }
}
