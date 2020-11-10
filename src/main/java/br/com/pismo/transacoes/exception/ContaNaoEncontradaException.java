package br.com.pismo.transacoes.exception;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Nenhuma conta foi encontrada.");
    }

}
