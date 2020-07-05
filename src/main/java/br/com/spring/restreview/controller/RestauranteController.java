package br.com.spring.restreview.controller;

import br.com.spring.restreview.model.Estado;
import br.com.spring.restreview.model.Restaurante;
import br.com.spring.restreview.service.EstadoService;
import br.com.spring.restreview.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/todos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Restaurante>listarTodos() {
        return this.restauranteService.listarTodos();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.OK).body(this.restauranteService.procurarPorId(id));
    }

    @GetMapping("/frete-gratis")
    public ResponseEntity<?> listarComFreteGratis(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.OK).body(this.restauranteService.listarTodosComFreteGratis());
    }

    @PostMapping("/salvar-atualizar")
    public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {
        HttpHeaders headers = new HttpHeaders();

        headers.add("LOCATION", "http://localhost:8080/novalocalizacao");

        return ResponseEntity.status(HttpStatus.CREATED).body(this.restauranteService.salvar(restaurante));
    }

}
