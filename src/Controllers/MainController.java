package Controllers;
import UI.*;

import UI.MainViewModel;
import UI.sample;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
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
        System.out.println("Controller created");
    }

    @FXML
    public void calculateOutput(ActionEvent actionEvent) {
        System.out.println("Controller calculate");
        viewModel.calculateOutputString();
    }
    public void tosample1(ActionEvent actionEvent) throws Exception {
        System.out.println("to sample-1");
        UI.sample sample=new sample();
        sample.showWindow();
    }
    public void tosample2(ActionEvent actionEvent) throws Exception {
        System.out.println("to sample-2");
        UI.sample2 sample=new sample2();
        sample.showWindow();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Controller init");

        InputTextField.textProperty().bindBidirectional(viewModel.inputProperty());

        // OutputLabel.textProperty().bindBidirectional(viewModel.outputProperty());
        Bindings.bindBidirectional(OutputLabel.textProperty(), viewModel.outputProperty());
    }
}
