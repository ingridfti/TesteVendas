package com.xbrain.vendas.modulos.vendedor.service;

import com.xbrain.vendas.modulos.venda.dto.VendaRequest;
import com.xbrain.vendas.modulos.venda.repository.VendaRepository;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendasResponse;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedorQuantidade;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import com.xbrain.vendas.modulos.vendedor.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository vendedorRepository;
    private final VendaRepository vendaRepository;

    // metodo usado internamente no VendaService (validar existencia do vendedor)
    public Vendedor buscarPorId(Long id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado com o ID: " + id));
    }

    // metodo p/ ser usado pelo VendedorController (endpoint de relatório)
    public List<RelatorioVendedor> listarResumoVendasPorPeriodo(VendaRequest request) {
        LocalDate dataInicio = request.getDataInicio();
        LocalDate dataFim = request.getDataFim();

        return vendaRepository.gerarRelatorioAgregado(dataInicio, dataFim)
                .stream()
                .map(r -> {
                    // converte média diaria (Double -> BigDecimal) p/ evitar erro de tipo
                    if (r.getMediaDiaria() != null) {
                        r.setMediaDiaria(
                                BigDecimal.valueOf(r.getMediaDiaria().doubleValue())
                                        .doubleValue()
                        );
                    }
                    return r;
                })
                .collect(Collectors.toList());
    }

    public RelatorioVendasResponse listarResumoQuantidadeVendas(VendaRequest request) {
        LocalDate dataInicio = request.getDataInicio();
        LocalDate dataFim = request.getDataFim();

        // obtém o relatório de qntd usando a query JPQL
        List<RelatorioVendedorQuantidade> relatorioQuantidade =
                vendaRepository.gerarRelatorioQuantidade(dataInicio, dataFim);

        // mapeia para o DTO de resposta interno (VendedorQuantidadeInner)
        List<RelatorioVendasResponse.VendedorQuantidadeInner> vendedoresFormatados = relatorioQuantidade.stream()
                .map(rq -> RelatorioVendasResponse.VendedorQuantidadeInner.builder()
                        .idVendedor(rq.getIdVendedor())
                        .nome(rq.getNomeVendedor())
                        .totalVendas(rq.getTotalVendas())
                        .mediaVendasDiarias(rq.getMediaVendasDiarias()) // calculo feito no DTO RelatorioVendedorQuantidade
                        .build())
                .collect(Collectors.toList());

        // monta o DTO de Resposta Wrapper (RelatorioVendasResponse)
        RelatorioVendasResponse.Periodo periodo = RelatorioVendasResponse.Periodo.builder()
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .build();

        return RelatorioVendasResponse.builder()
                .periodo(periodo)
                .vendedores(vendedoresFormatados)
                .build();
    }

    // atualizar e salvar qntd de vendas (será chamado na VendaService)
    public void atualizarQuantidadeVendas(Vendedor vendedor) {

        Integer totalAtual = vendedor.getTotalVendas();

        if (totalAtual == null) {
            vendedor.setTotalVendas(1);
        } else {
            vendedor.setTotalVendas(totalAtual + 1);
        }

        vendedorRepository.save(vendedor);
    }
}
