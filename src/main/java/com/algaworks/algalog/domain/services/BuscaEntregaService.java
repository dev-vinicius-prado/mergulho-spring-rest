package com.algaworks.algalog.domain.services;

import com.algaworks.algalog.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long idEntrega) {
        return entregaRepository
                .findById(idEntrega).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
    }


}
