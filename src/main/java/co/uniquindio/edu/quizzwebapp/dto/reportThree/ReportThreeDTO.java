package co.uniquindio.edu.quizzwebapp.dto.reportThree;

import java.util.ArrayList;
import java.util.List;

public record ReportThreeDTO(

        List<String> profesores,
        List<String> materias,
        ArrayList<ArrayList<Integer>> heatmap_n_quices

) {
}
