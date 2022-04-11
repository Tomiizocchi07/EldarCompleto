package Eldar.EldarCompleto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class TarjetaNotFoundException extends RuntimeException {

    public TarjetaNotFoundException(String mensaje){super(mensaje);}
}
