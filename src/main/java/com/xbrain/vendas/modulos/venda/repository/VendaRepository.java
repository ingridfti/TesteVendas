package com.xbrain.vendas.modulos.venda.repository;

import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedorQuantidade;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("""
            SELECT new com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor(
                v.vendedor.nomeVendedor,
                SUM(v.valorTotalVenda),
                COUNT(DISTINCT v.dataVenda)
            )
            FROM Venda v
            WHERE v.dataVenda BETWEEN :dataInicio AND :dataFim
            GROUP BY v.vendedor.nomeVendedor
            """)
    List<RelatorioVendedor> gerarRelatorioAgregado(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim);


    @Query("""
            SELECT new com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedorQuantidade(
                v.vendedor.idVendedor,
                v.vendedor.nomeVendedor,
                COUNT(v.id_venda),
                COUNT(DISTINCT v.dataVenda)
            )
            FROM Venda v
            WHERE v.dataVenda BETWEEN :dataInicio AND :dataFim
            GROUP BY v.vendedor.idVendedor, v.vendedor.nomeVendedor
            """)
    List<RelatorioVendedorQuantidade> gerarRelatorioQuantidade(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim);

    @Query("SELECT COUNT(DISTINCT v.dataVenda) FROM Venda v WHERE v.vendedor.idVendedor = :idVendedor")
    Long countDistinctDaysByVendedor(@Param("idVendedor") Long idVendedor);
}


