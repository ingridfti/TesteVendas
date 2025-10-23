package com.xbrain.vendas.modulos.venda.service;

import com.xbrain.vendas.modulos.itemVenda.service.ItemVendaService;
import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.venda.repository.VendaRepository;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.repository.VendedorRepository;
import com.xbrain.vendas.modulos.vendedor.service.VendedorService;
import com.xbrain.vendas.modulos.venda.dto.VendaRegistroRequest;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import com.xbrain.vendas.modulos.itemVenda.model.ItemVenda;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final VendedorService vendedorService;
    private final ItemVendaService itemVendaService;
    private final VendedorRepository vendedorRepository;

    @Transactional
    public Venda salvarVenda(VendaRegistroRequest request) {

        Vendedor vendedor = vendedorService.buscarPorId(request.getVendedorId());

        var novaVenda = Venda.of(vendedor);

        List<ItemVenda> itensVendidos = itemVendaService.criarItensVenda(request.getItens(), novaVenda);

        BigDecimal valorTotal = itensVendidos.stream()
                .map(ItemVenda::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        novaVenda.setValorTotalVenda(valorTotal);
        novaVenda.setItens(itensVendidos);

        vendedorService.atualizarQuantidadeVendas(vendedor);

        // ATUALIZAÇÃO vendasDiaria / calculo no Service
        Integer totalVendas = vendedor.getTotalVendas();
        Long diasAtivos = vendaRepository.countDistinctDaysByVendedor(vendedor.getIdVendedor());

        // garante q o calculo nao divida por 0 na primeira venda (o count retorna 1 após o save, mas 0 antes)
        if (diasAtivos == null || diasAtivos == 0) {
            diasAtivos = 1L;
        }

        double mediaDiaria = totalVendas.doubleValue() / diasAtivos.doubleValue();
        vendedor.setVendasDiaria(mediaDiaria);

        vendedorRepository.save(vendedor);
        return vendaRepository.save(novaVenda);
    }

    // listar
    public List<Venda> buscarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        log.info("Buscando vendas entre {} e {}", dataInicio, dataFim);
        return vendaRepository.findByDataVendaBetween(dataInicio, dataFim);
    }

    // listar
    public List<RelatorioVendedor> gerarRelatorioDeVendas(LocalDate dataInicio, LocalDate dataFim) {
        log.info("Gerando relatório agregado de vendas entre {} e {}", dataInicio, dataFim);
        return vendaRepository.gerarRelatorioAgregado(dataInicio, dataFim);
    }

    // listar vendas
    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada."));
    }
}