package br.com.pismo.transacoes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumOperacaoMatematica {

    ADICAO((short)1),
    SUBTRACAO((short)-1);

    private Short numeroOperacao;

}
