package GUI.VIewModel;


import APP.APPLauncher;
import BusinessLayer.MapQuestManager;
import BusinessLayer.tourinformanager;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

public class RouteViewModel {
    public SimpleStringProperty TourName=new SimpleStringProperty("Home.jpg");
    tourinformanager tim=new tourinformanager();
    private String path= APPLauncher.config.RoutePath;
    public Image image=new Image(getClass().getResourceAsStream(path+TourName.getValue()));

    public void getMap(){
        tim.settour(TourName.getValue());
        MapQuestManager.setinfor(TourName.getValue(),tim.getDeparture(),tim.getDestination());
        MapQuestManager.sendHttp();
    }

    public void test(){

    }
}
