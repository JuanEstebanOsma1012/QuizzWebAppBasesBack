package co.uniquindio.edu.quizzwebapp.dto.reportFour;

import java.util.List;

public record ReportFourDTO(

        List<String> grupos,
        List<String> temas,
        java.util.ArrayList<java.util.ArrayList<Double>> heatmap_calificacion_promedio

) {
}
