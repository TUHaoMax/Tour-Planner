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

    private ObservableList<String> namelist;


    public ListViewModel() {
        namelist= FXCollections.observableArrayList();
        obserlist();
    }

    private void obserlist(){
        tourinformanager tim=new tourinformanager();
        this.namelist.clear();
        this.namelist.addAll(tim.tourinforlist.get(0));
    }


    public int deletecurrentTour(String currentTour){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
        logger.debug("{} Delete",currentTour);
        obserlist();
        return 0;
    }

    public int addTour(String Tourname){
        ToursData.Dosql(SQL.Tours_insert,Tourname);
        logger.debug("{} insert",Tourname);
        obserlist();
        return 0;
    }
}
