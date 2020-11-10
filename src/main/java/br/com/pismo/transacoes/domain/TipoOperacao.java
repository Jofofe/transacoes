package br.com.pismo.transacoes.domain;

import br.com.pismo.transacoes.enums.EnumOperacaoMatematica;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOOPERACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class TipoOperacao extends BaseDomain {

    @Id
    @Column(name = "IDTIPOOPERACAO")
    private Integer id;

    @Column(name = "DESCOPERACAO", nullable = false)
    private String descricao;

    @Column(name = "OPERACAOMATEMATICA", nullable = false)
    private EnumOperacaoMatematica operacaoMatematica;

}
