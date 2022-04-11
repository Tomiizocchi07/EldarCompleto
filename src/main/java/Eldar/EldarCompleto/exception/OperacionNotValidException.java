package Eldar.EldarCompleto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperacionNotValidException extends RuntimeException{

    public OperacionNotValidException (String mensaje) { super(mensaje); }
}
