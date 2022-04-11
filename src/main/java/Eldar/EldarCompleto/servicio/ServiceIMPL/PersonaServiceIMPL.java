package Eldar.EldarCompleto.servicio.ServiceIMPL;

import Eldar.EldarCompleto.dao.PersonaDAO;
import Eldar.EldarCompleto.domain.Persona;
import Eldar.EldarCompleto.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceIMPL implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Long idPersona) {
        return (personaDAO.findById(idPersona).orElse(null));
    }
}
