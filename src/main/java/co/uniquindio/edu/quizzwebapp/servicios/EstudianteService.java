package co.uniquindio.edu.quizzwebapp.servicios;



import java.util.List;

import co.uniquindio.edu.quizzwebapp.model.entities.Estudiante;

public interface EstudianteService {
    List<Estudiante> getEstudiantes();
    Estudiante getLoginEstudiante(String email, String password);
}
