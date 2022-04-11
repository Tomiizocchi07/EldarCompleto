package Eldar.EldarCompleto.dto;

import Eldar.EldarCompleto.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OperacionResponse {

    private Long idOperacion;
    private TarjetaResponse idTarjeta;
    private double monto;
    private float tasaOperacion;

}
