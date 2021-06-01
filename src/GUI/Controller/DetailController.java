package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable, EventHandler<ActionEvent> {

    public static String Tname;

    @FXML
    private Label test;

    @Override
    public void handle(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
               test.setText(Tname);


    }
}
