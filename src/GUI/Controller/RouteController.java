package GUI.Controller;

import APP.APPLauncher;
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

import java.net.URL;
import java.util.ResourceBundle;

public class RouteController implements Initializable, EventHandler<ActionEvent> {
   public static RouteViewModel routeViewModel=new RouteViewModel();
   private String path= APPLauncher.config.RoutePath;

   @FXML
   private ImageView Map;
   @FXML
   private Label Label;

    Image image=new Image(getClass().getResourceAsStream(path+routeViewModel.MapName.getValue()));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      Label.textProperty().bind(routeViewModel.MapName);

         Map.setImage(image);
         Label.textProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                 Image image=new Image(getClass().getResourceAsStream(path+Label.getText()));
                 Map.setImage(image);
             }
         });
     
    }


 @Override
 public void handle(ActionEvent event) {

        routeViewModel.test();
 }

}
