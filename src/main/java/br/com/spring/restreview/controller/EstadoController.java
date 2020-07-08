package br.com.spring.restreview.controller;

import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.model.Estado;
import br.com.spring.restreview.service.CozinhaService;
import br.com.spring.restreview.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Estado>listarTodos() {
        return this.estadoService.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.OK).body(this.estadoService.procurarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Estado estado) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.estadoService.salvar(estado));
    }

}
