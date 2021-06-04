package GUI.VIewModel;

import BusinessLayer.MapQuestManager;
import javafx.beans.property.SimpleStringProperty;

public class RouteViewModel {
    public SimpleStringProperty MapName=new SimpleStringProperty("test.jpg");


    public void test(){
        MapQuestManager.sendHttp();
    }
}
