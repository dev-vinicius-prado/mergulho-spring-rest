package com.algaworks.algalog.domain.model;

import com.algaworks.algalog.domain.validations.ValidationsGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
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

    @Valid
    @ConvertGroup(to = ValidationsGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_entrega")
    private StatusEntrega statusEntrega;
    @NotNull
    private BigDecimal taxa;
    @Column(name = "data_pedido")
    private OffsetDateTime dataPedido;
    @Column(name = "data_finalizacao")
    private OffsetDateTime dataFinalizacao;


}
