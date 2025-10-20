package com.xbrain.vendas.modulos.vendedor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VendedorRequest {

    private Long id_vendedor;
    private String nome_vendedor;
}
