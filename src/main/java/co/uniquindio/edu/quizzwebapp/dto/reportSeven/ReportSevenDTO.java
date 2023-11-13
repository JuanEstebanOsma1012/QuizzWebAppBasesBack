package co.uniquindio.edu.quizzwebapp.dto.reportSeven;

import java.util.List;

public record ReportSevenDTO(

        List<String> profesores,
        List<Integer> n_bancos,
        java.util.ArrayList<Double> n_preguntas_promedio

) {
}
