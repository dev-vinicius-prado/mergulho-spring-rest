package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mappers.EntregaMapper;
import com.algaworks.algalog.api.resources.EntregaResource;
import com.algaworks.algalog.domain.services.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
@RequestMapping("/entregas")
@AllArgsConstructor
public class EntregaController {

    private EntregaMapper entregaMapper;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @GetMapping
    public ResponseEntity<Collection<EntregaResource>> listar() {
        return ResponseEntity.ok(entregaMapper
                .toCollection(solicitacaoEntregaService.listarEntregas()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EntregaResource> solicitarEntrega(@Valid @RequestBody EntregaResource entregaResource) {
        final var entrega = solicitacaoEntregaService.solicitar(entregaMapper.toEntity(entregaResource));
        return ResponseEntity.ok(entregaMapper.toResource(entrega));
    }
}
