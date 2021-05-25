package com.algaworks.algalog.api.resources;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaResource {

    private OffsetDateTime dataRegistro;
    private String descricao;
    private Long id;
}
