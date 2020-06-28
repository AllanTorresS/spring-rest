package br.com.spring.restreview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {


    @GetMapping
    public List<String> listarTodasCozinhas(){
        return Arrays.asList("ceará","bahia");
    }
}
