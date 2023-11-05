package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@NoArgsConstructor
public class Docente extends Usuario implements Serializable {

    
    @OneToMany (mappedBy = "docente")
    private List<Grupo> grupos;

    @OneToMany
    private List <Banco> bancos;
}
