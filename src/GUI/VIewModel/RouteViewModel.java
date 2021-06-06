package GUI.VIewModel;


import APP.Config;
import BusinessLayer.MapQuestManager;
import BusinessLayer.tourinformanager;
import DataALayer.JsonParse;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class RouteViewModel {
    private static final Logger logger= LoggerFactory.getLogger(RouteViewModel.class);
    public static Config config=new Config();

    public SimpleStringProperty TourName=new SimpleStringProperty("Home");
    tourinformanager tim;
    private String path;
    private String Searchpath;
    public Image image;


    public RouteViewModel() {
        config= JsonParse.getConfig(JsonParse.readConfig());
        path= config.RoutePath;
        Searchpath=config.Searchpath;
        this.image =new Image(getClass().getResourceAsStream(path+TourName.getValue()+".jpg"));
    }

    public void getMap(){
        tim=new tourinformanager();
            tim.settour(TourName.getValue());
                MapQuestManager.setinfor(TourName.getValue(), tim.getDeparture(), tim.getDestination());
                MapQuestManager.sendHttp();

    }

    public int inforCheck(){
        tim=new tourinformanager();
        tim.settour(TourName.getValue());
          if(tim.Departure=="" || tim.destination==""){
              logger.debug("no location");
              return 0;
          }
          return 1;
    }
    public void deleteImage(String name){
      File file=new File(Searchpath+name+".jpg");
        System.out.println(file.getAbsolutePath());
      if(file.exists()){
          file.delete();
          logger.debug("{} deleted",name+".jpg");
      }else {
          logger.debug("no file {}",name+".jpg");
      }

    }
}
