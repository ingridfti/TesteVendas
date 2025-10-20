package com.xbrain.vendas.modulos.itemVenda.model;

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
@Table(name="ITEM_VENDA")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;

    private BigDecimal precoVenda;
}
