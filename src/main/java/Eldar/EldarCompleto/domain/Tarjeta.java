package Eldar.EldarCompleto.domain;

import Eldar.EldarCompleto.exception.OperacionNotValidException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarjeta")
    private Long idTarjeta;

    @NotNull
    private String numeroTarjeta;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca idMarca;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona idPersona;

    @OneToMany
    private List<Operacion> operaciones;

    public boolean tarjetaValida(){
        if (this.fechaVencimiento.isAfter(LocalDate.now())){
            return true;
        } else {
            throw new OperacionNotValidException("La tarjeta no es valida para operar");
        }
    }

}
