package br.com.pismo.transacoes.exception.handler;

import br.com.pismo.transacoes.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ContaNaoEncontradaException.class})
    public ResponseEntity contaNaoEncontrada(ContaNaoEncontradaException ex, WebRequest request) {
        log.debug("manipulação de ContaNaoEncontradaException...");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ContaExistenteException.class})
    public ResponseEntity contaExistente(ContaExistenteException ex, WebRequest request) {
        log.debug("manipulação de ContaExistenteException...");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NenhumaOperacaoEncontradaException.class})
    public ResponseEntity nenhumaOperacaoEncontrada(NenhumaOperacaoEncontradaException ex, WebRequest request) {
        log.debug("manipulação de NenhumaOperacaoEncontrada...");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CreditoNaoDisponivelException.class})
    public ResponseEntity creditoNaoDisponivel(CreditoNaoDisponivelException ex, WebRequest request) {
        log.debug("manipulação de CreditoNaoDisponivelException...");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {LimiteNegativoException.class})
    public ResponseEntity limiteNegativo(LimiteNegativoException ex, WebRequest request) {
        log.debug("manipulação de LimiteNegativoException...");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.debug("manipulação de MethodArgumentNotValidException...");
        List<String> errors = getErrors(ex);
        return new ResponseEntity<>(errors, status);
    }

    private List<String> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());
    }

}
