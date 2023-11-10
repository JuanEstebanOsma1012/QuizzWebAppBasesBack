package co.uniquindio.edu.quizzwebapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.uniquindio.edu.quizzwebapp.model.entities.Administrador;

@Repository
public interface IAdministradorDao extends CrudRepository<Administrador, Integer> {
    @Query("SELECT a FROM Administrador a WHERE a.correo = ?1 AND a.password = ?2")
    public Administrador getLoginAdministrador(String correo, String contrasenia);
        
}
