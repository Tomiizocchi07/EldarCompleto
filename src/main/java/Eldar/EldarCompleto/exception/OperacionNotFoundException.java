package Eldar.EldarCompleto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperacionNotFoundException extends RuntimeException{

    public OperacionNotFoundException (String mensaje){super(mensaje);}
}
