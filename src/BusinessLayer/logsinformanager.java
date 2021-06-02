package BusinessLayer;

import DataALayer.DataRst;

import java.util.ArrayList;

public class logsinformanager {
    public ArrayList<ArrayList> Logsinforlist;

    public logsinformanager(int tid) {

        this.Logsinforlist = DataRst.getlogsResultSet(tid);
    }



}
