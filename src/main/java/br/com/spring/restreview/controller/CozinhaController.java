package br.com.spring.restreview.controller;

import br.com.spring.restreview.model.Cozinha;
import br.com.spring.restreview.service.CozinhaService;
import org.springframework.beans.BeanUtils;
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

    private CozinhaService cozinhaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<String> listarTodasCozinhas() {
        return Arrays.asList("brasileira", "tailandesa");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarCozinhaPorId(@PathVariable Long id){
        HttpHeaders headers = new HttpHeaders();

      headers.add("LOCATION","http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Cozinha cozinhaRequest){
        cozinhaRequest.setId(1l);

        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaRequest);
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody Cozinha cozinhaRequest){
//        BeanUtils.copyProperties("origem","destino");
        return ResponseEntity.status(HttpStatus.OK).body(cozinhaRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
//        BeanUtils.copyProperties("origem","destino");
        return ResponseEntity.ok().build();
    }
}
