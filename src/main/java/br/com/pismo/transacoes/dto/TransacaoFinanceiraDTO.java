package br.com.pismo.transacoes.dto;

import br.com.pismo.transacoes.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransacaoFinanceiraDTO extends BaseDomain {

    @NotNull(message = "{idConta.not.null}")
    private Integer idConta;

    @NotNull(message = "{idOperacao.not.null}")
    private Integer idOperacao;

    @NotNull(message = "{valorTransacao.not.null}")
    private BigDecimal valorTransacao;
}
