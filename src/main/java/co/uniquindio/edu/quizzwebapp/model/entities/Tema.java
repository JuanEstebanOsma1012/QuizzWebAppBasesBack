package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Tema implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column (columnDefinition = "varchar (500)")
    private String descripcion;

    @NotNull
    @Column (columnDefinition = "varchar (500)")
    private String nombre;

    @ManyToMany
    private List<Curso> curso;

}
