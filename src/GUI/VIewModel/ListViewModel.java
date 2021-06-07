package GUI.VIewModel;

import BusinessLayer.tourinformanager;
import DataALayer.SQL;
import DataALayer.ToursData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Getter
@Setter
public class ListViewModel {
    private static final Logger logger= LoggerFactory.getLogger(ListViewModel.class);
    RouteViewModel routeViewModel;
    private ObservableList<String> namelist;
    tourinformanager tim;


    public ListViewModel() {
        namelist= FXCollections.observableArrayList();
        obserlist();
    }

    public void obserlist(){
        tim=new tourinformanager();
        /*if(tim.tourinforlist.size()!=0){
            this.namelist.setAll(tim.tourinforlist.get(0));
        }*/
        if(tim.tourinforlist.get(0).size()!=0){
            this.namelist.setAll(tim.tourinforlist.get(0));
        }else {
           // this.namelist.clear();
            this.namelist.setAll("Empty list No Tour List");
        }
    }


    public int deletecurrentTour(String currentTour){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
        logger.debug("{} Delete",currentTour);
        routeViewModel=new RouteViewModel();
        routeViewModel.deleteImage(currentTour);
        obserlist();
        return 0;
    }

    public int addTour(String Tourname){
        ToursData.Dosql(SQL.Tours_insert,Tourname);
        logger.debug("{} insert",Tourname);
        obserlist();
        return 0;
    }

    public void UpTourName(String name,int Id){
            ToursData.Dosql(SQL.Tours_UP_Name, name, Id);
            logger.debug("{} ID: {}  Name Changed", name, Id);
            obserlist();
    }

    public int CheckName(String name){
        if(namelist.contains(name)){
            return 1;
        }else {
            return 0;
        }
    }

    private void ClearList() {
        this.namelist.clear();
    }
}
