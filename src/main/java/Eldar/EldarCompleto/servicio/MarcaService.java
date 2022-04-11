package Eldar.EldarCompleto.servicio;

import Eldar.EldarCompleto.domain.Marca;
import Eldar.EldarCompleto.dto.MarcaRequest;

import java.util.List;

public interface MarcaService {

    void guardar(Marca marca);

    Marca encontrarMarca(Long idMarca);

    List<Marca> listarMarcas();
}
