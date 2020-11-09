package br.com.pismo.transacoes.enums;

import br.com.pismo.transacoes.exception.NenhumaOperacaoEncontrada;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum Operacao implements Serializable {

    APROVADA(1,"COMPRA A VISTA"),
    REJEITADA(2,"COMPRA PARCELADA"),
    CANCELADA(3,"SAQUE"),
    PROCESSANDO(4,"PAGAMENTO");

    private Integer id;
    private String descricao;

    public static Operacao valueOfById(final Integer id) throws NenhumaOperacaoEncontrada {
        for(Operacao operacao : Operacao.values()) {
            if(operacao.getId() == id) {
                return operacao;
            }
        }
        throw new NenhumaOperacaoEncontrada();
    }

}
