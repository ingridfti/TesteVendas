package com.xbrain.vendas.modulos.vendedor.service;

import com.xbrain.vendas.modulos.venda.repository.VendaRepository;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import com.xbrain.vendas.modulos.vendedor.repository.VendedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    // Método para ser usado internamente no VendaService (para checar se o vendedor existe)
    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado com o ID: " + id));
    }

    // metodo p/ ser usado pelo VendedorController (ENDPOINT)
    public List<RelatorioVendedor> listarResumoVendasPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return vendaRepository.gerarRelatorioAgregado(dataInicio, dataFim);
    }
}