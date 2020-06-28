package br.com.spring.restreview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cidade_seq_id")
    @SequenceGenerator(name = "cidade_seq_id",sequenceName = "cidade_seq_id",allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn
    private Estado estado;
}
