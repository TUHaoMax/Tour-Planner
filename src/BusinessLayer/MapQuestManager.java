package BusinessLayer;

import APP.APPLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MapQuestManager {
    private static final Logger logger= LoggerFactory.getLogger(MapQuestManager.class);
    public static HttpURLConnection connection;
    private static String url=APPLauncher.config.MapUrl;
    private static String size=APPLauncher.config.MapSize;
    private static String key=APPLauncher.config.MapAPiKey;
    private static String path=APPLauncher.config.MapPath;
    private static String start="start=";
    private static String end="&end=";

    public static String TourName;
    public static String startName;
    public static String endName;

    public static void setinfor(String Tname,String Sname,String eName){
        TourName=Tname;
        startName=Sname;
        endName=eName;
    }

    public static void sendHttp(){

            start = start.concat(startName);
            end = end.concat(endName);

            logger.debug("{}", (url + start + end + size + key));
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + start + end + size + key))
                    .GET()
                    .header("accept", "application/json")
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                    .thenApplyAsync(HttpResponse::body)
                    .thenApply(MapQuestManager::getMap)
                    .isDone();


        start="start=";
        end="&end=";
    }


    public static String getMap(InputStream inputStream) {

               try {
                   FileOutputStream out = new FileOutputStream(path+TourName+".jpg");
                   int c = 0;
                   byte[] b = new byte[1024];

                   try {
                       while ((c = inputStream.read(b)) != -1) {
                           out.write(b, 0, c);
                       }
                       out.flush();
                       out.close();
                       inputStream.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }
        logger.debug("{} Map got",TourName);
        return "done";
    }
}
