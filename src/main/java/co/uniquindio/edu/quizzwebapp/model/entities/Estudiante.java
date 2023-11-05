package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
@SuperBuilder
public class Estudiante extends Usuario implements Serializable {
    
    @ManyToMany (mappedBy = "estudiantes")
    private List<Grupo> grupos;

    public Estudiante(Integer id, String correo, String nombre, String password, List<Grupo> grupos){
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.grupos = grupos;
        
    }
}
