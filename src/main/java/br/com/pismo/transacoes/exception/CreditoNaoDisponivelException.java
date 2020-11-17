package br.com.pismo.transacoes.exception;

public class CreditoNaoDisponivelException extends RuntimeException {

    public CreditoNaoDisponivelException() {
        super("Credito não disponivel para essa operação");
    }
}
