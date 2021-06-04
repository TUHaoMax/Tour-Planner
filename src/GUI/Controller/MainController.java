package GUI.Controller;

import BusinessLayer.tourinformanager;
import GUI.VIewModel.ImExportViewModel;
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
   public static ListViewModel listViewModel=new ListViewModel();
    tourinformanager tim=new tourinformanager();
    ImExportViewModel IEVM=new ImExportViewModel();

    @FXML
    private MenuItem Export,Import;
    @FXML
    public ListView<String> ListTours;
    @FXML
    private TMController TMC=new TMController();
    @FXML
    private DetailController DC=new DetailController();
    @FXML
    private TableController TC=new TableController();
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

        this.ListTours.setItems(listViewModel.getNamelist());

       TextFieldListener();

       ListListener();

       ListMouseClick();



        //ListTours.getSelectionModel().selectedItemProperty().addListener( (v,old,newvalue) -> currentTour=newvalue);

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource()==plus){
            int i=listViewModel.addTour(Tourname.textProperty().getValue());
           Tourname.setText("");
        }
        if(actionEvent.getSource()==minus){
            int i=listViewModel.deletecurrentTour(currentTour);
        }

        if(actionEvent.getSource()==PDF){
            reporting.PDfcreate(currentTour);
        }
        if(actionEvent.getSource()==Export){
            IEVM.Export(currentTour);
        }
        if(actionEvent.getSource()==Import){
            IEVM.Import();
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
                    FilteredList<String> FL = listViewModel.getNamelist().filtered(new Predicate<String>() {
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

                RouteController.routeViewModel.MapName.set("test_1.jpg");
                System.out.println(RouteController.routeViewModel.MapName);

                TMC.setTT(currentTour,currentTourId);

                 tim.BuildTourDescription();
                 DescriptionController.descriptionViewModel.Description.set(tim.FinalDescription);

                mainlabel.setText(currentTour);

                TC.setTableinfor(currentTour,currentTourId);
                TableController.tableViewModel.Loglabel.set(currentTour+" Logs:");
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
                        WindowController.Windowlunch("Detail.fxml",400,400);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        });
    }

}

