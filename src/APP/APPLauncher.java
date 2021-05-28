package APP;


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


    private static final Logger logger= LoggerFactory.getLogger(APPLauncher.class);
    Stage stage=new Stage();
    public  String path="../Resources/fxml/";
    public static String fxmlname="";
    public int v=900,v1=900;


    public  void  showWindow() throws Exception {
        start(stage);
    }



    public void  switchWindow(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        stage=(Stage) ((Node) event.getSource() ).getScene().getWindow();
        stage.setTitle(fxmlname);
        stage.setScene(new Scene(root, v,v1));

        stage.show();
    }


    public static void main(String[] args) throws Exception{
        logger.debug("Main window start");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path+fxmlname));
        primaryStage.setTitle(fxmlname);
        primaryStage.setScene(new Scene(root, v,v1));
        primaryStage.show();
    }
}
