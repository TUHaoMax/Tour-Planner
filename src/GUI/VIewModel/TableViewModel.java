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

import java.sql.Date;
import java.sql.Time;

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

    public void date_up(Date date,int Id){
       ToursData.Dosql(SQL.Logs_date_update,date,Id);
    }

    public void duration_up(Time Da,int Id){
       ToursData.Dosql(SQL.Logs_duration_update,Da,Id);
    }

    public void rating_up(int rating,int Id){
       ToursData.Dosql(SQL.Logs_rating_update,rating,Id);
    }

    public void weather_up(String weather,int Id){
       ToursData.Dosql(SQL.Logs_weather_update,weather,Id);
    }

    public void distance_up(int distance,int Id){
       ToursData.Dosql(SQL.Logs_distance_update,distance,Id);
    }
}
