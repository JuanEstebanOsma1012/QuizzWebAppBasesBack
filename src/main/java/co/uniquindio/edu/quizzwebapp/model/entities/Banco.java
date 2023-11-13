package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Banco  implements Serializable {

    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    //Como no hay una relación bidireccional de ownership,
    //entonces no hay necesidad de un mappedBy en la entidad inversa.
    @ManyToOne
    private Docente docente;

    @ManyToOne
    @JoinColumn (name = "id_tema")
    private Tema tema;



}
