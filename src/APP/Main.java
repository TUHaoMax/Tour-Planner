package APP;
import GUI.Controller.*;
import GUI.VIewModel.*;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class Main  {

    public static void main(String[] args) throws Exception{
       LauncherVModel.fxmlname="MainWindow.fxml";
       LauncherVModel.main(args);
    }
}