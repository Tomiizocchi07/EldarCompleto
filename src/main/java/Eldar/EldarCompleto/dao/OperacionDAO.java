package Eldar.EldarCompleto.dao;

import Eldar.EldarCompleto.domain.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacionDAO extends JpaRepository<Operacion,Long> {
}
