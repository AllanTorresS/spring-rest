package br.com.spring.restreview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "estado")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "estado_seq_id")
    @SequenceGenerator(name = "estado_seq_id",sequenceName = "estado_seq_id",allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;


}
