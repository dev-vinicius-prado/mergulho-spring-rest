package com.algaworks.algalog.domain.model;

import com.algaworks.algalog.domain.validations.ValidationsGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationsGroups.ClienteId.class)
    private Long id;
    @NotBlank
    @Size(max = 60)
    private String nome;
    @Email
    @NotBlank
    @Size(max = 255)
    private String email;
    @Size(max = 20)
    private String telefone;

}
