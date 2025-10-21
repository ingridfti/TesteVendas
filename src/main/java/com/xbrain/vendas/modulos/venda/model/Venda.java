package com.xbrain.vendas.modulos.venda.model;

import com.xbrain.vendas.modulos.itemVenda.model.ItemVenda;
import com.xbrain.vendas.modulos.produto.model.Produto;
import com.xbrain.vendas.modulos.venda.dto.VendaRequest;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id_venda;

    @Column
    private LocalDate dataVenda;

    @Column
    private BigDecimal valorTotalVenda;

    @JoinColumn(name = "FK_VENDEDOR", foreignKey = @ForeignKey(name = "FK_VENDEDOR"), nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;


    /*
    Fica para uma atualizacao futura, nao esta sendo usado no momento
    public static Venda of(VendaRequest request, Vendedor vendedor, Produto produto, List<ItemVenda> itens) {
        return Venda.builder()
                .vendedor(vendedor)
                .valorTotalVenda(valorTotal)
                .itens(itens)
                .dataVenda(new Date())
                .build();
    }*/
}
