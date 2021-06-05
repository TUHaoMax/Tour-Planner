package GUI.VIewModel;
import BusinessLayer.Reportmanager;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ReportingViewModel {
    private static final Logger logger= LoggerFactory.getLogger(ReportingViewModel.class);
    Reportmanager reportmanager=new Reportmanager();
    private String date="";
    FileChooser fileChooser=new FileChooser();

    public  void tourreport(String name) throws MalformedURLException, FileNotFoundException {
        getDatetime();
        fileChooser.setTitle("Print report");
        fileChooser.setInitialDirectory(new File("C:/BIF/"));
        fileChooser.setInitialFileName(name+"_"+date);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF file","*.pdf"));
        File file=fileChooser.showSaveDialog(null);
        if(file!=null) {
            reportmanager.tourreport(name, file);
            logger.debug("{} tourReport",file.getAbsolutePath());
        }
    }

    public void summarizereport(ObservableList<String> namelist) throws MalformedURLException, FileNotFoundException {
        getDatetime();
        fileChooser.setTitle("Print report");
        fileChooser.setInitialDirectory(new File("C:/BIF/"));
        fileChooser.setInitialFileName("summarize-report"+"_"+date);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF file","*.pdf"));
        File file=fileChooser.showSaveDialog(null);
        if(file!=null) {
            reportmanager.summarizereport(namelist, file);
            logger.debug("{} summarizeReport",file.getAbsolutePath());
        }
    }

    public void getDatetime(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("{yyyy-MM-dd}_[hh;mm;ss]");
        this.date=dateFormat.format(date);
    }

}
