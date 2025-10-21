package com.xbrain.vendas.modulos.vendedor.controller;

import com.xbrain.vendas.modulos.vendedor.dto.RelatorioVendedor;
import com.xbrain.vendas.modulos.vendedor.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @GetMapping("/relatorio")
    public ResponseEntity<List<RelatorioVendedor>> gerarRelatorio(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim) {

        List<RelatorioVendedor> relatorio = vendedorService.listarResumoVendasPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(relatorio);
    }
}
