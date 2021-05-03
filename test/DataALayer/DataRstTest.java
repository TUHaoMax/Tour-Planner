package DataALayer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataRstTest {

    @Test
    void getResultSet() {
        ArrayList<ArrayList> testList=new ArrayList<ArrayList>();
        testList=DataRst.gettourinforResultSet(SQL.Tours_selectall);
        System.out.println(testList.get(1).get(0));
    }

}