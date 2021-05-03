package GUI.Controller;

import GUI.VIewModel.ListViewModel;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;



public class MainController implements Initializable{


    ListViewModel listView=new ListViewModel();

    @FXML
    private ListView<String> ListTours;
    @FXML
    private Label TourLabel;
    @FXML
    private TextField Tourname;
    @FXML
    private Label LogsLabel;

    String currentTour;


    public void tosample(ActionEvent actionEvent)  {
        int i=listView.addTour(Tourname.textProperty().getValue());
    }

    public void deletetour(ActionEvent actionEvent){
        int i=listView.deletecurrentTour(currentTour);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        this.ListTours.setItems(listView.getNamelist());

        ListTours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentTour=ListTours.getSelectionModel().getSelectedItem();
                TourLabel.setText(currentTour);
                LogsLabel.setText(currentTour+" Logs:");
            }
        });

        //ListTours.getSelectionModel().selectedItemProperty().addListener( (v,old,newvalue) -> currentTour=newvalue);


    }
}

