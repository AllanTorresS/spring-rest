package br.com.spring.restreview.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "forma_pagamento")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "forma_pagamento_seq_id")
    @SequenceGenerator(name = "forma_pagamento_seq_id",sequenceName = "forma_pagamento_seq_id",allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String descricao;
}
