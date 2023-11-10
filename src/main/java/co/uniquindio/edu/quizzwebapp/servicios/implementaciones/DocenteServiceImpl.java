package co.uniquindio.edu.quizzwebapp.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.uniquindio.edu.quizzwebapp.model.entities.Docente;
import co.uniquindio.edu.quizzwebapp.repositorios.IDocenteDao;
import co.uniquindio.edu.quizzwebapp.servicios.DocenteService;


public class DocenteServiceImpl implements DocenteService{


    @Autowired 
    public IDocenteDao DocenteDao;

    
    public List<Docente> getDocentes() {
        
        return null;
    }

    @Override
    public Docente getLoginDocente(String email, String password) {
        return DocenteDao.getLoginDocente(email, password);
    }
    
}
