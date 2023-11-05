package co.uniquindio.edu.quizzwebapp.model.entities;


import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;


@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@MappedSuperclass
@Inheritance (strategy = InheritanceType.JOINED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id_usuario")
    protected Integer id;


    @NotNull
    @UniqueElements
    @Column(unique = true)
    protected String correo;

    @NotNull
    protected String nombre;
    @NotNull
    protected String password;

    
}
