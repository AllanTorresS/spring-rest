package br.com.spring.restreview.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurante")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
/**
 * @JsonIdentityInfo é usado para resolver o problema de depencia circular,
 * nesse caso a classe restaurante tem uma cozinha que tem uma lista de restaurantes,
 * com isso ocorreria um stackoverflow, mas com essa anotação na clase que vai ser pesquisada
 * isso não ocorre
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurante_seq_id")
    @SequenceGenerator(name = "restaurante_seq_id", sequenceName = "restaurante_seq_id", allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @Embedded
    private Endereco endereco;


    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns =
            @JoinColumn(name = "restaurante_id"),inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formaPagamentoList;

    @OneToMany(mappedBy = "restaurantelist")
    private List<Produto> produtoList;
}
