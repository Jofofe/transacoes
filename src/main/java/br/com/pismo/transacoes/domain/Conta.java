package br.com.pismo.transacoes.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Entity
@Table(name = "CONTA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Conta extends BaseDomain {

    @Id
    @Column(name = "IDCONTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NUMDOCUMENTO", nullable = false)
    private String numDocumento;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    private List<Transacao> transacoes;

    public void addTransacao(Transacao transacao) {
        if(nonNull(transacao)) {
            if(isNull(this.transacoes)) {
                this.transacoes = new ArrayList<>();
            }
            transacao.setConta(this);
            this.transacoes.add(transacao);
        }
    }

}
