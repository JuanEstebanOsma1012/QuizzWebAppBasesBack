package co.uniquindio.edu.quizzwebapp.servicios;

import java.util.List;

import co.uniquindio.edu.quizzwebapp.model.entities.Administrador;

public interface AdministradorService {
    List<Administrador> getAdministradores();
    Administrador getLoginAdministrador(String email, String password);
}
