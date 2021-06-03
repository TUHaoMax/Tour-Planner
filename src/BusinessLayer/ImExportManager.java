package BusinessLayer;

import TourModels.JsonMsg;
import TourModels.Tour;
import TourModels.TourLogs;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.stage.FileChooser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImExportManager {
    private static final Logger logger= LoggerFactory.getLogger(ImExportManager.class);

    public static JsonMsg getjson(String msg){
        Gson gson=new Gson();
        JsonMsg jsonmsg=gson.fromJson(msg,JsonMsg.class);
        return jsonmsg;
    }

    public static List<JsonMsg> getjsonlist(String msg){
        Gson gson=new Gson();
        Type t = new TypeToken<List<JsonMsg>>() {}.getType();
        List<JsonMsg> jsonmsgs = gson.fromJson(msg, t);
        return jsonmsgs;
    }

    public static List<String> getnokeyjsonlist(String msg){
        Gson gson=new Gson();
        Type t = new TypeToken<List<String>>() {}.getType();
        List<String> messageList = gson.fromJson(msg, t);
        return messageList;
    }

    public static String BuildJson(Tour tour, ArrayList<TourLogs> logsArrayList){
            String Msg="[";
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("TourName",tour.getName());
            jsonObject.addProperty("Departure",tour.getDeparture());
            jsonObject.addProperty("Destination",tour.getDestination());
            jsonObject.addProperty("Description",tour.getDescription());

            for (int i=0;i<logsArrayList.size();i++){
                jsonObject.addProperty("LogDate", String.valueOf(logsArrayList.get(i).getLogDate()));
                jsonObject.addProperty("Logtime", String.valueOf(logsArrayList.get(i).getLogtime()));
                jsonObject.addProperty("weather",logsArrayList.get(i).getWeather());
                jsonObject.addProperty("Rating",logsArrayList.get(i).getRating());
                jsonObject.addProperty("Distance",logsArrayList.get(i).getDistance());
                Msg=Msg.concat(jsonObject.toString()+",\n");
            }
            Msg=replaceLast(Msg,",","]");
           // Msg=Msg.concat(jsonObject.toString());
            return Msg;
    }
    public static String replaceLast(String text, String strToReplace, String replaceWithThis) {
        return text.replaceFirst("(?s)" + strToReplace + "(?!.*?" + strToReplace + ")", replaceWithThis);
    }

    public static void Export(String Msg,String name){
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Export");
        fileChooser.setInitialDirectory(new File("C:/BIF/"));
        fileChooser.setInitialFileName(name);
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json file","*.json"));
        File file=fileChooser.showSaveDialog(null);
        saveExport(file,Msg);
        logger.debug("Export path {} ",file.getAbsolutePath());
    }

    private static void saveExport(File file, String Msg){
        try {
            PrintWriter printWriter=new PrintWriter(file);
            printWriter.write(Msg);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String Import(){
        String msg="";
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Export");
        fileChooser.setInitialDirectory(new File("C:/BIF/"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json file","*.json"));
        File file=fileChooser.showOpenDialog(null);
        if(file!=null){
            logger.debug("Import json file {} ",file.getAbsolutePath());
            Desktop desktop=Desktop.getDesktop();
            try {
                Scanner scan=new Scanner(file);
                while (scan.hasNextLine()){
                    msg=msg.concat(scan.nextLine()+"\n");
                }
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }

}
