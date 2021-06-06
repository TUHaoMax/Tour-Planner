package APP;


import DataALayer.JsonParse;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APPLauncher extends Application {
    public static Config config=new Config();

    private static final Logger logger= LoggerFactory.getLogger(APPLauncher.class);
    Stage stage=new Stage();
    //public  String path= "../Resources/Viewfxml/";
    public  String path="";
    public static String fxmlname="";
    public int v=900,v1=900;


    public  void  showWindow() throws Exception {
        start(stage);
        logger.debug("Window launch {}",fxmlname);
    }



    public void  switchWindow(ActionEvent event) throws Exception {
        config= JsonParse.getConfig(JsonParse.readConfig());
        path=config.ViewPath;
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        stage=(Stage) ((Node) event.getSource() ).getScene().getWindow();
        //stage.setTitle(fxmlname);
        stage.setScene(new Scene(root, v,v1));
        stage.show();
        logger.debug("Switch to {}",fxmlname);
    }


    public static void main(String[] args) throws Exception{
        logger.debug("Main window start");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        config= JsonParse.getConfig(JsonParse.readConfig());
        path=config.ViewPath;
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        primaryStage.setTitle(fxmlname);
        primaryStage.setScene(new Scene(root, v,v1));
        primaryStage.show();
    }
}
