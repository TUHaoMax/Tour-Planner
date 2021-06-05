package GUI.VIewModel;


import APP.APPLauncher;
import BusinessLayer.MapQuestManager;
import BusinessLayer.tourinformanager;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class RouteViewModel {
    private static final Logger logger= LoggerFactory.getLogger(RouteViewModel.class);
    public SimpleStringProperty TourName=new SimpleStringProperty("Home"+".jpg");
    tourinformanager tim;
    private String path= APPLauncher.config.RoutePath;
    private String Searchpath=APPLauncher.config.Searchpath;
    public Image image=new Image(getClass().getResourceAsStream(path+TourName.getValue()));

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
              return 0;
          }
          return 1;
    }
    public void deleteImage(String name){
      File file=new File("src/Resources/MapImage/"+name+".jpg");
        System.out.println(file.getAbsolutePath());
      if(file.exists()){
          file.delete();
          logger.debug("{} deleted",name+".jpg");
      }else {
          logger.debug("no file {}",name+".jpg");
      }

    }
}
