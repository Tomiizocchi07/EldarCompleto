package Eldar.EldarCompleto.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    MARCA_INCORRECTA("El ID de marca proporcionado no es correcto o la marca no existe."),
    OPERACION_INCORRECTA("El ID de operacion proporcionado no es correcto o la operacion no existe"),
    TARJETA_INCORRECTA("El ID de tarjeta proporcionado no es correcto o la tarjeta no existe"),
    PERSONA_INCORRECTA("El ID de persona proporcionado no es correcto o la persona no existe"),
    DATOS_INCORRECTOS("Los datos proporcionados no son correctos");

    ExceptionMessage(String message){value = message;}

    private final String value;
}
