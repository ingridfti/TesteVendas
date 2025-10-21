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
@Table(name="item_venda") // Alterado para minúsculo, conforme a criação da tabela
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item") // Corrigido para minúsculo
    private Long id;

    @Column(name = "quantidade", nullable = false) // Corrigido para minúsculo
    private Integer quantidade;

    // Relacionamento Many-to-One com Venda
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false) // Corrigido para minúsculo
    private Venda venda;

    // Relacionamento Many-to-One com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false) // Corrigido para minúsculo
    private Produto produto;

    @Column(name = "preco_venda", nullable = false, precision = 10, scale = 2) // Corrigido para minúsculo
    private BigDecimal precoVenda;

    @Transient
    public BigDecimal getSubtotal() {
        if (precoVenda == null || quantidade == null) {
            return BigDecimal.ZERO;
        }
        return precoVenda.multiply(new BigDecimal(quantidade));
    }
}