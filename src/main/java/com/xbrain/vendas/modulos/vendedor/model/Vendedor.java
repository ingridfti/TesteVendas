package com.xbrain.vendas.modulos.vendedor.model;

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
@Table(name = "VENDEDOR")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long idVendedor;

    @Column
    private String nomeVendedor;

    // esse metodo é pra criar um obj de vendedor, seria usado para criar um novo vendedor
    /*public static Vendedor of(VendedorRequest request){
        return Vendedor.builder()
                .nomeVendedor(request.getNomeVendedor())
                .build();
    }*/
}

