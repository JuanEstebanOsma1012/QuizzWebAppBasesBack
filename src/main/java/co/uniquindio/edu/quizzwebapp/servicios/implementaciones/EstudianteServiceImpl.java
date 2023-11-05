package co.uniquindio.edu.quizzwebapp.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.uniquindio.edu.quizzwebapp.model.entities.Estudiante;
import co.uniquindio.edu.quizzwebapp.repositorios.IEstudianteDao;
import co.uniquindio.edu.quizzwebapp.servicios.EstudianteService;

public class EstudianteServiceImpl implements EstudianteService{


    @Autowired 
    public IEstudianteDao estudianteDao;

    @Override
    public List<Estudiante> getEstudiantes() {
        
        return null;
    }

    @Override
    public Estudiante getLoginEstudiante(String email, String password) {
        return estudianteDao.getLoginEstudiante(email, password);
    }
    
}
