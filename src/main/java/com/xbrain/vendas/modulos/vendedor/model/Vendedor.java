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
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Long idVendedor;

    @Column(name = "nome_vendedor")
    private String nomeVendedor;

    @Column(name = "total_vendas")
    private Integer totalVendas;

    @Column(name = "vendas_diaria")
    private Double vendasDiaria;

    // esse metodo é pra criar um obj de vendedor, seria usado para criar um novo vendedor
    /*public static Vendedor of(VendedorRequest request){
        return Vendedor.builder()
                .nomeVendedor(request.getNomeVendedor())
                .build();
    }*/
}

