package com.xbrain.vendas.modulos.venda.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class VendaResponse {

    private Long id_venda;
    private LocalDate dataVenda;
    private BigDecimal valorTotalVenda;
    private String nomeVendedor;

    // Em um cenário completo, esta lista seria de um ItemVendaResponse
    private List<String> itensVendidos;

}