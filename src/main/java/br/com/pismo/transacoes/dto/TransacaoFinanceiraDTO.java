package br.com.pismo.transacoes.dto;

import br.com.pismo.transacoes.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransacaoFinanceiraDTO extends BaseDomain {

    private Integer idConta;

    private Integer idOperacao;

    private BigDecimal valorTransacao;
}
