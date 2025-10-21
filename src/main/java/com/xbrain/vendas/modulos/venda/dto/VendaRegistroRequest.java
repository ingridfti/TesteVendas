package com.xbrain.vendas.modulos.venda.dto;

import com.xbrain.vendas.modulos.itemVenda.dto.ItemVendaRequest; // IMPORTAÇÃO CORRETA
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaRegistroRequest {

    private Long vendedorId;
    private List<ItemVendaRequest> itens;

}