package BusinessLayer;

import DataALayer.DataRst;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class tourinformanager  {

    public  ArrayList<ArrayList> tourinforlist;
    public  int index=0;
    public  String Departure;
    public  String destination;
    public  String Name;
    public  int TourId;
    public String Description="";

    public tourinformanager() {
        tourinforlist= DataRst.gettourinforResultSet();
    }

    public  void settour(String name){
        if(name!=null){
            tourinforlist= DataRst.gettourinforResultSet();
            index=tourinforlist.get(0).indexOf(name);
            Departure= (String) tourinforlist.get(1).get(index);
            destination= (String) tourinforlist.get(2).get(index);
            TourId= (int) tourinforlist.get(3).get(index);
            Name=name;
        }

    }

    public void BuildTourDescription(){
        Description="";
        Description=Description.concat(Name).concat(":\n").concat(Departure).concat("--->").concat(destination).concat("\n\n");
    }

}
