package GUI.Controller;

import BusinessLayer.tourinformanager;
import GUI.VIewModel.ListViewModel;
import GUI.VIewModel.ReportingViewModel;
import GUI.VIewModel.TableViewModel;
import TourModels.TourLogs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;


public class MainController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(MainController.class);

    ReportingViewModel reporting=new ReportingViewModel();
    ListViewModel listView=new ListViewModel();
    TableViewModel tableViewModel=new TableViewModel();
    tourinformanager tim=new tourinformanager();

    @FXML
    private ListView<String> ListTours;
    @FXML
    private Label TourLabel;
    @FXML
    private TextField Tourname;
    @FXML
    private Label LogsLabel,TourListLabel;
    @FXML
    private Button plus,minus,edit,PDF;
    @FXML
    private TableColumn<TourLogs,String> Date,Time;

    @FXML
    private TableView<TourLogs> TableView;


    String currentTour;
    int currentTourId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.ListTours.setItems(listView.getNamelist());

        Date.setCellValueFactory(new PropertyValueFactory<>("LogDate"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Logtime"));


        Tourname.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.equals("")){
                    TourListLabel.setText("Tours List");
                }else {
                    TourListLabel.setText(t1);
                }
                FilteredList<String> FL=listView.getNamelist().filtered(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        if(s.contains(Tourname.getText())){
                            if(!Tourname.getText().equals("")){
                                logger.debug("Tour finded {}",s);
                            }
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                });
                ListTours.setItems(FL);
            }
        });


        ListTours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentTour=ListTours.getSelectionModel().getSelectedItem();
                tim.settour(currentTour);
                currentTourId= tim.TourId;
                TourLabel.setText(currentTour+" "+currentTourId);
                LogsLabel.setText(currentTour+" "+currentTourId+" Logs:");
                TableView.setItems(tableViewModel.settourLogs(currentTourId));
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

