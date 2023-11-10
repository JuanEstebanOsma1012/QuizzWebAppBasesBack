package co.uniquindio.edu.quizzwebapp.controladores;


import co.uniquindio.edu.quizzwebapp.model.entities.*;
import co.uniquindio.edu.quizzwebapp.repositorios.IDocenteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/docentes")
@CrossOrigin(origins = "*")
public class ControladorGestionDocente {

    @Autowired
    public IDocenteDao docenteDao;

    @PostMapping("/listarDocentes")
    public Docente listarDocente(@RequestBody Map<String, Object> cuerpoPeticion) {
      
        Docente docente = docenteDao.getLoginDocente(cuerpoPeticion.get("correo").toString(), cuerpoPeticion.get("contrasenia").toString());
        return docente;
    }


}

