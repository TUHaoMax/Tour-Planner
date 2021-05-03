package GUI.Controller;

import APP.APPLauncher;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class WindowController implements Initializable {

    public static void Windowlaunch(String fxmlname)throws Exception{
        APPLauncher Launcher=new APPLauncher();
       Launcher.fxmlname=fxmlname;
       Launcher.showWindow();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
