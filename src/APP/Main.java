package APP;
import GUI.Controller.*;
import GUI.VIewModel.*;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../Resources/MainWindow.fxml"));
        primaryStage.setTitle("Tour-Planner");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception{
        launch(args);

    }
}