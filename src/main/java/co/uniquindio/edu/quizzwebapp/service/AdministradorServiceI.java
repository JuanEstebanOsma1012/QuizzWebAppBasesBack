package co.uniquindio.edu.quizzwebapp.service;

import co.uniquindio.edu.quizzwebapp.dto.reportFive.ReportFiveDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportFour.ReportFourDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportOne.ReportOneDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSeven.ReportSevenDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportSix.ReportSixDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportThree.ReportThreeDTO;
import co.uniquindio.edu.quizzwebapp.dto.reportTwo.ReportTwoDTO;

import java.util.List;

public interface AdministradorServiceI {

    public List<ReportOneDTO> reportOne();

    public List<ReportTwoDTO> reportTwo();

    public ReportThreeDTO reportThree();

    public ReportFourDTO reportFour();

    public ReportFiveDTO reportFive();

    public ReportSixDTO reportSix();

    public ReportSevenDTO reportSeven();

}
