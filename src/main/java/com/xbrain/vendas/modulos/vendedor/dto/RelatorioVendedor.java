package com.xbrain.vendas.modulos.vendedor.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class RelatorioVendedor {
    private String nomeVendedor;
    private BigDecimal totalVendas;
    private Double mediaDiaria;

    public RelatorioVendedor(String nomeVendedor, BigDecimal totalVendas, Long diasAtivos) {
        this.nomeVendedor = nomeVendedor;
        this.totalVendas = totalVendas;
        if (diasAtivos != null && diasAtivos > 0) {
            this.mediaDiaria = totalVendas
                    .divide(BigDecimal.valueOf(diasAtivos), 2, RoundingMode.HALF_UP)
                    .doubleValue();
        } else {
            this.mediaDiaria = 0.0;
        }
    }
}
