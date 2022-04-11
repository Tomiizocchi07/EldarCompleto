package Eldar.EldarCompleto.controlador;

import Eldar.EldarCompleto.common.EntityDTOConverter;
import Eldar.EldarCompleto.domain.Marca;
import Eldar.EldarCompleto.dto.MarcaResponse;
import Eldar.EldarCompleto.exception.BadRequestException;
import Eldar.EldarCompleto.exception.ExceptionMessage;
import Eldar.EldarCompleto.exception.MarcaNotFoundException;
import Eldar.EldarCompleto.servicio.MarcaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
public class ControladorMarca {

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @ApiOperation(value = "Obtiene una marca", notes = "Esta operacion devuelve una marca basada en su ID")
    @GetMapping("/marca/{marcaId}")
    public ResponseEntity<MarcaResponse> ObtenerMarca(@PathVariable Long marcaId){
        try{
            Marca marca = marcaService.encontrarMarca(marcaId);
            return new ResponseEntity<> (entityDTOConverter.convertMarcatoDTO(marca), HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            throw new MarcaNotFoundException(ExceptionMessage.MARCA_INCORRECTA.getValue());
        }

    }

    @ApiOperation(value = "Obtiene todas las marcas", notes = "Esta operacion devuelve una lista de todas las marcas")
    @GetMapping("marca/listar")
    public ResponseEntity<List<MarcaResponse>> ListarMarcas(){
        List<Marca> marcas = marcaService.listarMarcas();
        return new ResponseEntity<>(entityDTOConverter.convertMarcasToDTO(marcas),HttpStatus.OK);
    }

    @ApiOperation(value = "Guarda una marca", notes = "Esta operacion almacena la informacion de una nueva marca")
    @PostMapping("/marca/guardar")
    public void GuardarMarca(@RequestBody Marca marca){
        try {
            marcaService.guardar(marca);
        }
        catch (Exception e){
            throw new BadRequestException(ExceptionMessage.DATOS_INCORRECTOS.getValue());
        }
    }

}
