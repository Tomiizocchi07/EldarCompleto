package Eldar.EldarCompleto.servicio;


import Eldar.EldarCompleto.domain.Persona;

public interface PersonaService {

    void guardar(Persona persona);

    void eliminar(Persona persona);

    Persona encontrarPersona (Long idPersona);
}
