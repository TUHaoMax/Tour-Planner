package BusinessLayer;

import DataALayer.DataRst;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class tourinformanager  {

    public ArrayList<ArrayList> tourinforlist=new ArrayList<>();
    public int index=0;
    public String Departure;
    public String destination;
    public String name;

    public tourinformanager() {
        this.tourinforlist= DataRst.gettourinforResultSet();
    }


    public void settour(String name){
         this.index=tourinforlist.get(0).indexOf(name);
         this.Departure= (String) tourinforlist.get(1).get(index);
         this.destination= (String) tourinforlist.get(2).get(index);
         this.name=name;
    }


}
