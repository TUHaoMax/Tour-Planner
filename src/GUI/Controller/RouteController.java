package GUI.Controller;

import APP.APPLauncher;
import GUI.VIewModel.RouteViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RouteController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(RouteController.class);
   public static RouteViewModel routeViewModel=new RouteViewModel();
   private String path= APPLauncher.config.RoutePath;
   private String Searchpath=APPLauncher.config.Searchpath;

   @FXML
   private ImageView Map;
   @FXML
   private Label Label;
    Image image;
    BufferedImage tempCard;
    File file;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      Label.textProperty().bind(routeViewModel.TourName);

         Map.setImage(routeViewModel.image);
         Label.textProperty().addListener(new ChangeListener<String>() {
             @SneakyThrows
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if(Label.getText()!=null) {
                        int n=routeViewModel.inforCheck();
                        if (n==1){

                            MapCheck();
                        }else {

                            image=new Image("Home.jpg");
                            Map.setImage(image);
                        }

                    }else {

                        image=new Image("Home.jpg");
                        Map.setImage(image);
                    }

             }
         });
     
    }


 @Override
 public void handle(ActionEvent event) {

 }



 private void MapCheck() throws IOException, InterruptedException {
     file=new File(Searchpath+Label.getText()+".jpg");
     if(file.exists()){
         logger.debug("have {}",Label.getText());
         logger.debug("{} ",path+Label.getText()+".jpg");

             tempCard=ImageIO.read(file);

         image= SwingFXUtils.toFXImage(tempCard, null );
         Map.setImage(image);
     }else {
         routeViewModel.getMap();

             Thread.sleep(1000);

             Thread.sleep(500);

         logger.debug("recheck");
         MapCheck();
     }
 }

}
