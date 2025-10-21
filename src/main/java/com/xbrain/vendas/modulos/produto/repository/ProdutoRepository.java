package com.xbrain.vendas.modulos.produto.repository;

import com.xbrain.vendas.modulos.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}