package GUI.Controller;

import DataALayer.SQL;
import DataALayer.ToursData;
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

     @FXML
     private ListView<String> ListTours;

     @FXML
     private Label TourLabel;

      ResultSet resultSet= ToursData.Getsql(SQL.Tours_selectall);
      String currentTour;


    public void tosample(ActionEvent actionEvent) throws Exception {
        WindowController.Windowlaunch("sample.fxml");
    }

    public void deletetour(){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
    }


      @Override
      public void initialize(URL url, ResourceBundle resourceBundle){
        //this.ListTours.setItems(mainViewModel.getTourNames());

          try {
              while (resultSet.next()){
                  ListTours.getItems().add(resultSet.getString("name"));

              }
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }

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

