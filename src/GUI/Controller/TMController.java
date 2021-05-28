package GUI.Controller;

import GUI.VIewModel.TMViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

@Setter
@Getter
public class TMController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(TMController.class);

    TMViewModel tmViewModel=new TMViewModel();

    private static int TourID;
    private static String Tourname;
    private static String[] Weather={"sunshine","rain","snow","cloud","fog","wind","thunderstorm"};
    private static String currentweather;
    @FXML
    private MainController MC;
    @FXML
    private ChoiceBox<String> WeatherCB;
    @FXML
    private TextField Departure,Destination,Duration,Distance;
    @FXML
    private Button ADDTourinfor,ADDLog;
    @FXML
    private DatePicker Date;
    @FXML
    private Spinner<Integer> Rating;


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
      if(event.getSource()==ADDTourinfor){
          if(Destination.textProperty().getValue().equals("")){
              tmViewModel.UPdateTDP(Departure.getText(),TourID);
              logger.debug("{} - ADD Departure ",Tourname);
          }
          else if(Departure.textProperty().getValue().equals("")){
              tmViewModel.UPdateTDT(Destination.getText(),TourID);
              logger.debug("{} - ADD Destination",Tourname);
          }else {
              tmViewModel.UPdateT(Departure.getText(),Destination.getText(),TourID);
              logger.debug("{} - ADD Departure and Destination",Tourname);
          }
      }

            if (event.getSource() == ADDLog) {


                if(Date.getValue()==null || Duration.getText()==null||Rating.getValue()==null||WeatherCB.getValue()==null||Distance.getText()==null){
                    logger.debug("error");
                    ErrorController.msg="Log information is incomplete";
                    try {
                        WindowController.Windowlunch("error.fxml",400,300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    logger.debug("Log insert");
                    tmViewModel.insertLog(java.sql.Date.valueOf(Date.getValue().toString()), Time.valueOf(Duration.getText()),
                            TourID, Rating.getValue(), WeatherCB.getValue(), Integer.parseInt(Distance.getText()));
                }



            }



    }
}
