package Eldar.EldarCompleto.domain;

import Eldar.EldarCompleto.exception.OperacionNotValidException;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "operacion")
public class Operacion {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOperacion")
    private Long idOperacion;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona idPersona;

    @ManyToOne
    @JoinColumn(name = "idTarjeta")
    private Tarjeta tarjeta;

    @NotNull
    @Column(name = "monto")
    private double monto;

    @NotNull
    @Column(name = "tasaOperacion")
    private float tasaOperacion;

    public boolean operacionValida(){
        if (this.monto < 1000){
            return true;
        } else {
            throw new OperacionNotValidException("La operacion no es valida");
        }
    }
}
