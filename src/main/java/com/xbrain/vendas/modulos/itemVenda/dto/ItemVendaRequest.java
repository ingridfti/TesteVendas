package com.xbrain.vendas.modulos.itemVenda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVendaRequest {

    private Long produtoId;
    private Integer quantidade;
}