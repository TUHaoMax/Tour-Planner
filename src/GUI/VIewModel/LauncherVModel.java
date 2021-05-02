package GUI.VIewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;

public class LauncherVModel extends Application {
    Stage stage=new Stage();
    public String path="../../Resources/";
    public String fxmlname="";

    public LauncherVModel(String fxmlname) {
        this.fxmlname = fxmlname;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        primaryStage.setTitle(fxmlname);
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();
    }

    public void  showWindow() throws Exception {
        start(stage);
    }
}
