package com.algaworks.algalog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ocorrencias")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ocorrencia {

    @NotNull
    private OffsetDateTime dataRegistro;
    @NotNull
    private String descricao;
    @ManyToOne
    private Entrega entrega;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    private Long id;
}
