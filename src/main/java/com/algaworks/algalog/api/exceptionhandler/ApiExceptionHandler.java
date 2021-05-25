package com.algaworks.algalog.api.exceptionhandler;

import com.algaworks.algalog.domain.exceptions.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.exceptions.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String OCORRENCIA_VALIDACAO = "api.ocorrencia.validacao";
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, getOcorrenciaFalha(ex, status), headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        var operacaoFalha = OperacaoFalha.builder()
                .hora(LocalDateTime.now())
                .status(badRequest.value())
                .mensagem(ex.getMessage())
                .build();
        return handleExceptionInternal(ex, operacaoFalha, new HttpHeaders(), badRequest, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        var operacaoFalha = OperacaoFalha.builder()
                .hora(LocalDateTime.now())
                .status(badRequest.value())
                .mensagem(ex.getMessage())
                .build();
        return handleExceptionInternal(ex, operacaoFalha, new HttpHeaders(), badRequest, request);
    }

    private OperacaoFalha getOcorrenciaFalha(MethodArgumentNotValidException falhas, HttpStatus status) {
        Collection<OperacaoFalha.Campo> campos = falhas.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    String nome = ((FieldError) error).getField();
                    String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
                    return OperacaoFalha.Campo.builder()
                            .nome(nome)
                            .mensagem(mensagem)
                            .build();
                }).collect(Collectors.toList());

        return OperacaoFalha.builder()
                .campos(campos)
                .hora(LocalDateTime.now())
                .status(status.value())
                .mensagem(messageSource.getMessage(OCORRENCIA_VALIDACAO, null, LocaleContextHolder.getLocale()))
                .build();

    }
}
