package com.algaworks.algalog.domain.exceptions;

public class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String ocorrenciaDaOperacao) {
        super(ocorrenciaDaOperacao);
    }
}
