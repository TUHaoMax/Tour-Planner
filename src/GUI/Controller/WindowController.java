package GUI.Controller;

import GUI.VIewModel.LauncherVModel;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class WindowController implements Initializable {

    public static void Windowlaunch(String fxmlname)throws Exception{
       LauncherVModel Launcher=new LauncherVModel();
       Launcher.fxmlname=fxmlname;
       Launcher.showWindow();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
