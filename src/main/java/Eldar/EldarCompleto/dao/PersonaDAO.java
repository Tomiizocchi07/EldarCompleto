package Eldar.EldarCompleto.dao;

import Eldar.EldarCompleto.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDAO extends JpaRepository<Persona, Long> {
}
