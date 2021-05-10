package GUI.VIewModel;

import BusinessLayer.logsinformanager;
import TourModels.TourLogs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TableViewModel {
   private ObservableList<TourLogs> tourLogs= FXCollections.observableArrayList();

   public TableViewModel() {
   }

   public ObservableList<TourLogs> settourLogs(int TID){
      this.tourLogs.clear();
      logsinformanager lim=new logsinformanager(TID);
      for (int i=0;i<lim.Logsinforlist.get(3).size();i++){
         this.tourLogs.add(new TourLogs(lim.Logsinforlist.get(1).get(i),
                 lim.Logsinforlist.get(2).get(i)));
      }
      return tourLogs;
    }
}
