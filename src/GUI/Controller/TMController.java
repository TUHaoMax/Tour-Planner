package GUI.Controller;

import GUI.VIewModel.DetailViewModel;
import GUI.VIewModel.RouteViewModel;
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

    RouteViewModel routeViewModel=new RouteViewModel();
    TMViewModel tmViewModel=new TMViewModel();
    DetailViewModel DVModel=new DetailViewModel();

    private static int TourID;
    private static String Tourname;
    private static String[] Weather={"sunshine","rain","snow","cloud","fog","wind","thunderstorm"};
    private static String currentweather;

    @FXML
    private ChoiceBox<String> WeatherCB;
    @FXML
    private TextField Departure,Destination,Duration,Distance,transport;
    @FXML
    private TextArea Description;
    @FXML
    private Button ADDTourinfor,ADDLog,ADD_DS;
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
               WeatherCB.getItems().addAll(Weather);
               WeatherCB.setOnAction(this::ChoiceWeather);

    }

    @Override
    public void handle(ActionEvent event) {
      if(event.getSource()==ADDTourinfor){
          if(!Departure.textProperty().getValue().equals("")){
              tmViewModel.UPdateTDP(Departure.getText(),TourID);
              routeViewModel.deleteImage(Tourname);
          }
          if(!Destination.textProperty().getValue().equals("")){
              tmViewModel.UPdateTDT(Destination.getText(),TourID);
              routeViewModel.deleteImage(Tourname);
          }

          DVModel.resetDescription(Tourname);
          Departure.setText("");
          Destination.setText("");
      }

            if (event.getSource() == ADDLog) {
                if(Date.getValue()==null || Duration.getText()=="" ||Rating.getValue()==0 ||WeatherCB.getValue()==null||Distance.getText()==""||transport.getText()==""){
                    logger.debug("error Log information is incomplet");
                    ErrorController.msg="Log information is incomplete";
                    try {
                        WindowController.Windowlunch("error.fxml",400,300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    tmViewModel.insertLog(java.sql.Date.valueOf(Date.getValue().toString()), Time.valueOf(Duration.getText()),
                            TourID, Rating.getValue(), WeatherCB.getValue(), Integer.parseInt(Distance.getText()),transport.getText());

                    TableController.tableViewModel.settourLogs(TourID);
                    Duration.setText("");
                    Distance.setText("");
                }

            }

            if(event.getSource()==ADD_DS){
                if(Description.getText()!=""){
                    tmViewModel.UPdataTDS(Description.getText(),TourID);

                    DVModel.resetDescription(Tourname);
                    Description.setText("");
                }
            }

    }

}
