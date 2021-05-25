package com.algaworks.algalog.api.resources;

import com.algaworks.algalog.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaResource {

    private ClienteResource cliente;
    private OffsetDateTime dataFinalizacao;
    private OffsetDateTime dataPedido;
    private DestinatarioResource destinatario;
    private Long id;
    private StatusEntrega statusEntrega;
    private BigDecimal taxa;


}
