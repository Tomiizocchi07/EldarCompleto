package Eldar.EldarCompleto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarjetaResponse {

    private Long idTarjeta;
    private String numeroTarjeta;
    private Date fechaVencimiento;
    private MarcaResponse idMarca;
    private PersonaResponse idPersona;

}
