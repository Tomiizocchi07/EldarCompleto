package Eldar.EldarCompleto.servicio;

import Eldar.EldarCompleto.domain.Operacion;
import Eldar.EldarCompleto.domain.Tarjeta;

import java.util.List;

public interface TarjetaService {

    List<Tarjeta> listarTarjetas();

    void guardar(Tarjeta tarjeta);

    void eliminar(Tarjeta tarjeta);

    Tarjeta encontrarTarjeta (Long idTarjeta);
}
