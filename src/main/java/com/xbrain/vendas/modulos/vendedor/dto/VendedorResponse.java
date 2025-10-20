package com.xbrain.vendas.modulos.vendedor.dto;

import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendedorResponse {
    private Long id_vendedor;
    private String nome_vendedor;

    public static VendedorResponse of(Vendedor vendedor) {
        return VendedorResponse.builder()
                .id_vendedor(vendedor.getId_vendedor())
                .nome_vendedor(vendedor.getNome_vendedor())
                .build();
    }
}
