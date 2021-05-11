package DataALayer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DataRstTest {

    @Test
    void getResultSet() {
        int i=0;
        ArrayList<ArrayList> testList=new ArrayList<ArrayList>();
        testList=DataRst.gettourinforResultSet();
        if(testList.get(0).contains("Tour-1")){
            i=testList.get(0).indexOf("Tour-1");
            System.out.println(testList.get(0).indexOf("Tour-1"));
        }
        System.out.println(testList.get(1).get(i));
    }

    @Test
    void Ordertest(){

    }

}