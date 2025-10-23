package com.xbrain.vendas.modulos.itemVenda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xbrain.vendas.modulos.produto.model.Produto;
import com.xbrain.vendas.modulos.venda.model.Venda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    @Column(name = "quantidade")
    private Integer quantidade;

    // relacionamento Many-to-One com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "venda_id")
    private com.xbrain.vendas.modulos.venda.model.Venda venda;

    @Column(name = "preco_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoVenda;

    @Transient
    public BigDecimal getSubtotal() {
        if (precoVenda == null || quantidade == null) {
            return BigDecimal.ZERO;
        }
        return precoVenda.multiply(new BigDecimal(quantidade));
    }

    public static ItemVenda of(Venda venda, Produto produto, BigDecimal precoUnitario, Integer quantidade) {
        return ItemVenda.builder()
                .venda(venda)
                .produto(produto)
                .quantidade(quantidade)
                .precoVenda(precoUnitario)
                .build();
    }
}