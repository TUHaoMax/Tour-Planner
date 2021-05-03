package GUI.Controller;

import DataALayer.SQL;
import DataALayer.ToursData;
import GUI.VIewModel.ListViewModel;
import GUI.VIewModel.MainViewModel;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class SampleController implements Initializable{
    public SampleController() {
        this.mainViewModel = new MainViewModel();
    }

    MainViewModel mainViewModel;
    ListViewModel listView=new ListViewModel();

     @FXML
     private ListView<String> ListTours;
     @FXML
     private Label TourLabel;
     @FXML
     private TextField Tourname;

      String currentTour;


    public void tosample(ActionEvent actionEvent)  {
       int i=listView.addTour(Tourname.textProperty().getValue());
    }

    public void deletetour(ActionEvent actionEvent){
        int i=listView.deletecurrentTour(currentTour);
    }


      @Override
      public void initialize(URL url, ResourceBundle resourceBundle){
       // this.ListTours.setItems(mainViewModel.getTourNames());
        //this.ListTours.setItems(listView.getNamelist());
          System.out.println(listView.getTourinforlist().get(0));
        this.ListTours.getItems().addAll(listView.getTourinforlist().get(0));


            ListTours.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    currentTour=ListTours.getSelectionModel().getSelectedItem();
                    TourLabel.setText(currentTour);
                    System.out.println(currentTour);
                }
            });

           //ListTours.getSelectionModel().selectedItemProperty().addListener( (v,old,newvalue) -> currentTour=newvalue);


    }
}

