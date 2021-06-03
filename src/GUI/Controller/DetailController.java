package GUI.Controller;

import BusinessLayer.tourinformanager;
import GUI.VIewModel.TMViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(DetailController.class);
    private tourinformanager tourinformanager=new tourinformanager();
    private TMViewModel tmViewModel=new TMViewModel();
    public static String Tname;

    @FXML
    private Label test;
    @FXML
    private TextField Departure,Destination;
    @FXML
    private TextArea Description;
    @FXML
    private Button Update;
    @FXML
    private AnchorPane thisPane;

    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test.setText(Tname);
        tourinformanager.settour(Tname);
        Departure.setText(tourinformanager.getDeparture());
        Destination.setText(tourinformanager.getDestination());

    }


    @Override
    public void handle(ActionEvent event) {
       if(event.getSource()==Update){
           if(Departure.getText()=="" || Destination.getText()==""){
               logger.debug("error information is incomplete");
               ErrorController.msg="information is incomplete";
               try {
                   WindowController.Windowlunch("error.fxml",400,300);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }else {
               tmViewModel.UPdateT(Departure.getText(),Destination.getText(),tourinformanager.TourId);

               if(Description.getText()!=null && Description.getText()!=""){
                   tmViewModel.UPdataTDS(Description.getText(),tourinformanager.TourId);


               }
               tourinformanager.settour(Tname);
               tourinformanager.BuildTourDescription();
               DescriptionController.descriptionViewModel.Description.set(tourinformanager.FinalDescription);
           }
       }


        stage=(Stage) thisPane.getScene().getWindow();
        stage.close();
    }


}
