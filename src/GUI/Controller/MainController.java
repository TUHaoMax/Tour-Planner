package GUI.Controller;

import GUI.VIewModel.MainViewModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    // create custom viewmodel
    public MainViewModel viewModel = new MainViewModel();
    public sample sample=new sample();
    // add fx:id and use intelliJ to create field in controller
    public TextField InputTextField;
    public Label OutputLabel;

    public MainController()
    {
        System.out.println("GUI.Controller created");
    }

    @FXML
    public void calculateOutput(ActionEvent actionEvent) {
        System.out.println("GUI.Controller calculate");
        viewModel.calculateOutputString();
    }
    public void tosample1(ActionEvent actionEvent) throws Exception {
        WindowController.Windowlaunch("sample.fxml");

    }
    public void tosample2(ActionEvent actionEvent) throws Exception {
        WindowController.Windowlaunch("Main.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("GUI.Controller init");

        InputTextField.textProperty().bindBidirectional(viewModel.inputProperty());

        // OutputLabel.textProperty().bindBidirectional(viewModel.outputProperty());
        Bindings.bindBidirectional(OutputLabel.textProperty(), viewModel.outputProperty());
    }
}
