package GUI.Controller;

import GUI.VIewModel.TableViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

public class LogDetailController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(LogDetailController.class);
     TableViewModel tableViewModel=new TableViewModel();

    @FXML
    private AnchorPane thisPane;
    @FXML
    private ChoiceBox<String> WeatherCB;
    @FXML
    private TextField Duration,Distance,Transport;
    @FXML
    private Button update;
    @FXML
    private DatePicker Date;
    @FXML
    private Spinner<Integer> Rating;
    @FXML
    private Label MainLabel;

    Stage stage;
    private  String[] Weather={"sunshine","rain","snow","cloud","fog","wind","thunderstorm"};
    private  String currentweather;
    public static int LogID;
    public static String Tname;
    public static int TourID;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainLabel.setText("Tour: ["+TourID+"] "+Tname+" LogId: "+LogID);
        WeatherCB.getItems().addAll(Weather);
        WeatherCB.setOnAction(this::ChoiceWeather);
    }



    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==update){
            if(Duration.getText()!="" && Duration.getText()!=null){
               tableViewModel.duration_up(Time.valueOf(Duration.getText()),LogID);
            }
            if(Distance.getText()!="" && Distance.getText()!=null){
                tableViewModel.distance_up(Integer.parseInt(Distance.getText()),LogID);

            }
            if(Date.getValue()!=null){
                tableViewModel.date_up(java.sql.Date.valueOf(Date.getValue().toString()),LogID);

            }
            if(Rating.getValue()!=null && Rating.getValue()!=0){
                tableViewModel.rating_up(Rating.getValue(),LogID);

            }
            if(WeatherCB.getValue()!=null){
                tableViewModel.weather_up(WeatherCB.getValue(),LogID);

            }
            if(Transport.getText()!=null&&Transport.getText()!=""){
                tableViewModel.transport_up(Transport.getText(),LogID);
            }
         TableController.tableViewModel.settourLogs(TourID);
                    Duration.setText("");
                    Distance.setText("");
                    Transport.setText("");
        }else {
            stage = (Stage) thisPane.getScene().getWindow();
            stage.close();
        }
    }



    private void ChoiceWeather(ActionEvent event){
        currentweather=WeatherCB.getValue();
    }
}
