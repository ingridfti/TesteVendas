package com.xbrain.vendas.modulos.venda.controller;

import com.xbrain.vendas.modulos.venda.dto.VendaRegistroRequest;
import com.xbrain.vendas.modulos.venda.model.Venda;
import com.xbrain.vendas.modulos.venda.service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@AllArgsConstructor
public class VendaController {

    private final VendaService vendaService;

    // POST criaçao de Venda, retorna direto com status 201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda salvarVenda(@RequestBody VendaRegistroRequest request) {
        return vendaService.salvarVenda(request);
    }

    // GET busca e retorna direto da Lista
    @GetMapping
    public List<Venda> buscarVendasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {

        return vendaService.buscarPorPeriodo(dataInicio, dataFim);
    }

    // GET busca por id e retorna direto do obj
    @GetMapping("/{id}")
    public Venda buscarPorId(@PathVariable Long id) {
        return vendaService.buscarPorId(id);
    }
}