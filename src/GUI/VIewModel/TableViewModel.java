package GUI.VIewModel;

import BusinessLayer.logsinformanager;
import DataALayer.SQL;
import DataALayer.ToursData;
import TourModels.TourLogs;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TableViewModel {
   private ObservableList<TourLogs> tourLogs= FXCollections.observableArrayList();
    public SimpleStringProperty Loglabel;
   public TableViewModel() {
       Loglabel=new SimpleStringProperty("Logs: ");
   }

   public void settourLogs(int TID){
      this.tourLogs.clear();
      logsinformanager lim=new logsinformanager(TID);
      for (int i=0;i<lim.Logsinforlist.get(3).size();i++){
         this.tourLogs.add(new TourLogs(lim.Logsinforlist.get(0).get(i),lim.Logsinforlist.get(1).get(i),
                 lim.Logsinforlist.get(2).get(i),lim.Logsinforlist.get(3).get(i),
                 lim.Logsinforlist.get(4).get(i),lim.Logsinforlist.get(5).get(i),
                 lim.Logsinforlist.get(6).get(i)));
      }

    }

    public void deletelog(int ID){
       ToursData.Dosql(SQL.Logs_Delete,ID);
    }

}
