package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogDetailController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private AnchorPane thisPane;
    @FXML
    private ChoiceBox<String> WeatherCB;
    @FXML
    private TextField Duration,Distance;
    @FXML
    private Button update;
    @FXML
    private DatePicker Date;
    @FXML
    private Spinner<Integer> Rating;

    Stage stage;
    private static String[] Weather={"sunshine","rain","snow","cloud","fog","wind","thunderstorm"};
    private static String currentweather;

    @Override
    public void handle(ActionEvent event) {
        stage=(Stage) thisPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WeatherCB.getItems().addAll(Weather);
        WeatherCB.setOnAction(this::ChoiceWeather);
    }

    private void ChoiceWeather(ActionEvent event){
        currentweather=WeatherCB.getValue();
        System.out.println(currentweather);
    }
}
