package Eldar.EldarCompleto.tasas;

import Eldar.EldarCompleto.exception.MarcaNotFoundException;

public class TasaFactory {

    public static Tasa getTasa(String marca){
        switch (marca){
            case "VISA":
                return new TasaVISA();
            case "NARA":
                return new TasaNARA();
            case "AMEX":
                return new TasaAMEX();
            default:
                throw new MarcaNotFoundException("La marca proporcionada no fue encontrada.");
        }
    }
}
