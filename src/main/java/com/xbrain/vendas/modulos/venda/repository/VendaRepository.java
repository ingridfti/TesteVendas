package com.xbrain.vendas.modulos.venda.repository;

import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    @Query("SELECT new com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor(" +
            "v.vendedor.nomeVendedor, " +
            "SUM(v.valorTotalVenda), " +
            "COUNT(DISTINCT v.dataVenda)) " +
            "FROM Venda v " +
            "WHERE v.dataVenda BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY v.vendedor.nomeVendedor, v.vendedor.idVendedor")
    List<RelatorioVendedor> gerarRelatorioAgregado(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
}



