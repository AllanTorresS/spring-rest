package br.com.spring.restreview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "permissao")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "permissao_seq_id")
    @SequenceGenerator(name = "permissao_seq_id",sequenceName = "permissao_seq_id",allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private String descricao;

}
