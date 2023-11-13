package co.uniquindio.edu.quizzwebapp.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class Quizz {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;
    @NotNull
    private String descripcion;
    private int tiempo;
    private int cantidadPreguntas;
    @ManyToOne
    private Banco banco;
    @NotNull
    private String categoria;
    private LocalDateTime fechaYhora_Inicio;
    @NotNull
    private LocalDateTime fechaYHoraFinalizacion;
    @Max(100)
    @Column(precision=3,scale=2)
    private BigDecimal porcentajeCurso;
    private int porcentajeUmbral;

    @ManyToOne
    private Docente docente;

}
