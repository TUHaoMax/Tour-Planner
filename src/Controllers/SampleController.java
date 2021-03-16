package Controllers;
import UI.*;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;



public class SampleController implements Initializable{
     @FXML
     private ListView<String> ListTours;
     String[] test={"T1","T2","T3"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        ListTours.getItems().addAll(test);

    }
}

