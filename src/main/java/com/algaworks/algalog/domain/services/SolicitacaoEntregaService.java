package com.algaworks.algalog.domain.services;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collection;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private final ClienteService clienteService;
    private final EntregaRepository entregaRepository;

    public Collection<Entrega> listarEntregas() {
        return entregaRepository.findAll();
    }

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        var clienteEntrega = clienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(clienteEntrega);
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.UTC));
        return entregaRepository.save(entrega);
    }


}
