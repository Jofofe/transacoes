package br.com.pismo.transacoes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Nenhuma operação foi encontrada.")
public class NenhumaOperacaoEncontrada extends RuntimeException {

    public NenhumaOperacaoEncontrada() {
        super("Nenhuma operação foi encontrada.");
    }

}
