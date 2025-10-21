package com.xbrain.vendas.modulos.itemVenda.service;

import com.xbrain.vendas.modulos.itemVenda.dto.ItemVendaRequest;
import com.xbrain.vendas.modulos.itemVenda.model.ItemVenda;
import com.xbrain.vendas.modulos.itemVenda.repository.ItemVendaRepository;
import com.xbrain.vendas.modulos.produto.model.Produto;
import com.xbrain.vendas.modulos.produto.service.ProdutoService;
import com.xbrain.vendas.modulos.venda.model.Venda;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemVendaService {

    // o rpository é injetado, mesmo que o save seja feito pelo cascade da Venda
    private final ItemVendaRepository itemVendaRepository;
    private final ProdutoService produtoService;

    /**
     * Mapeia os DTOs de ItemVendaRequest para Entidades ItemVenda,
     * busca o preço atual do Produto e anexa o Item à Venda principal.
     */
    public List<ItemVenda> criarItensVenda(List<ItemVendaRequest> itensRequest, Venda vendaEntidade) {

        return itensRequest.stream().map(itemRequest -> {

            // busca o Produto pelo ID para obter o preço e a entidade
            Produto produto = produtoService.buscarPorId(itemRequest.getProdutoId());

            // captura o preço unitário atual do produto para registrar na transação
            BigDecimal precoUnitario = produto.getValorUnitario();

            // converte para a Entidade ItemVenda
            return ItemVenda.builder()
                    .venda(vendaEntidade) // anexa o Item à Venda
                    .produto(produto)
                    .quantidade(itemRequest.getQuantidade())
                    .precoVenda(precoUnitario) // salva o preço no momento da transação
                    .build();

        }).collect(Collectors.toList());
    }
}