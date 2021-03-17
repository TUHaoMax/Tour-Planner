package Controllers;
import UI.*;
import Data.*;
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



public class sample implements Initializable{
   /* public Label OutputLabel;
    private final StringProperty output = new SimpleStringProperty("Hello VM!");
    Random random=new Random();

    public void OutputLabel(){
        System.out.println("\ntest");
        this.output.set(this.output.get().concat("\nSWE"));

    }

    public void OutNum(){
        System.out.println("\ntest");
        int n=random.nextInt();
        this.output.set(this.output.get().concat("\n"+String.valueOf(n)));
    }*/
     @FXML
     private TextField insertname;

     public void inserttour(){
         System.out.println(insertname.textProperty().getValue());
         ToursData.Dosql(SQL.Tours_insert,insertname.textProperty().getValue());

     }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }
}

