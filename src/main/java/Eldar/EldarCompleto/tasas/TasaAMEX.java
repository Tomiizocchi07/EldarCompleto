package Eldar.EldarCompleto.tasas;

import java.time.LocalDate;

public class TasaAMEX implements Tasa {

    @Override
    public float calcularTasa() {
        return ((float) LocalDate.now().getMonthValue() * (float) 0.1);
    }

}
