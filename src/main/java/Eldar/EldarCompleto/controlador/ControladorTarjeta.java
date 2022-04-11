package Eldar.EldarCompleto.controlador;

import Eldar.EldarCompleto.common.EntityDTOConverter;
import Eldar.EldarCompleto.domain.Marca;
import Eldar.EldarCompleto.domain.Persona;
import Eldar.EldarCompleto.domain.Tarjeta;
import Eldar.EldarCompleto.dto.TarjetaRequest;
import Eldar.EldarCompleto.dto.TarjetaResponse;
import Eldar.EldarCompleto.exception.BadRequestException;
import Eldar.EldarCompleto.exception.ExceptionMessage;
import Eldar.EldarCompleto.exception.TarjetaNotFoundException;
import Eldar.EldarCompleto.servicio.MarcaService;
import Eldar.EldarCompleto.servicio.PersonaService;
import Eldar.EldarCompleto.servicio.TarjetaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
public class ControladorTarjeta {

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private MarcaService marcaService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @ApiOperation(value = "Obtiene una tarjeta", notes = "Esta operacion devuelve una tarjeta basada en su ID")
    @GetMapping("/tarjeta/{idTarjeta}")
    public ResponseEntity<TarjetaResponse> obtenerTarjeta(@PathVariable Long idTarjeta) {
        try {
            Tarjeta tarjeta = tarjetaService.encontrarTarjeta(idTarjeta);
            return new ResponseEntity<> (entityDTOConverter.convertTarjetatoDTO(tarjeta), HttpStatus.OK);
        }
        catch (Exception e){
            throw new TarjetaNotFoundException(ExceptionMessage.TARJETA_INCORRECTA.getValue());
        }
    }

    @ApiOperation(value = "Guarda una tarjeta", notes = "Esta operacion almacena la informacion de una nueva tarjeta")
    @PostMapping("tarjeta/guardar")
    public void guardarTarjeta(@RequestBody TarjetaRequest tarjetaRequest) {
        try {
            Persona persona = personaService.encontrarPersona(tarjetaRequest.getIdPersona());
            Marca marca = marcaService.encontrarMarca(tarjetaRequest.getIdMarca());
            Tarjeta tarjeta = entityDTOConverter.convertDTOtoTarjeta(tarjetaRequest);
            tarjeta.setIdPersona(persona);
            tarjeta.setIdMarca(marca);
            tarjeta.tarjetaValida();
            tarjetaService.guardar(tarjeta);
        }
        catch (Exception e){
            throw new BadRequestException(ExceptionMessage.DATOS_INCORRECTOS.getValue());
        }

    }

}
