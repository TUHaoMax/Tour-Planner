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
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

@Getter
@Setter
public class MainController implements Initializable, EventHandler<ActionEvent>{
    private static final Logger logger= LoggerFactory.getLogger(MainController.class);

    ReportingViewModel reporting=new ReportingViewModel();
    ListViewModel listView=new ListViewModel();
    TableViewModel tableViewModel=new TableViewModel();
    tourinformanager tim=new tourinformanager();


    @FXML
    private TextArea test;
    @FXML
    public ListView<String> ListTours;
    @FXML
    private TMController TMC=new TMController();
    @FXML
    private DetailController DC=new DetailController();
    @FXML
    private TextField Tourname;
    @FXML
    private Label LogsLabel,TourListLabel,mainlabel;
    @FXML
    private Button plus,minus,PDF,edit,logminus;
    @FXML
    private TableColumn<TourLogs,String> Date,Time,Distance,Weather,Rating;

    @FXML
    private TableView<TourLogs> TableView;


    public static String currentTour;
    public static int currentTourId;
    public static int currentLogId;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){


        this.ListTours.setItems(listView.getNamelist());

        Date.setCellValueFactory(new PropertyValueFactory<>("LogDate"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Logtime"));
        Distance.setCellValueFactory(new PropertyValueFactory<>("Distance"));
        Weather.setCellValueFactory(new PropertyValueFactory<>("weather"));
        Rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        try {

            Tourname.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if (t1.equals("")) {
                        TourListLabel.setText("Tours List");
                    } else {
                        TourListLabel.setText(t1);
                    }
                    FilteredList<String> FL = listView.getNamelist().filtered(new Predicate<String>() {
                        @Override
                        public boolean test(String s) {
                            if (s.contains(Tourname.getText())) {
                                if (!Tourname.getText().equals("")) {
                                    logger.debug("Tour finded {}", s);
                                }
                                return true;
                            } else {
                                return false;
                            }
                        }
                    });
                    ListTours.setItems(FL);
                }
            });

        }catch (Exception e) {
            e.printStackTrace();
        }

        ListTours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentTour=ListTours.getSelectionModel().getSelectedItem();
                tim.settour(currentTour);
                currentTourId= tim.TourId;

                TMC.setTT(currentTour,currentTourId);

                DescriptionController.listViewModel.Tname.set(currentTour);

                mainlabel.setText(currentTour);
                LogsLabel.setText(currentTour+" "+" Logs:");
                TableView.setItems(tableViewModel.settourLogs(currentTourId));
            }
        });

        ListTours.setOnMouseClicked(mouseEvent -> {
            switch (mouseEvent.getClickCount()) {
                case 2:
                    DetailController.Tname=currentTour;
                    try {
                        WindowController.Windowlunch("Detail.fxml",300,200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        });

        TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TourLogs>() {
            @Override
            public void changed(ObservableValue<? extends TourLogs> observableValue, TourLogs tourLogs, TourLogs t1) {
                if(t1!=null){
                    currentLogId=t1.getId();
                    logger.debug("Logs finded {}", t1.getId());
                }

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

        if(actionEvent.getSource()==PDF){
            reporting.PDfcreate(currentTour);
        }
        if(actionEvent.getSource()==logminus){
            tableViewModel.deletelog(currentLogId);
            TableView.setItems(tableViewModel.settourLogs(currentTourId));
        }
    }

    public void MouseHandle(MouseEvent mouseEvent){

    }
}

