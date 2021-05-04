package GUI.Controller;

import GUI.VIewModel.ListViewModel;
import GUI.VIewModel.ReportingViewModel;
import TourModels.TourLogs;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;



public class MainController implements Initializable, EventHandler<ActionEvent> {

    ReportingViewModel reporting=new ReportingViewModel();
    ListViewModel listView=new ListViewModel();

    @FXML
    private ListView<String> ListTours;
    @FXML
    private Label TourLabel;
    @FXML
    private TextField Tourname;
    @FXML
    private Label LogsLabel;
    @FXML
    private Button plus,minus,edit,PDF;
    @FXML
    private TableView<TourLogs> TableView;

    String currentTour;


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

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==plus){
            int i=listView.addTour(Tourname.textProperty().getValue());
        }
        if(actionEvent.getSource()==minus){
            int i=listView.deletecurrentTour(currentTour);
        }
        if(actionEvent.getSource()==edit){
            try {
                WindowController.Windowlaunch("Tourmanage.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(actionEvent.getSource()==PDF){
            reporting.PDfcreate(currentTour);
        }
    }
}

