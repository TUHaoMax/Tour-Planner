package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

@Setter
@Getter
public class TMController implements Initializable, EventHandler<ActionEvent> {


    private static int TourID;
    private static String Tourname;
    private static String[] Weather={"sunshine","rain","snow","cloud","fog","wind","thunderstorm"};
    private static String currentweather;
    @FXML
    private MainController MC;
    @FXML
    private ChoiceBox<String> WeatherCB;

    public void setTT(String name,int Id){
     Tourname=name;
     TourID=Id;
    }
    private void ChoiceWeather(ActionEvent event){
        currentweather=WeatherCB.getValue();
        System.out.println(currentweather);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
               WeatherCB.getItems().addAll(Weather);
               WeatherCB.setOnAction(this::ChoiceWeather);

    }

    @Override
    public void handle(ActionEvent event) {

     System.out.println(Tourname);
     System.out.println(TourID);

    }
}
