package GUI.VIewModel;

import BusinessLayer.ImExportManager;
import BusinessLayer.logsinformanager;
import BusinessLayer.tourinformanager;
import GUI.Controller.MainController;
import TourModels.JsonMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.List;

public class ImExportViewModel {
    private static final Logger logger= LoggerFactory.getLogger(ImExportViewModel.class);
    tourinformanager tourinformanager;
    logsinformanager logsinformanager;

    TMViewModel tmViewModel=new TMViewModel();

    public void Export(String name){
        String Msg;
        tourinformanager=new tourinformanager();
        tourinformanager.settour(name);
        logsinformanager=new logsinformanager(tourinformanager.TourId);
        logsinformanager.setLogslist();
        Msg= ImExportManager.BuildJson(tourinformanager.tour,logsinformanager.Logslist);
        ImExportManager.Export(Msg,name);
        logger.debug("{} Export",name);
    }

    public void Import(){
       String Msg;
       Msg=ImExportManager.Import();
        List<JsonMsg> jsonMsgArrayList=ImExportManager.getjsonlist(Msg);
        if(jsonMsgArrayList!=null) {
            MainController.listViewModel.addTour(jsonMsgArrayList.get(0).getTourName());
            tourinformanager = new tourinformanager();
            tourinformanager.settour(jsonMsgArrayList.get(0).getTourName());
            tmViewModel.UPdateT(jsonMsgArrayList.get(0).getDeparture(), jsonMsgArrayList.get(0).getDestination(), tourinformanager.TourId);
            tmViewModel.UPdataTDS(jsonMsgArrayList.get(0).getDescription(), tourinformanager.TourId);

            for (int i = 0; i < jsonMsgArrayList.size(); i++) {
                tmViewModel.insertLog(java.sql.Date.valueOf(jsonMsgArrayList.get(i).getLogDate()), Time.valueOf(jsonMsgArrayList.get(i).getLogtime()), tourinformanager.TourId,
                        jsonMsgArrayList.get(i).getRating(), jsonMsgArrayList.get(i).getWeather(), jsonMsgArrayList.get(i).getDistance());
            }
        }

    }

}
