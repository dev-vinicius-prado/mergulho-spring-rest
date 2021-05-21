package com.algaworks.algalog.domain.exceptions;

public class NegocioException extends RuntimeException {
    public NegocioException(String ocorrenciaDaOperacao) {
        super(ocorrenciaDaOperacao);
    }
}
