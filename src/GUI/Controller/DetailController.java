package GUI.Controller;

import GUI.VIewModel.DetailViewModel;
import GUI.VIewModel.ListViewModel;
import GUI.VIewModel.RouteViewModel;
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
    private ListViewModel listViewModel=new ListViewModel();
    public static String Tname;
    DetailViewModel DViewModel=new DetailViewModel();
    RouteViewModel routeViewModel=new RouteViewModel();

    @FXML
    private Label test;
    @FXML
    private TextField Departure,Destination,TourName;
    @FXML
    private TextArea Description;
    @FXML
    private Button Update,Quit;
    @FXML
    private AnchorPane thisPane;

    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test.setText(Tname);
        DViewModel.setDPDT(Tname);


    }


    @Override
    public void handle(ActionEvent event) {
       if(event.getSource()==Update){

           if(Departure.getText()!=""&&Departure.getText()!=null){
               DViewModel.UpdateTourDP(Departure.getText());
               routeViewModel.deleteImage(Tname);
           }
           if(Destination.getText()!=""&&Destination.getText()!=null){
              DViewModel.UpdateTourDT(Destination.getText());
               routeViewModel.deleteImage(Tname);
           }

               if(Description.getText()!=null && Description.getText()!=""){
                   DViewModel.UpdateDS(Description.getText());
               }


               if(TourName.getText()!=null&&TourName.getText()!=""){
                   int i=listViewModel.CheckName(TourName.getText());
                   if(i==0){
                       routeViewModel.deleteImage(Tname);
                       Tname=TourName.getText();
                       DViewModel.UpdateTourName(TourName.getText());

                   }else {
                       logger.debug("error TourName is already exists");
                       ErrorController.msg="TourName is already exists";
                       try {
                           WindowController.Windowlunch("error.fxml",400,300);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               }

                    Departure.setText("");
                   Destination.setText("");
                   TourName.setText("");
                   Description.setText("");
               test.setText(Tname);
               DViewModel.resetDescription(Tname);
       }

       if(event.getSource()==Quit) {
           stage = (Stage) thisPane.getScene().getWindow();
           stage.close();
       }
    }


}
