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
    RouteViewModel routeViewModel=new RouteViewModel();
    private ObservableList<String> namelist;
    tourinformanager tim;


    public ListViewModel() {
        namelist= FXCollections.observableArrayList();
        obserlist();
    }

    private void obserlist(){
        tim=new tourinformanager();
        if(tim.tourinforlist.size()!=0){
            this.namelist.setAll(tim.tourinforlist.get(0));
        }

    }


    public int deletecurrentTour(String currentTour){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
        logger.debug("{} Delete",currentTour);
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

    private void ClearList() {
        this.namelist.clear();
    }
}
