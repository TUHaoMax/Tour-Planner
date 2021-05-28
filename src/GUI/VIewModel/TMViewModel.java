package GUI.VIewModel;

import DataALayer.SQL;
import DataALayer.ToursData;

import java.sql.Date;
import java.sql.Time;

public class TMViewModel {

    public void UPdateT(String DP,String DT,int Tid){

        ToursData.Dosql(SQL.Tours_update,DP,DT,Tid);
    }
    public void UPdateTDP(String DP,int Tid){

        ToursData.Dosql(SQL.Tours_DP,DP,Tid);
    }
    public void UPdateTDT(String DT,int Tid){
        ToursData.Dosql(SQL.Tours_DT,DT,Tid);
    }

    public void insertLog(Date Date, Time DA, int Tid, int Rating, String weather, int distance){

     ToursData.Dosql(SQL.Logs_insert,Date,DA,Tid,Rating,weather,distance);
    }

}
