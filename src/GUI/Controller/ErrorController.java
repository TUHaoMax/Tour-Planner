package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    private Button Button;
    @FXML
    private TextArea errortext;
    @FXML
    private AnchorPane errorPane;

    Stage stage;

    public static String msg="test error";

    @Override
    public void handle(ActionEvent event) {
        stage=(Stage) errorPane.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        errortext.setText(msg);
    }
}
