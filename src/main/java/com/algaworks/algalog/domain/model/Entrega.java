package com.algaworks.algalog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "entregas")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @Embedded
    private Destinatario destinatario;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_entrega")
    private StatusEntrega statusEntrega;
    private BigDecimal taxa;
    @Column(name = "data_pedido")
    private OffsetDateTime dataPedido;
    @Column(name = "data_finalizacao")
    private OffsetDateTime dataFinalizacao;


}
