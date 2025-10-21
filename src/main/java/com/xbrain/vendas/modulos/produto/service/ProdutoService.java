package com.xbrain.vendas.modulos.produto.service;

import com.xbrain.vendas.modulos.produto.model.Produto;
import com.xbrain.vendas.modulos.produto.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto buscarPorId(Long id) {
        // retornar o produto ou lançar exceção se não for encontrado
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }
}

