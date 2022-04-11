package Eldar.EldarCompleto.servicio.ServiceIMPL;

import Eldar.EldarCompleto.dao.TarjetaDAO;
import Eldar.EldarCompleto.domain.Tarjeta;
import Eldar.EldarCompleto.servicio.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarjetaServiceIMPL implements TarjetaService {

    @Autowired
    private TarjetaDAO tarjetaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Tarjeta> listarTarjetas() {
        return (tarjetaDAO.findAll());
    }

    @Override
    @Transactional
    public void guardar(Tarjeta tarjeta) {
        tarjetaDAO.save(tarjeta);
    }

    @Override
    @Transactional
    public void eliminar(Tarjeta tarjeta) {
        tarjetaDAO.delete(tarjeta);
    }

    @Override
    @Transactional(readOnly = true)
    public Tarjeta encontrarTarjeta(Long idTarjeta) {
        return (tarjetaDAO.findById(idTarjeta).orElse(null));
    }
}
