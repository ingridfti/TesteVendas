package com.xbrain.vendas.modulos.venda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaRequest {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long produtoId;
}
