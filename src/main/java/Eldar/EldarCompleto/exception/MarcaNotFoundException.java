package Eldar.EldarCompleto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarcaNotFoundException extends RuntimeException {

    public MarcaNotFoundException (String mensaje){super(mensaje);}

}
