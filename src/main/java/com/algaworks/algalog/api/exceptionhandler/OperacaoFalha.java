package com.algaworks.algalog.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperacaoFalha {

    private Integer status;
    private LocalDateTime hora;
    private String mensagem;
    private Collection<Campo> campos;

    @AllArgsConstructor
    @Getter
    @Builder
    static class Campo {
        private String nome;
        private String mensagem;

    }

}
