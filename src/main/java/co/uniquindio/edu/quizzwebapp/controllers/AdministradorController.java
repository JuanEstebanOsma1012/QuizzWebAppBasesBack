package co.uniquindio.edu.quizzwebapp.controllers;

import co.uniquindio.edu.quizzwebapp.dto.reportFive.ReportFiveDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportFour.ReportFourDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportOne.ReportOneDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSeven.ReportSevenDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSix.ReportSixDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportThree.ReportThreeDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportTwo.ReportTwoDTO;
import co.uniquindio.edu.quizzwebapp.service.AdministradorServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/administrador")
@CrossOrigin
@RequiredArgsConstructor
public class AdministradorController {

    private final AdministradorServiceI administradorService;

    @GetMapping("/reporte1")
    public ResponseEntity<List<ReportOneDTO>> reportOne() {
        return ResponseEntity.ok().body(administradorService.reportOne());
    }

    @GetMapping("/reporte2")
    public ResponseEntity<List<ReportTwoDTO>> reportTwo() {
        return ResponseEntity.ok().body(administradorService.reportTwo());
    }

    @GetMapping("/reporte3")
    public ResponseEntity<ReportThreeDTO> reportThree() {
        return ResponseEntity.ok().body(administradorService.reportThree());
    }

    @GetMapping("/reporte4")
    public ResponseEntity<ReportFourDTO> reportFour() {
        return ResponseEntity.ok().body(administradorService.reportFour());
    }

    @GetMapping("/reporte5")
    public ResponseEntity<ReportFiveDTO> reportFive() {
        return ResponseEntity.ok().body(administradorService.reportFive());
    }

    @GetMapping("/reporte6")
    public ResponseEntity<ReportSixDTO> reportSix() {
        return ResponseEntity.ok().body(administradorService.reportSix());
    }

    @GetMapping("/reporte7")
    public ResponseEntity<ReportSevenDTO> reportSeven() {
        return ResponseEntity.ok().body(administradorService.reportSeven());
    }

}
