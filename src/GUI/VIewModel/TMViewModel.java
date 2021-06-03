package GUI.VIewModel;

import DataALayer.SQL;
import DataALayer.ToursData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.Time;

public class TMViewModel {
    private static final Logger logger= LoggerFactory.getLogger(TMViewModel.class);

    public void UPdateT(String DP,String DT,int Tid){
        ToursData.Dosql(SQL.Tours_update,DP,DT,Tid);

        logger.debug("Tour:{} : {} -> {} update",Tid,DP,DT);
    }
    public void UPdateTDP(String DP,int Tid){
        ToursData.Dosql(SQL.Tours_DP,DP,Tid);

        logger.debug("{} - ADD Departure {}",Tid,DP);
    }
    public void UPdateTDT(String DT,int Tid){
        ToursData.Dosql(SQL.Tours_DT,DT,Tid);

        logger.debug("{} - ADD Destination {}",Tid,DT);
    }

    public void UPdataTDS(String DS,int Tid){
        ToursData.Dosql(SQL.Tours_DS,DS,Tid);

        logger.debug("{}-> Description : {}  insert",Tid,DS);
    }

    public void insertLog(Date Date, Time DA, int Tid, int Rating, String weather, int distance){

     ToursData.Dosql(SQL.Logs_insert,Date,DA,Tid,Rating,weather,distance);

        logger.debug("Log insert");
    }

}
