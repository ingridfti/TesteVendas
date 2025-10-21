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
    private Long idVendedor;
    private String nomeVendedor;

    public static VendedorResponse of(Vendedor vendedor) {
        return VendedorResponse.builder()
                .idVendedor(vendedor.getIdVendedor())
                .nomeVendedor(vendedor.getNomeVendedor())
                .build();
    }
}
