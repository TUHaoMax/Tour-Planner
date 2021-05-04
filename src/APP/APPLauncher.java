package APP;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APPLauncher extends Application {
    private static final Logger logger= LoggerFactory.getLogger(APPLauncher.class);
    Stage stage=new Stage();
    public  String path="../Resources/fxml/";
    public static String fxmlname="";


    public  void  showWindow() throws Exception {
        start(stage);
    }

    public static void main(String[] args) throws Exception{
        logger.debug("Main window start");
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
