package com.xbrain.vendas.modulos.vendedor.controller;

import com.xbrain.vendas.modulos.venda.dto.VendaRequest;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendasResponse;
import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import com.xbrain.vendas.modulos.vendedor.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping("/relatorio")
    public List<RelatorioVendedor> gerarRelatorio(@RequestBody VendaRequest request) {
        return vendedorService.listarResumoVendasPorPeriodo(request);
    }

    // retorna QUANTIDADE vendas
    @PostMapping("/relatorio/quantidade")
    public RelatorioVendasResponse gerarRelatorioQuantidade(@RequestBody VendaRequest request) {
        return vendedorService.listarResumoQuantidadeVendas(request);
    }
    @GetMapping("/{id}")
    public Vendedor getVendedor(@PathVariable Long id){
        return vendedorService.buscarPorId(id);
    }
}
