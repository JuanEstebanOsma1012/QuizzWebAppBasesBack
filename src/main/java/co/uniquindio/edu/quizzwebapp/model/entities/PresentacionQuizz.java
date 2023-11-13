package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class PresentacionQuizz  implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private PresentacionQuizzID id;

    @Max(100)
    private int calificacion;

}
