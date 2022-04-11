package Eldar.EldarCompleto.controlador;

import Eldar.EldarCompleto.common.EntityDTOConverter;
import Eldar.EldarCompleto.domain.Persona;
import Eldar.EldarCompleto.dto.PersonaRequest;
import Eldar.EldarCompleto.dto.PersonaResponse;
import Eldar.EldarCompleto.exception.BadRequestException;
import Eldar.EldarCompleto.exception.ExceptionMessage;
import Eldar.EldarCompleto.exception.PersonaNotFoundException;
import Eldar.EldarCompleto.servicio.PersonaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
public class ControladorPersona {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @ApiOperation(value = "Obtiene una persona", notes = "Esta operacion devuelve una persona basada en su ID")
    @GetMapping("/persona/{idPersona}")
    public ResponseEntity<PersonaResponse> obtenerPersona(@PathVariable Long idPersona){
        try {
            Persona persona = personaService.encontrarPersona(idPersona);
            return new ResponseEntity<>(entityDTOConverter.convertPersonatoDTO(persona), HttpStatus.OK);
        }
        catch (Exception e){
            throw new PersonaNotFoundException(ExceptionMessage.PERSONA_INCORRECTA.getValue());
        }

    }

    @ApiOperation(value = "Guarda una persona", notes = "Esta operacion almacena la informacion de una nueva persona")
    @PostMapping("/persona/guardar")
    public void crearPersona(@RequestBody PersonaRequest personaRequest){
        try {
            Persona persona = entityDTOConverter.convertDTOtoPersona(personaRequest);
            personaService.guardar(persona);
        }
        catch (Exception e){
            throw new BadRequestException(ExceptionMessage.DATOS_INCORRECTOS.getValue());
        }
    }
}