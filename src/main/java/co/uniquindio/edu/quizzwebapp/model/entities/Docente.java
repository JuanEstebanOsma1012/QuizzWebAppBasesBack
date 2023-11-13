package co.uniquindio.edu.quizzwebapp.model.entities;

import co.uniquindio.edu.quizzwebapp.model.entities.preguntas.Pregunta;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
@ToString()
public class Docente extends Usuario implements Serializable {


    @ToString.Exclude
    @OneToMany (mappedBy = "docente")
    private List<Grupo> grupos;

    @ToString.Exclude
    @OneToMany (mappedBy = "docente")
    private List <Banco> bancos;

    @ToString.Exclude
    @OneToMany
    private List <Pregunta> preguntas;

    @ToString.Exclude
    @OneToMany (mappedBy = "docente")
    private List <Quizz> quizzs;
}
