package br.com.pismo.transacoes.domain;

import br.com.pismo.transacoes.enums.Operacao;
import lombok.*;

import javax.persistence.*;

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

    public TipoOperacao(Operacao operacao) {
        this.id = operacao.getId();
        this.descricao = operacao.getDescricao();
    }


}
