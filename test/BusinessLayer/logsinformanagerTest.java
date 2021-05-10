package BusinessLayer;

import org.junit.jupiter.api.Test;

class logsinformanagerTest {

    @Test
    void logsinforTest(){
        logsinformanager lim=new logsinformanager(5);
        System.out.println(lim.Logsinforlist);
        for (int i=0;i<lim.Logsinforlist.get(3).size();i++){
            System.out.println(lim.Logsinforlist.get(0).get(i));
            System.out.println(lim.Logsinforlist.get(1).get(i));
            System.out.println(lim.Logsinforlist.get(2).get(i));
            System.out.println(lim.Logsinforlist.get(3).get(i));
        }
    }

}