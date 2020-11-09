package br.com.pismo.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaDTO extends BaseDTO {

    private Integer id;

    private String numDocumento;

    private List<TransacaoDTO> transacoes;

}
