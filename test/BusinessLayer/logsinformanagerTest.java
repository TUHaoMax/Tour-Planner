package BusinessLayer;

import org.junit.jupiter.api.Test;

class logsinformanagerTest {

    @Test
    void logsinforTest(){
        logsinformanager lim=new logsinformanager(3);
        System.out.println(lim.Logsinforlist);
        for (int i=0;i<lim.Logsinforlist.get(3).size();i++){
            System.out.println(lim.Logsinforlist.get(0).get(i));
            System.out.println(lim.Logsinforlist.get(1).get(i));
            System.out.println(lim.Logsinforlist.get(2).get(i));
            System.out.println(lim.Logsinforlist.get(3).get(i));
        }
    }

    @Test
    void LogslistTest(){
        logsinformanager logsinformanager=new logsinformanager(3);
        logsinformanager.setLogslist();
        for(int i=0;i<logsinformanager.Logslist.size();i++){
            System.out.println(logsinformanager.Logslist.get(i).getId());
            System.out.println(logsinformanager.Logslist.get(i).getTourid());
            System.out.println(logsinformanager.Logslist.get(i).getWeather());
            System.out.println(logsinformanager.Logslist.get(i).getLogDate());
            System.out.println(logsinformanager.Logslist.get(i).getLogtime());
            System.out.println(logsinformanager.Logslist.get(i).getDistance());
            System.out.println(logsinformanager.Logslist.get(i).getRating());
        }

    }
}