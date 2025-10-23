package com.xbrain.vendas.modulos.vendedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * DTO intermediário para receber os resultados da query de COUNT (Quantidade de Vendas).
 * Implementa @AllArgsConstructor para a projeção JPQL.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioVendedorQuantidade {

    private Long idVendedor;
    private String nomeVendedor;
    private Long totalVendas; // <-- Recebe o COUNT(v.id_venda) (Long)
    private Long diasAtivos;

    public Double getMediaVendasDiarias() {
        if (totalVendas == null || diasAtivos == null || diasAtivos == 0) {
            return 0.0;
        }
        // média da QUANTIDADE, formatado para 2 casas decimais
        return BigDecimal.valueOf(totalVendas)
                .divide(BigDecimal.valueOf(diasAtivos), 2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}