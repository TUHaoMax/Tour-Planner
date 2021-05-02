package GUI.Controller;

import DataALayer.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
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

