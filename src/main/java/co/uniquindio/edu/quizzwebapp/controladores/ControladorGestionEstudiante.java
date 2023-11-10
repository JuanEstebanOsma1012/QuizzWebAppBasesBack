package co.uniquindio.edu.quizzwebapp.controladores;


import co.uniquindio.edu.quizzwebapp.model.entities.*;
import co.uniquindio.edu.quizzwebapp.repositorios.IEstudianteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "*")
public class ControladorGestionEstudiante {

    @Autowired
    public IEstudianteDao estudianteDao;

    @PostMapping("/listarEstudiantes")
    public Estudiante getEstudiante(@RequestBody Map<String, Object> cuerpoPeticion) {

        Estudiante estudiante = estudianteDao.getLoginEstudiante(cuerpoPeticion.get("correo").toString(), cuerpoPeticion.get("contrasenia").toString());
        return estudiante;
    }


}

