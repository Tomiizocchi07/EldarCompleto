package Eldar.EldarCompleto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TarjetaNotValidException extends RuntimeException {

    public TarjetaNotValidException(String message){super(message);}
}
