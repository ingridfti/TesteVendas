package com.xbrain.vendas.modulos.venda.service;

import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.venda.repository.VendaRepository;
// O import de RelatorioVendedor foi removido
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;

    public List<Venda> buscarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        log.info("Buscando vendas entre {} e {}", dataInicio, dataFim);
        return vendaRepository.findByDataVendaBetween(dataInicio, dataFim);
    }

    public Venda buscarPorId(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada."));
    }
}