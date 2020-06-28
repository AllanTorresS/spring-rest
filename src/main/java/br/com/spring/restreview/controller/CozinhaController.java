package br.com.spring.restreview.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cozinhas")
public class CozinhaController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<String> listarTodasCozinhas() {
        return Arrays.asList("brasileira", "tailandesa");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public ResponseEntity<?> listarCozinhaPorId(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();

      headers.add("LOCATION","http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
