package GUI.Controller;

import APP.APPLauncher;
import BusinessLayer.MapQuestManager;
import GUI.VIewModel.RouteViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RouteController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(MapQuestManager.class);
   public static RouteViewModel routeViewModel=new RouteViewModel();
   private String path= APPLauncher.config.RoutePath;
   private String Searchpath=APPLauncher.config.Searchpath;

   @FXML
   private ImageView Map;
   @FXML
   private Label Label;
    Image image;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      Label.textProperty().bind(routeViewModel.TourName);

         Map.setImage(routeViewModel.image);
         Label.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {


                 File file=new File(Searchpath+Label.getText()+".jpg");
                 if(file.exists()){
                     logger.debug("have {}",Label.getText());
                     logger.debug("{} ",path+Label.getText()+".jpg");

                  image=new Image(Label.getText()+".jpg");
                    Map.setImage(image);
                 }/*else {
                     routeViewModel.getMap();
                     try {
                         Thread.sleep(2000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     image=new Image(Label.getText()+".jpg");
                     Map.setImage(image);
                 }*/
             }
         });
     
    }


 @Override
 public void handle(ActionEvent event) {
     routeViewModel.getMap();
 }

}
