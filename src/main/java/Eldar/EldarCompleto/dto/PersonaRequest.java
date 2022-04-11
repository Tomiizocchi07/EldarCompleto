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
public class PersonaRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IdPersona", example = "68547",required = true)
    private Long IDPersona;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Nombre", example = "Juan",required = true)
    private String nombre;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Apellido", example = "Perez",required = true)
    private String apellido;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "DNI", example = "42563589",required = true)
    private String DNI;

}
