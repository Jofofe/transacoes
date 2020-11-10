package br.com.pismo.transacoes.dto;

import br.com.pismo.transacoes.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransacaoDTO extends BaseDomain {

    private Integer id;

    private BigDecimal valorTransacao;

    private Date dataTransacao;

    private TipoOperacaoDTO tipoOperacao;

}
