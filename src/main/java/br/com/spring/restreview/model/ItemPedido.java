package br.com.spring.restreview.model;

import br.com.spring.restreview.model.enumeration.StatusPedido;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_pedido")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonRootName("item_pedido")//só para xml
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_pedido_seq_id")
    @SequenceGenerator(name = "item_pedido_seq_id", sequenceName = "item_pedido_seq_id", allocationSize = 1)
    @EqualsAndHashCode.Include
    private Long id;

    private BigDecimal precoUnitario;
    private BigDecimal precoTotal;
    private Integer quantidade;
    private String observacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;;
}
