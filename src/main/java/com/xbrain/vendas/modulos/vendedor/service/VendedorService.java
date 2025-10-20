package com.xbrain.vendas.modulos.vendedor.service;

import com.xbrain.vendas.modulos.vendedor.model.Vendedor;
import com.xbrain.vendas.modulos.vendedor.repository.VendedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public Vendedor getById(Long id_vendedor) throws ChangeSetPersister.NotFoundException {
        return vendedorRepository.findById(id_vendedor).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Vendedor não encontrado"));
    }
}