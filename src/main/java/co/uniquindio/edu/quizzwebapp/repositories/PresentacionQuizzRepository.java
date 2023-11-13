package co.uniquindio.edu.quizzwebapp.repositories;

import co.uniquindio.edu.quizzwebapp.model.entities.PresentacionQuizz;
import co.uniquindio.edu.quizzwebapp.model.entities.PresentacionQuizzID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Repository
public interface PresentacionQuizzRepository extends JpaRepository<PresentacionQuizz, PresentacionQuizzID> {

        List<PresentacionQuizz> findAllById_Estudiante_Grupos_IdAndId_Quizz_Banco_Tema_Id(Integer id_estudiante_grupos_id, Long id_quizz_banco_tema_id);

        @Query("select p from PresentacionQuizz p where FUNCTION('YEAR', p.id.quizz.fechaYHoraFinalizacion) = ?1 and FUNCTION('MONTH', p.id.quizz.fechaYHoraFinalizacion) = ?2")
        List<PresentacionQuizz> findAllById_QuizzFechaYHoraFinalizacionYearAndId_QuizzFechaYHoraFinalizacionMonthValue(Integer year, Integer monthValue);

}
