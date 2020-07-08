package br.com.spring.restreview.estatica.cozinha;

import br.com.spring.restreview.RestReviewApplication;
import br.com.spring.restreview.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CozinhaEstaticaVoidMain {

    /***
     *
     * faz com seja possivel executar essa classe estatica como se fosse uma classe java normal
     * e não uma aplicação web
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(RestReviewApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaComponent cc = applicationContext.getBean(CozinhaComponent.class);
        Cozinha cozinha = new Cozinha();

        cozinha.setNome("Marroquina");

        cc.salvar(cozinha);

    }
}
