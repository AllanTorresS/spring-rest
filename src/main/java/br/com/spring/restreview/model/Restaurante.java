package br.com.spring.restreview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "restaurante_seq_id")
    @SequenceGenerator(name = "reataurante_seq_id",sequenceName = "restaurante_seq_id",allocationSize = 1)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;

    @ManyToMany
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns =
            @JoinColumn(name = "restaurante_id"),inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formaPagamentoList;
}
