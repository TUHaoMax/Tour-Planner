package Data;

public interface SQL {
    String Tours_selectall="select * from Tours";


    //Tours

    //Logs
    String Logs_selectToursid="select * from Logs where ToursId= ?";

}
