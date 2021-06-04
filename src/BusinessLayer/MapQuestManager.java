package BusinessLayer;

import APP.APPLauncher;

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

    public static HttpURLConnection connection;
    private static String url=APPLauncher.config.MapUrl;
    private static String size=APPLauncher.config.MapSize;
    private static String key=APPLauncher.config.MapAPiKey;
    private static String path=APPLauncher.config.MapPath;
    private static String start="start=";
    private static String end="&end=";

    public static void sendHttp(){
        start=start.concat("wien");
        end=end.concat("Innsbruck");
        System.out.println(url+start+end+size+key);
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(url+start+end+size+key))
                .GET()
                .header("accept","application/json")
                .build();
        client.sendAsync(request,HttpResponse.BodyHandlers.ofInputStream())
                        .thenApplyAsync(HttpResponse::body)
                        .thenApply(MapQuestManager::getMap)
                         .join();

    }


    public static String getMap(InputStream inputStream) {

               try {
                   FileOutputStream out = new FileOutputStream(path+"test_1.jpg");
                   int c = 0;
                   byte[] b = new byte[1024];

                   try {
                       while ((c = inputStream.read(b)) != -1) {
                           out.write(b, 0, c);
                       }
                       out.flush();
                       inputStream.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }

               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               }

        return "done";
    }
}
