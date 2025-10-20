package com.xbrain.vendas.modulos.vendedor.model;

import com.xbrain.vendas.modulos.vendedor.dto.VendedorRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idVendedor;

    @Column
    private String nomeVendedor;

    // esse metodo é pra criar um obj de vendedor
    public static Vendedor of(VendedorRequest request){
        return Vendedor.builder()
                .nomeVendedor(request.getNome_vendedor())
                .build();
    }

}

