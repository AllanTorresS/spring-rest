package br.com.spring.restreview.controller;

import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CozinhaService cozinhaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cozinha> listarTodos() {
        return this.cozinhaService.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.OK).body(this.cozinhaService.procurarPorId(id));
    }

    @PostMapping("/salvar-atualizar")
    public ResponseEntity<?> salvar(@RequestBody Cozinha cozinha) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.cozinhaService.salvar(cozinha));
    }

}
