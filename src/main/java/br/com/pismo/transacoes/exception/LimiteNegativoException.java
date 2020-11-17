package br.com.pismo.transacoes.exception;

public class LimiteNegativoException extends RuntimeException {

    public LimiteNegativoException() {
        super("Limite negativo para a criação da conta");
    }
}
