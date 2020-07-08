package br.com.spring.restreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class RestReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestReviewApplication.class, args);
    }

}
