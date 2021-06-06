package TourModels;

import BusinessLayer.logsinformanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

class TourLogsTest {

    @Test
    void setlogs(){
        logsinformanager lim=new logsinformanager(5);
        System.out.println(lim.Logsinforlist);
        ObservableList<TourLogs> tourLogs= FXCollections.observableArrayList();
        for (int i=0;i<lim.Logsinforlist.get(3).size();i++){
            tourLogs.add(new TourLogs(lim.Logsinforlist.get(0).get(i),lim.Logsinforlist.get(1).get(i),
                    lim.Logsinforlist.get(2).get(i),lim.Logsinforlist.get(3).get(i),
                    lim.Logsinforlist.get(4).get(i),lim.Logsinforlist.get(5).get(i),
                    lim.Logsinforlist.get(6).get(i),lim.Logsinforlist.get(7).get(i)));
        }

        for (int i=0;i<tourLogs.size();i++){
            System.out.println(tourLogs.get(i).getLogDate());
            System.out.println(tourLogs.get(i).getLogtime());
        }
    }
}