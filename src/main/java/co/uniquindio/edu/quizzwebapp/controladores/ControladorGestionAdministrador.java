package co.uniquindio.edu.quizzwebapp.controladores;


import co.uniquindio.edu.quizzwebapp.model.entities.*;
import co.uniquindio.edu.quizzwebapp.repositorios.IAdministradorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/administradores")
@CrossOrigin(origins = "*")
public class ControladorGestionAdministrador {

    @Autowired
    public IAdministradorDao administradorDao;

    @PostMapping("/listarAdministradores")
    public Administrador listarAdministrador(@RequestBody Map<String, Object> cuerpoPeticion) {
      
        Administrador administrador = administradorDao.getLoginAdministrador(cuerpoPeticion.get("correo").toString(), cuerpoPeticion.get("contrasenia").toString());
        return administrador;
    }


}

