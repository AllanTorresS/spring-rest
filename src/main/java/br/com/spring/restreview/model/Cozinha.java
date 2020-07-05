package br.com.spring.restreview.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonRootName("cozinha")//só para xml
public class Cozinha {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cozinha_seq_id")
    @SequenceGenerator(name = "cozinha_seq_id",sequenceName = "cozinha_seq_id",allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "cozinha")
    private List<Restaurante> restaurantelist;
}
