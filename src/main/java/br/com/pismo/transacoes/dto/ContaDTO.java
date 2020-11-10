package br.com.pismo.transacoes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContaDTO extends BaseDTO {

    private Integer id;

    @NotBlank(message = "{numDocumento.not.blank}")
    private String numDocumento;

}
