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

    @Column(name = "VALORTRANSACAO", nullable = false)
    private BigDecimal valorTransacao;

    @Column(name = "DATATRANSACAO", nullable = false)
    private Date dataTransacao;

    @ManyToOne
    @JoinColumn(name = "IDCONTA", nullable = false, referencedColumnName = "IDCONTA")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "IDTIPOOPERACAO", nullable = false)
    private TipoOperacao tipoOperacao;

}
