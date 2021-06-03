package GUI.VIewModel;
import BusinessLayer.Reportmanager;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class ReportingViewModel {
    private static final Logger logger= LoggerFactory.getLogger(ReportingViewModel.class);
    Reportmanager reportmanager=new Reportmanager();

    public  void PDfcreate(String name) {
        reportmanager.PDfcreate(name);
    }



}
