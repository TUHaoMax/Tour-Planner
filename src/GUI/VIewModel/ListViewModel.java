package GUI.VIewModel;

import BusinessLayer.bl;
import DataALayer.DataRst;
import DataALayer.SQL;
import DataALayer.ToursData;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.util.ArrayList;


@Getter
public class ListViewModel {
    private ArrayList<ArrayList> tourinforlist;
    private ObservableList<String> namelist;

    public ListViewModel() {
        this.tourinforlist = DataRst.gettourinforResultSet();
    }

    public int deletecurrentTour(String currentTour){
        ToursData.Dosql(SQL.Tours_Delete,currentTour);
        return 0;
    }

    public int addTour(String Tourname){
        ToursData.Dosql(SQL.Tours_insert,Tourname);
        return 0;
    }
}
