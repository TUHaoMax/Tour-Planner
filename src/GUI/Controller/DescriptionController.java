package GUI.Controller;

import GUI.VIewModel.ListViewModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class DescriptionController implements Initializable, EventHandler<ActionEvent> {
    public static ListViewModel listViewModel=new ListViewModel();

    @FXML
    private TextArea test;
    @Override
    public void handle(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        test.textProperty().bind(listViewModel.Tname);
    }
}
