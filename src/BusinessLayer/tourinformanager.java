package BusinessLayer;

import DataALayer.DataRst;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.TimerTask;

@Getter
@Setter
public class tourinformanager  {


    public tourinformanager() {

    }
    public ArrayList<ArrayList> gettourinfor(){
        ArrayList<ArrayList> tourinforlist=DataRst.gettourinforResultSet();
        return tourinforlist;
    }

}
