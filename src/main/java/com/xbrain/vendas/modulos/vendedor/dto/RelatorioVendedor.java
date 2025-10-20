package com.xbrain.vendas.modulos.vendedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class RelatorioVendedor {
    private String nomeVendedor;
    private BigDecimal totalVendas;
    private BigDecimal mediaDiaria;
}
