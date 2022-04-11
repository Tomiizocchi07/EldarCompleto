package Eldar.EldarCompleto.common;

import Eldar.EldarCompleto.domain.Marca;
import Eldar.EldarCompleto.domain.Operacion;
import Eldar.EldarCompleto.domain.Persona;
import Eldar.EldarCompleto.domain.Tarjeta;
import Eldar.EldarCompleto.dto.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDTOConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OperacionResponse convertOperacionToDTO(Operacion operacion){
        return modelMapper.map(operacion,OperacionResponse.class);
    }

    public Operacion convertDTOtoOperacion(OperacionRequest operacionRequest){
        return modelMapper.map(operacionRequest, Operacion.class);
    }

    public MarcaResponse convertMarcatoDTO(Marca marca){
        return modelMapper.map(marca,MarcaResponse.class);
    }

    public TarjetaResponse convertTarjetatoDTO(Tarjeta tarjeta){
        return modelMapper.map(tarjeta, TarjetaResponse.class);
    }

    public Tarjeta convertDTOtoTarjeta(TarjetaRequest tarjetaRequest){
        return modelMapper.map(tarjetaRequest, Tarjeta.class);
    }

    public PersonaResponse convertPersonatoDTO(Persona persona){
        return modelMapper.map(persona, PersonaResponse.class);
    }

    public Persona convertDTOtoPersona(PersonaRequest personaRequest){
        return modelMapper.map(personaRequest, Persona.class);
    }

    public List<MarcaResponse> convertMarcasToDTO(List<Marca> marcas){
        return marcas.stream().map(marca -> convertMarcatoDTO(marca)).collect(Collectors.toList());
    }

    public List<OperacionResponse> convertOperacionesToDTO(List<Operacion> operaciones){
        return operaciones.stream().map(operacion -> convertOperacionToDTO(operacion)).collect(Collectors.toList());
    }

}
