package co.uniquindio.edu.quizzwebapp.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.uniquindio.edu.quizzwebapp.model.entities.Administrador;
import co.uniquindio.edu.quizzwebapp.repositorios.IAdministradorDao;
import co.uniquindio.edu.quizzwebapp.servicios.AdministradorService;


public class AdministradorServiceImpl implements AdministradorService {


    @Autowired 
    public IAdministradorDao AdministradorDao;

    
    public List<Administrador> getAdministradores() {
        
        return null;
    }

    @Override
    public Administrador getLoginAdministrador(String email, String password) {
        return AdministradorDao.getLoginAdministrador(email, password);
    }
    
}
