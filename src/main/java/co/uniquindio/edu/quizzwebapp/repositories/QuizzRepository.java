package co.uniquindio.edu.quizzwebapp.repositories;

import co.uniquindio.edu.quizzwebapp.model.entities.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Long> {

    Long countAllByDocente_IdAndBanco_Tema_Id(Long docenteId, Long temaId);

    Optional<Quizz> findFirstByFechaYHoraFinalizacionIsNotNullOrderByFechaYHoraFinalizacionAsc();

    Optional<Quizz> findFirstByFechaYHoraFinalizacionIsNotNullOrderByFechaYHoraFinalizacionDesc();

    @Query("select count(q) from Quizz q where FUNCTION('YEAR', q.fechaYHoraFinalizacion) = ?1 and FUNCTION('MONTH', q.fechaYHoraFinalizacion) = ?2")
    Long countAllByFechaYHoraFinalizacionYearAndFechaYHoraFinalizacionMonthValue(int year, int monthValue);
}
