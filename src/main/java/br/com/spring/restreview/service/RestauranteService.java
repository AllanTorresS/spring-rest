package br.com.spring.restreview.service;

import br.com.spring.restreview.model.Permissao;
import br.com.spring.restreview.model.Restaurante;
import br.com.spring.restreview.repository.PermissaoRepository;
import br.com.spring.restreview.repository.RestauranteRepository;
import br.com.spring.restreview.repository.specifations.EspecificationsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Transactional
    public Restaurante salvar(Restaurante restaurante){
        return this.restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listarTodos(){
        return this.restauranteRepository.findAll();
    }

    @Transactional
    public Integer remover(Long restauranteId){
         this.restauranteRepository.deleteById(restauranteId);
         return HttpStatus.OK.value();
    }

    public Restaurante procurarPorId(Long restauranteId){
        return this.restauranteRepository.findById(restauranteId).orElseThrow(() -> new RuntimeException("Restaurante não encontrada"));
    }

    public List<Restaurante> listarTodosComFreteGratis(){
        return this.restauranteRepository.findAll(EspecificationsFactory.fretesGratis());
    }

}
