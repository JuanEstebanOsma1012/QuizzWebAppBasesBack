package co.uniquindio.edu.quizzwebapp.controladores;


import co.uniquindio.edu.quizzwebapp.model.entities.*;
import co.uniquindio.edu.quizzwebapp.repositorios.IAdministradorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




import java.util.Map;

@RestController
@RequestMapping("/crearCuenta")
@CrossOrigin(origins = "*")
public class ControladorGestionCrearCuenta {

    

    @PostMapping("/crearEstudiante")
    public Estudiante crearCuenta(@RequestBody Map<String, Object> cuerpoPeticion) {
            
        return new Estudiante(234, "jgarcia.c@gmail.com", "Juan Garcia", "juanb1234", null);
    }


}

