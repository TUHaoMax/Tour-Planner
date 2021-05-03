package APP;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;


public class APPLauncher extends Application {
    Stage stage=new Stage();
    public  String path="../Resources/";
    public static String fxmlname="";


    public  void  showWindow() throws Exception {
        start(stage);

    }
    public static void main(String[] args) throws Exception{
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        primaryStage.setTitle(fxmlname);
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();
    }
}
