package GUI.VIewModel;

import BusinessLayer.ImExportManager;
import BusinessLayer.logsinformanager;
import BusinessLayer.tourinformanager;
import DataALayer.JsonParse;
import GUI.Controller.ErrorController;
import GUI.Controller.MainController;
import GUI.Controller.WindowController;
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
        if(name!=null && name!="") {
            tourinformanager = new tourinformanager();
            tourinformanager.settour(name);
            logsinformanager = new logsinformanager(tourinformanager.TourId);
            logsinformanager.setLogslist();
            Msg = ImExportManager.BuildJson(tourinformanager.tour, logsinformanager.Logslist);
            ImExportManager.Export(Msg, name);
        }else {
            logger.debug("error Please select a tour");
            ErrorController.msg="Please select a tour";
            try {
                WindowController.Windowlunch("error.fxml",400,300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void Import(){
       String Msg;
       Msg=ImExportManager.Import();
        List<JsonMsg> jsonMsgArrayList= JsonParse.getjsonlist(Msg);
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
