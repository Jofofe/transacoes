package br.com.pismo.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InformacaoContaDTO extends BaseDTO {

    @NotBlank(message = "{numDocumento.not.blank}")
    private String numDocumento;

}
