package co.uniquindio.edu.quizzwebapp.servicios;



import java.util.List;

import co.uniquindio.edu.quizzwebapp.model.entities.Docente;


public interface DocenteService {
    List<Docente> getDocentes();
    Docente getLoginDocente(String email, String password);
}
