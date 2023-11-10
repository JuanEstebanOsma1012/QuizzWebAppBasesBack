package co.uniquindio.edu.quizzwebapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.uniquindio.edu.quizzwebapp.model.entities.Docente;

@Repository
public interface IDocenteDao extends CrudRepository<Docente, Integer> {
    @Query("SELECT e FROM Docente e WHERE e.correo = ?1 AND e.password = ?2")
    public Docente getLoginDocente(String correo, String contrasenia);

}
