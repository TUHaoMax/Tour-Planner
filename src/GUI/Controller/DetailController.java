package GUI.Controller;

import BusinessLayer.tourinformanager;
import GUI.VIewModel.TMViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable, EventHandler<ActionEvent> {
    private tourinformanager tourinformanager=new tourinformanager();
    private TMViewModel tmViewModel=new TMViewModel();
    public static String Tname;

    @FXML
    private Label test;
    @FXML
    private TextField Departure,Destination;
    @FXML
    private Button Update;
    @FXML
    private AnchorPane thisPane;

    Stage stage;

    @Override
    public void handle(ActionEvent event) {
       if(event.getSource()==Update){
           tmViewModel.UPdateT(Departure.getText(),Destination.getText(),tourinformanager.TourId);

           stage=(Stage) thisPane.getScene().getWindow();
           stage.close();
       }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
               test.setText(Tname);

               tourinformanager.settour(Tname);
               Departure.setText(tourinformanager.getDeparture());
               Destination.setText(tourinformanager.getDestination());

    }
}
