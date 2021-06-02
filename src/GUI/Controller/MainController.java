package GUI.Controller;

import BusinessLayer.tourinformanager;
import GUI.VIewModel.ListViewModel;
import GUI.VIewModel.ReportingViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
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
import java.util.ResourceBundle;
import java.util.function.Predicate;

@Getter
@Setter
public class MainController implements Initializable, EventHandler<ActionEvent>{
    private static final Logger logger= LoggerFactory.getLogger(MainController.class);

    ReportingViewModel reporting=new ReportingViewModel();
    ListViewModel listView=new ListViewModel();
    tourinformanager tim=new tourinformanager();


    //@FXML
    //private TextArea test;
    @FXML
    public ListView<String> ListTours;
    @FXML
    private TMController TMC=new TMController();
    @FXML
    private DetailController DC=new DetailController();
    @FXML
    private TextField Tourname;
    @FXML
    private Label TourListLabel,mainlabel;
    @FXML
    private Button plus,minus,PDF,edit;



    public static String currentTour;
    public static int currentTourId;
    public static int currentLogId;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        this.ListTours.setItems(listView.getNamelist());

       TextFieldListener();

       ListListener();

       ListMouseClick();

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

    }

    private void TextFieldListener(){
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
    }

    private void ListListener(){
        ListTours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                currentTour=ListTours.getSelectionModel().getSelectedItem();
                tim.settour(currentTour);
                currentTourId= tim.TourId;

                TMC.setTT(currentTour,currentTourId);

                DescriptionController.descriptionViewModel.Desvription.set(currentTour);

                mainlabel.setText(currentTour);

                TableController.tableViewModel.settourLogs(currentTourId);

            }
        });
    }

    private void ListMouseClick(){
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
    }

}

