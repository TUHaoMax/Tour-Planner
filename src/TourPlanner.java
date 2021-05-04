import APP.APPLauncher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TourPlanner {
    private static final Logger logger= LoggerFactory.getLogger(TourPlanner.class);


    public static void main(String[] args) throws Exception{
        APPLauncher.fxmlname= "Main.fxml";
        APPLauncher.main(args);
        logger.debug("TourPlanner shut down");
    }


}
