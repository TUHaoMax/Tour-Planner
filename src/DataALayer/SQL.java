package DataALayer;

public interface SQL {
    String Tours_selectall="SELECT * FROM toursinfor order by id";

    String Tours_insert="INSERT INTO toursinfor(name) VALUES (?)";

    String Tours_Delete="DELETE FROM toursinfor WHERE name= ?";
    //Tours

    //Logs
    String Logs_selectToursid="select * from Logs where ToursId= ?";

    String Logs_selectall="SELECT * FROM logs order by id";
}
