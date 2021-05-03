package GUI.VIewModel;

import BusinessLayer.*;
import DataALayer.DataRst;
import DataALayer.SQL;
import DataALayer.ToursData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class ListViewModel {

    private ObservableList<String> namelist;

    public ListViewModel() {
        namelist= FXCollections.observableArrayList();
        obserlist();

    }

    private void obserlist(){
        tourinformanager tim=new tourinformanager();
        this.namelist.clear();
        this.namelist.addAll(tim.gettourinfor().get(0));

    }


    public int deletecurrentTour(String currentTour){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
        obserlist();
        return 0;
    }

    public int addTour(String Tourname){
        ToursData.Dosql(SQL.Tours_insert,Tourname);
        obserlist();
        return 0;
    }
}
