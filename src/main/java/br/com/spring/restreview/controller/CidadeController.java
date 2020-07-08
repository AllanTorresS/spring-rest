package br.com.spring.restreview.controller;

import br.com.spring.restreview.model.Cidade;
import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.service.CidadeService;
import br.com.spring.restreview.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeService  cidadeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Cidade>listarTodos() {
        return this.cidadeService.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.OK).body(this.cidadeService.procurarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.cidadeService.salvar(cidade));
    }



}
