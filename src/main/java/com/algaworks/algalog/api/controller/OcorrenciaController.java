package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.mappers.OcorrenciaMapper;
import com.algaworks.algalog.api.resources.OcorrenciaResource;
import com.algaworks.algalog.domain.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.services.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private OcorrenciaMapper ocorrenciaMapper;
    private RegistroOcorrenciaService registroOcorrenciaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OcorrenciaResource> registrar(@PathVariable Long entregaId,
                                                        @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
        final var ocorrencia = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());
        return ResponseEntity.ok(ocorrenciaMapper.toResource(ocorrencia));
    }
}
