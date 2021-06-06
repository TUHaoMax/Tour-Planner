package BusinessLayer;

import GUI.VIewModel.ReportingViewModel;
import com.itextpdf.text.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

class ReportmanagerTest {



    @Test
    void creatparagraph() throws MalformedURLException, DocumentException, FileNotFoundException {
        Reportmanager reportmanager=new Reportmanager();
        reportmanager.test("test");
    }

    @Test
    void getDatetime() {
        ReportingViewModel rpm=new ReportingViewModel();
        rpm.getDatetime();
        System.out.println(rpm.getDate());
    }
}