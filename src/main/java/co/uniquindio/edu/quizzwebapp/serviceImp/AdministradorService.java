package co.uniquindio.edu.quizzwebapp.serviceImp;

import co.uniquindio.edu.quizzwebapp.dto.reportFive.ReportFiveDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportFour.ReportFourDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportOne.ReportOneDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSeven.ReportSevenDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSix.ReportSixDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportThree.ReportThreeDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportTwo.ReportTwoDTO;
import co.uniquindio.edu.quizzwebapp.model.entities.*;
import co.uniquindio.edu.quizzwebapp.repositories.*;
import co.uniquindio.edu.quizzwebapp.service.AdministradorServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AdministradorService implements AdministradorServiceI {

    private final BloqueRepository bloqueRepository;
    private final GrupoRepository grupoRepository;
    private final SeleccionMultipleRepository seleccionMultipleRepository;
    private final PreguntaCerradaRepository preguntaCerradaRepository;
    private final QuizzRepository quizzRepository;
    private final TemaRepository temaRepository;
    private final DocenteRepository docenteRepository;
    private final PresentacionQuizzRepository presentacionQuizzRepository;
    private final PreguntaRepository preguntaRepository;

    @Override
    public List<ReportOneDTO> reportOne() {

        var grupos = grupoRepository.findAll();
        var bloques = eliminarDuplicados(bloqueRepository.findAll());
        var n_grupos = bloques.stream().map(bloque -> 0).collect(Collectors.toList());

        grupos.forEach(grupo -> grupo.getBloques().forEach(bloque -> {
            var index = bloques.indexOf(bloque);
            n_grupos.set(index, n_grupos.get(index) + 1);
        }));

        List<ReportOneDTO> bloquesDTO = new java.util.ArrayList<>();
        for (int i = 0; i < bloques.size(); i++) {
            bloquesDTO.add(new ReportOneDTO(bloques.get(i).getHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm")), bloques.get(i).getHoraFin().format(DateTimeFormatter.ofPattern("HH:mm")), n_grupos.get(i)));
        }

        return bloquesDTO;
    }

    @Override
    public List<ReportTwoDTO> reportTwo() {

        return List.of(
                new ReportTwoDTO("Seleccion Multiple", seleccionMultipleRepository.count()),
                new ReportTwoDTO("Pregunta Cerrada", preguntaCerradaRepository.count())
        );
    }

    @Override
    public ReportThreeDTO reportThree() {

        var profesores = docenteRepository.findAll();
        var temas = temaRepository.findAll().stream().limit(15).toList();
        var quizzs = new ArrayList<ArrayList<Integer>>();

        profesores.forEach(profesor -> {
            var quizzsProfesor = new ArrayList<Integer>();
            temas.forEach(tema -> {
                quizzsProfesor.add(quizzRepository.countAllByDocente_IdAndBanco_Tema_Id(profesor.getId(), tema.getId()).intValue());
            });
            quizzs.add(quizzsProfesor);
        });

        return new ReportThreeDTO(profesores.stream().map(Usuario::getNombre).toList(), temas.stream().map(Tema::getNombre).toList(), quizzs);
    }

    @Override
    public ReportFourDTO reportFour() {

        var grupos = grupoRepository.findAll().stream().limit(15).toList();
        var temas = temaRepository.findAll().stream().limit(15).toList();
        var calificaciones_promedio = new ArrayList<ArrayList<Double>>();

        grupos.forEach(grupo -> {
            var calificaciones_promedio_grupo = new ArrayList<Double>();
            temas.forEach(tema -> {
                calificaciones_promedio_grupo.add(presentacionQuizzRepository.findAllById_Estudiante_Grupos_IdAndId_Quizz_Banco_Tema_Id(
                        grupo.getId(), tema.getId()
                ).stream().mapToDouble(PresentacionQuizz::getCalificacion).average().orElse(0));
            });
            calificaciones_promedio.add(calificaciones_promedio_grupo);
        });

        return new ReportFourDTO(grupos.stream().map(Grupo::getNombre).toList(), temas.stream().map(Tema::getNombre).toList(), calificaciones_promedio);
    }

    @Override
    public ReportFiveDTO reportFive() {

        var meses = obtenerMesesEnIntervalo();
        var calificaciones_promedio = new ArrayList<Double>();

        meses.forEach(mes -> {
            calificaciones_promedio.add(presentacionQuizzRepository.findAllById_QuizzFechaYHoraFinalizacionYearAndId_QuizzFechaYHoraFinalizacionMonthValue(
                    mes.getYear(), mes.getMonthValue()
            ).stream().mapToDouble(PresentacionQuizz::getCalificacion).average().orElse(0));
        });

        return new ReportFiveDTO(meses.stream().map(mes -> mes.format(DateTimeFormatter.ofPattern("uuuu-MM"))).toList(), calificaciones_promedio);
    }

    @Override
    public ReportSixDTO reportSix() {

        List<LocalDate> meses = obtenerMesesEnIntervalo();
        var cantidad_quices = new ArrayList<Integer>();

        meses.forEach(mes -> {
            cantidad_quices.add(quizzRepository.countAllByFechaYHoraFinalizacionYearAndFechaYHoraFinalizacionMonthValue(
                    mes.getYear(), mes.getMonthValue()
            ).intValue());
        });

        return new ReportSixDTO(meses.stream().map(mes -> mes.format(DateTimeFormatter.ofPattern("uuuu-MM"))).toList(), cantidad_quices);
    }

    @Override
    public ReportSevenDTO reportSeven() {

        var profesores = docenteRepository.findAll();
        var bancos = new ArrayList<Integer>();
        var n_preguntas_promedio = new ArrayList<Double>();

        profesores.forEach(profesor -> {
            AtomicInteger n_bancos = new AtomicInteger(0);
            AtomicInteger n_preguntas_bancos = new AtomicInteger(0);
            profesor.getBancos().forEach(banco -> {
                n_bancos.getAndIncrement();
                n_preguntas_bancos.getAndAdd(preguntaRepository.countAllByBanco_Id(banco.getId()).intValue());
            });
            bancos.add(n_bancos.get());
            n_preguntas_promedio.add(n_bancos.get() > 0 ? n_preguntas_bancos.get() / n_bancos.get() : 0.0);
        });

        return new ReportSevenDTO(profesores.stream().map(docente -> "%s-%s".formatted(docente.getId(), docente.getNombre())).toList(), bancos, n_preguntas_promedio);
    }

    private List<Bloque> eliminarDuplicados(List<Bloque> todosLosBloques) {

        var bloques = new ArrayList<>(List.of(todosLosBloques.get(0)));
        for (int i = 1; i < todosLosBloques.size(); i++) {
            for (int j = 0; j < bloques.size(); j++) {
                if (todosLosBloques.get(i).getHoraInicio().equals(bloques.get(j).getHoraInicio()) && todosLosBloques.get(i).getHoraFin().equals(bloques.get(j).getHoraFin())) {
                    break;
                }
                if (j == bloques.size() - 1) {
                    bloques.add(todosLosBloques.get(i));
                }
            }
        }

        return bloques;
    }

    private List<LocalDate> obtenerMesesEnIntervalo() {
        var inicio = quizzRepository.findFirstByFechaYHoraFinalizacionIsNotNullOrderByFechaYHoraFinalizacionAsc().orElseThrow()
                .getFechaYHoraFinalizacion().toLocalDate();
        var fin = quizzRepository.findFirstByFechaYHoraFinalizacionIsNotNullOrderByFechaYHoraFinalizacionDesc().orElseThrow()
                .getFechaYHoraFinalizacion().toLocalDate();

        var meses = IntStream.iterate(0, i -> i + 1)
                .limit(inicio.until(fin.plusMonths(1)).toTotalMonths())
                .mapToObj(inicio::plusMonths)
                .limit(25)
                .toList();

        return meses;
    }

}
