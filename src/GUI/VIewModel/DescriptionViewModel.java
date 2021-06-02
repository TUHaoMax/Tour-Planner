package GUI.VIewModel;

import javafx.beans.property.SimpleStringProperty;

public class DescriptionViewModel {
    public SimpleStringProperty Description;

    public DescriptionViewModel() {
        Description =new SimpleStringProperty("Please select a tour");
    }



}
