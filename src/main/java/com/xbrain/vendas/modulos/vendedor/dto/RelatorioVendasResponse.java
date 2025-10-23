package com.xbrain.vendas.modulos.vendedor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO que encapsula a resposta final do relatório, contendo o período e a lista de vendedores.
 * Usado para atender o formato JSON da imagem de exemplo.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioVendasResponse {

    private Periodo periodo;
    private List<VendedorQuantidadeInner> vendedores;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Periodo {
        private LocalDate dataInicio;
        private LocalDate dataFim;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VendedorQuantidadeInner {
        private Long idVendedor;
        private String nome;
        private Long totalVendas;
        private Double mediaVendasDiarias;
    }
}