package Eldar.EldarCompleto.controlador;

import Eldar.EldarCompleto.common.EntityDTOConverter;
import Eldar.EldarCompleto.domain.Operacion;
import Eldar.EldarCompleto.domain.Persona;
import Eldar.EldarCompleto.dto.OperacionRequest;
import Eldar.EldarCompleto.dto.OperacionResponse;
import Eldar.EldarCompleto.exception.BadRequestException;
import Eldar.EldarCompleto.exception.ExceptionMessage;
import Eldar.EldarCompleto.exception.OperacionNotFoundException;
import Eldar.EldarCompleto.servicio.MarcaService;
import Eldar.EldarCompleto.servicio.OperacionesService;
import Eldar.EldarCompleto.servicio.PersonaService;
import Eldar.EldarCompleto.tasas.Tasa;
import Eldar.EldarCompleto.tasas.TasaFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
public class ControladorOperacion {

    @Autowired
    private OperacionesService operacionesService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @ApiOperation(value = "Obtiene una operacion", notes = "Esta operacion devuelve una operacion basada en su ID")
    @GetMapping("/operacion/{idOperacion}")
    public ResponseEntity<OperacionResponse> obtenerOperacion(@PathVariable Long idOperacion){
        try {
            Operacion operacion = operacionesService.encontrarOperacion(idOperacion);
            return new ResponseEntity<>(entityDTOConverter.convertOperacionToDTO(operacion), HttpStatus.OK);
        }
        catch (Exception e){
            throw new OperacionNotFoundException(ExceptionMessage.OPERACION_INCORRECTA.getValue());
        }
    }

    @ApiOperation(value = "Obtiene todas las operaciones", notes = "Esta operacion devuelve una lista de todas las operaciones")
    @GetMapping("/operacion/listar")
    public ResponseEntity<List<OperacionResponse>> listarOperaciones(){
        List<Operacion> operaciones = operacionesService.listarOperaciones();
        return new ResponseEntity<>(entityDTOConverter.convertOperacionesToDTO(operaciones),HttpStatus.OK);
    }

    @ApiOperation(value = "Guarda una operacion", notes = "Esta operacion almacena la informacion de una nueva operacion")
    @PostMapping("/operacion/guardar")
    public void guardarOperacion(@RequestBody OperacionRequest operacionRequest){
        try{
            Persona persona = personaService.encontrarPersona(operacionRequest.getIdPersona());
            Operacion operacion = entityDTOConverter.convertDTOtoOperacion(operacionRequest);
            Tasa tasa = TasaFactory.getTasa(marcaService.encontrarMarca(operacionRequest.getIdTarjeta()).getNombre());
            operacion.setTasaOperacion(tasa.calcularTasa());
            operacion.setIdPersona(persona);
            operacion.operacionValida();
            operacionesService.guardar(operacion);
        }
        catch (Exception e){
            throw new BadRequestException(ExceptionMessage.DATOS_INCORRECTOS.getValue());
        }

    }
}
