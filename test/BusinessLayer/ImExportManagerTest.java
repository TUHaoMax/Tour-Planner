package BusinessLayer;

import TourModels.JsonMsg;
import org.junit.jupiter.api.Test;

import java.util.List;

class ImExportManagerTest {

    @Test
    void buildJson() {
        tourinformanager tourinformanager=new tourinformanager();
        tourinformanager.settour("Tour 3");
        logsinformanager logsinformanager=new logsinformanager(tourinformanager.TourId);
        logsinformanager.setLogslist();
        System.out.println(ImExportManager.BuildJson(tourinformanager.tour,logsinformanager.Logslist));
    }

    @Test
    void getjsonlist(){
        String Msg;
        tourinformanager tourinformanager=new tourinformanager();
        tourinformanager.settour("Tour 3");
        logsinformanager logsinformanager=new logsinformanager(tourinformanager.TourId);
        logsinformanager.setLogslist();
        Msg=ImExportManager.BuildJson(tourinformanager.tour,logsinformanager.Logslist);

        System.out.println(Msg);
       // Msg="[{\"Id\":\"67f9048f-99b8-4ae4-b866-d8008d00c53d\", \"Name\":\"WaterGoblin\", \"Damage\": 10.0}, {\"Id\":\"aa9999a0-734c-49c6-8f4a-651864b14e62\", \"Name\":\"RegularSpell\", \"Damage\": 50.0}, {\"Id\":\"d6e9c720-9b5a-40c7-a6b2-bc34752e3463\", \"Name\":\"Knight\", \"Damage\": 20.0}, {\"Id\":\"02a9c76e-b17d-427f-9240-2dd49b0d3bfd\", \"Name\":\"RegularSpell\", \"Damage\": 45.0}, {\"Id\":\"2508bf5c-20d7-43b4-8c77-bc677decadef\", \"Name\":\"FireElf\", \"Damage\": 25.0}]";

       // System.out.println(Msg);
        List<JsonMsg> jsonMsgArrayList=ImExportManager.getjsonlist(Msg);

         /*for(int n=0;n<jsonMsgArrayList.size();n++){
             System.out.println("\nID: "+jsonMsgArrayList.get(n).getId()+" name: "+jsonMsgArrayList.get(n).getName()
                                   +" Damage: "+jsonMsgArrayList.get(n).getDamage()+"\n");
                       }*/

        System.out.println(jsonMsgArrayList.get(0).getTourName());
        System.out.println(jsonMsgArrayList.get(0).getDeparture());
        System.out.println(jsonMsgArrayList.get(0).getDestination());
        System.out.println(jsonMsgArrayList.get(0).getDescription()+"\n");


        for (int i=0;i<jsonMsgArrayList.size();i++){
            System.out.println(jsonMsgArrayList.get(i).getLogDate());
            System.out.println(jsonMsgArrayList.get(i).getLogtime());
            System.out.println(jsonMsgArrayList.get(i).getRating());
            System.out.println(jsonMsgArrayList.get(i).getWeather());
            System.out.println(jsonMsgArrayList.get(i).getDistance());
        }
    }

}