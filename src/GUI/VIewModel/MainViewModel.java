package GUI.VIewModel;

import BusinessLayer.bl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class MainViewModel {
    // http://openbook.rheinwerk-verlag.de/javainsel/12_004.html
    private final StringProperty input = new SimpleStringProperty("");
    private final StringProperty output = new SimpleStringProperty("Hello VM!");
    private ObservableList<String> tourNames;

    public MainViewModel() {
        bl business = new bl();
        // bl.getAllTourNames();
        //this.tourNames = new ObservableList();
    }

    public StringProperty inputProperty() {
        System.out.println("VM: get input prop");
        return input;
    }

    public StringProperty outputProperty() {
        System.out.println("VM: get output prop");
        return output;
    }

    public void calculateOutputString() {
        System.out.println("VM: calculate Output");
        this.output.set("Hello ".concat(this.input.get()).concat("!"));
        this.input.set("");
    }
}