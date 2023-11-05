package co.uniquindio.edu.quizzwebapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.uniquindio.edu.quizzwebapp.model.entities.Estudiante;

@Repository
public interface IEstudianteDao extends CrudRepository<Estudiante, Integer> {
    @Query("SELECT e FROM Estudiante e WHERE e.correo = ?1 AND e.password = ?2")
    public Estudiante getLoginEstudiante(String correo, String contrasenia);

}
