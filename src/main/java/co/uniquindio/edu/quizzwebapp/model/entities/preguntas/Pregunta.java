package co.uniquindio.edu.quizzwebapp.model.entities.preguntas;


import co.uniquindio.edu.quizzwebapp.model.entities.Banco;
import co.uniquindio.edu.quizzwebapp.model.entities.Docente;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@NotNull
@Inheritance (strategy = InheritanceType.JOINED)

public abstract class Pregunta implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne
    private Banco banco;

    @NotNull
    private Boolean esPublica;

    @ManyToOne
    @NotNull
    private Docente docente;

    /**
     * Tiempo máximo en minutos para presentar el quizz.
     */
    @Column (columnDefinition = "INT DEFAULT 60")
    private Integer tiempoMax = 60;

    private Integer porcentaje;

    @NotNull
    @Column (columnDefinition = "VARCHAR(500) NOT NULL")
    private String enunciado;
}
