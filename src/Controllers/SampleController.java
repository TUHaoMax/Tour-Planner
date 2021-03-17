package Controllers;
import Data.SQL;
import Data.ToursData;
import UI.*;
import UI.sample;
import javafx.scene.control.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.beans.Observable;
import org.w3c.dom.ls.LSOutput;

import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;



public class SampleController implements Initializable{
     @FXML
     private ListView<String> ListTours;

     @FXML
     private Label TourLabel;

      ResultSet resultSet= ToursData.Getsql(SQL.Tours_selectall);
      String currentTour;

    public void tosample(ActionEvent actionEvent) throws Exception {
        System.out.println("to sample");
        UI.sample sample=new sample();
        sample.showWindow();
    }

    public void deletetour(){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
    }


      @Override
      public void initialize(URL url, ResourceBundle resourceBundle){


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

