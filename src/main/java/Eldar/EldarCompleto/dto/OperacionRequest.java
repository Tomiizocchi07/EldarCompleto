package Eldar.EldarCompleto.dto;

import Eldar.EldarCompleto.domain.Persona;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacionRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDOperacion", example = "11245255587",required = true)
    private Long idOperacion;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDPersona", example = "1254",required = true)
    private Long idPersona;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDTarjeta", example = "552448651",required = true)
    private Long idTarjeta;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Monto", example = "600",required = true)
    private double monto;
}
