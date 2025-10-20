package com.xbrain.vendas.modulos.vendedor.repository;

import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
}
