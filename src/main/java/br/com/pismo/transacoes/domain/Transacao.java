package br.com.pismo.transacoes.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACAO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
public class Transacao extends BaseDomain {

    @Id
    @Column(name = "IDTRANSACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALORTRANSACAO")
    private BigDecimal valorTransacao;

    @Column(name = "DATATRANSACAO")
    private Date dataTransacao;

    @ManyToOne
    @JoinColumn(name = "IDCONTA", referencedColumnName = "IDCONTA")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "IDTIPOOPERACAO")
    private TipoOperacao tipoOperacao;

}
