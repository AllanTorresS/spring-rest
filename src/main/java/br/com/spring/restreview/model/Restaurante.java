package br.com.spring.restreview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @ManyToOne
    @JoinColumn
    private Cozinha cozinha;
}
