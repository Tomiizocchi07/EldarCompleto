package Eldar.EldarCompleto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarcaRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDMarca", example = "115455587",required = true)
    private Long idMarca;

}
