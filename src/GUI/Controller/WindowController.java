package GUI.Controller;

import APP.APPLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class WindowController implements Initializable {
    private static final Logger logger= LoggerFactory.getLogger(WindowController.class);

    public static void Windowswitch(String fxmlname, ActionEvent event,int V,int V1)throws Exception{
        APPLauncher Launcher=new APPLauncher();
       Launcher.fxmlname=fxmlname;
        Launcher.v=V;
        Launcher.v1=V1;
       Launcher.switchWindow(event);
       logger.debug("{} Window start",fxmlname);
    }

    public static void Windowlunch(String fxmlname,int V,int V1)throws Exception{
        APPLauncher Launcher=new APPLauncher();
        Launcher.fxmlname=fxmlname;
        Launcher.v=V;
        Launcher.v1=V1;
        Launcher.showWindow();
        logger.debug("{} Window start",fxmlname);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
