package GUI.Controller;

import GUI.VIewModel.DescriptionViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class DescriptionController implements Initializable, EventHandler<ActionEvent> {

    public static DescriptionViewModel descriptionViewModel=new DescriptionViewModel();

    @FXML
    private TextArea Description;
    @Override
    public void handle(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Description.textProperty().bind(descriptionViewModel.Desvription);
    }
}
