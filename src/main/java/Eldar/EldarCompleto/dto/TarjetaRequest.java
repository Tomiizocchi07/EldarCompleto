package Eldar.EldarCompleto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "NumeroTarjeta", example = "115455587",required = true)
    private String numeroTarjeta;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Fecha de Vencimiento",required = true)
    private Date fechaVencimiento;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDTarjeta", example = "552214812",required = true)
    private Long idTarjeta;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDMarca", example = "11254",required = true)
    private Long idMarca;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "IDPersona", example = "11285478",required = true)
    private Long idPersona;

}
