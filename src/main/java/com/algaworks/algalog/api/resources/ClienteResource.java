package com.algaworks.algalog.api.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResource {

    private Long id;
    private String nomeCliente;
    private String email;
    private String telefone;
}
