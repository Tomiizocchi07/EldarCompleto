package Eldar.EldarCompleto.dao;

import Eldar.EldarCompleto.domain.Marca;
import Eldar.EldarCompleto.servicio.MarcaService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaDAO extends JpaRepository<Marca, Long> {
}
