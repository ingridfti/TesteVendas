package com.xbrain.vendas.modulos.venda.repository;

import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

// precisei de ajuda do chat com o JPA e as anotaçoes, e tb de ajuda com a lógica
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT new com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor(" +
            "vdd.nome_vendedor, " +
            "SUM(vd.valorTotalVenda), " +
            "SUM(vd.valorTotalVenda) / COUNT(DISTINCT vd.dataVenda)) " +
            "FROM Vendas vd JOIN vd.vendedor vdd " +
            "WHERE vd.dataVenda BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY vdd.nome_vendedor")

    List<RelatorioVendedor> gerarRelatorio (@Param("dataInicio") LocalDate dataInicio,
                                            @Param("dataFim") LocalDate dataFim);
}