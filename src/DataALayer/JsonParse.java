package DataALayer;

import APP.Config;
import TourModels.JsonMsg;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class JsonParse {
    public static JsonMsg getjson(String msg){
        Gson gson=new Gson();
        JsonMsg jsonmsg=gson.fromJson(msg,JsonMsg.class);
        return jsonmsg;
    }
    public static Config getConfig(String msg){
        Gson gson=new Gson();
        Config config=gson.fromJson(msg,Config.class);
        return config;
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

    public static String config(){
        String Msg="";
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("url","jdbc:postgresql://localhost:5432/TourPlanner");
        jsonObject.addProperty("user","postgres");
        jsonObject.addProperty("password","root");
        jsonObject.addProperty("MapPath","src/Resources/MapImage/");
        jsonObject.addProperty("MapAPiKey","TG2u1eZTfhs0xaKG1REZ8w0H2P3zS5on");
        jsonObject.addProperty("ViewPath","../Resources/Viewfxml/");
        jsonObject.addProperty("MapUrl","https://www.mapquestapi.com/staticmap/v5/map?");
        jsonObject.addProperty("MapSize","&size=400,300");

        Msg=Msg.concat(jsonObject.toString());
        return Msg;
    }

    public static String readConfig(){
        String msg="";
        File file=new File("src/Resources/Config.json");
            try {
                Scanner scan=new Scanner(file);
                while (scan.hasNextLine()){
                    msg=msg.concat(scan.nextLine()+"\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return msg;
    }


}
