package BusinessLayer;

import DataALayer.DataRst;
import TourModels.TourLogs;

import java.util.ArrayList;

public class logsinformanager {
    public ArrayList<ArrayList> Logsinforlist;
    public ArrayList<TourLogs> Logslist=new ArrayList<>();


    public logsinformanager(int tid) {

        this.Logsinforlist = DataRst.getlogsResultSet(tid);
    }

    public void setLogslist(){
        for (int i=0;i<Logsinforlist.get(3).size();i++){
            this.Logslist.add(new TourLogs(Logsinforlist.get(0).get(i),Logsinforlist.get(1).get(i),
                    Logsinforlist.get(2).get(i),Logsinforlist.get(3).get(i),
                    Logsinforlist.get(4).get(i),Logsinforlist.get(5).get(i),
                    Logsinforlist.get(6).get(i)));
        }
    }

}
