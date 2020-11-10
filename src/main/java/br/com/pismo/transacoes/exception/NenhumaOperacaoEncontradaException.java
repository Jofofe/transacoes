package br.com.pismo.transacoes.exception;

public class NenhumaOperacaoEncontradaException extends RuntimeException {

    public NenhumaOperacaoEncontradaException() {
        super("Nenhuma operação foi encontrada.");
    }

}
