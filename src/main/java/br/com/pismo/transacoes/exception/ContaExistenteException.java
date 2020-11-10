package br.com.pismo.transacoes.exception;

public class ContaExistenteException extends RuntimeException {

    public ContaExistenteException() {
        super("Conta já existente na base de dados.");
    }


}
