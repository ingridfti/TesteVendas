package com.xbrain.vendas.modulos.venda.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xbrain.vendas.modulos.itemVenda.model.ItemVenda;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    @Column(name = "id_venda")
    private Long id_venda;

    @Column
    private LocalDate dataVenda;

    @Column
    private BigDecimal valorTotalVenda;

    @JoinColumn(name = "FK_VENDEDOR", foreignKey = @ForeignKey(name = "FK_VENDEDOR"), nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Vendedor vendedor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JoinColumn(name = "venda_id")
    private List<ItemVenda> itens;

    public static Venda of(Vendedor vendedor) {
        return Venda.builder()
                .vendedor(vendedor)
                .dataVenda(LocalDate.now())
                .valorTotalVenda(BigDecimal.ZERO)
                .build();
    }
}
