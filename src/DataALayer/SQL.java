package DataALayer;

public interface SQL {
    String Tours_selectall="SELECT * FROM toursinfor order by name";

    String Tours_insert="INSERT INTO toursinfor(name) VALUES (?)";

    String Tours_Delete="DELETE FROM toursinfor WHERE name= ?";

    String Tours_update=" UPDATE toursinfor SET  departure=?, destination=? WHERE id=? ";

    String Tours_DP=" UPDATE toursinfor SET  departure=? WHERE id=? ";

    String Tours_DT=" UPDATE toursinfor SET  destination=? WHERE id=? ";

    String Tours_DS="UPDATE toursinfor SET  description=? WHERE id=?";
    //Tours

    //Logs
    String Logs_selectToursid="select * from Logs where tourid= ? order by id";

    String Logs_selectall="SELECT * FROM logs order by id";

    String Logs_insert="INSERT INTO logs(date, duration, tourid, rating, weather, distance)VALUES (?, ?, ?, ?, ?, ?)";

    String Logs_Delete="DELETE FROM logs WHERE id=?";

    String Logs_update="UPDATE logs SET id=?, date=?, duration=?, tourid=?, rating=?, weather=?, distance=? WHERE id=?";

    String Logs_date_update="UPDATE logs SET date=? WHERE id=?";

    String Logs_duration_update="UPDATE logs SET duration=? WHERE id=?";

    String Logs_rating_update="UPDATE logs SET rating=? WHERE id=?";

    String Logs_weather_update="UPDATE logs SET weather=? WHERE id=?";

    String Logs_distance_update="UPDATE logs SET distance=? WHERE id=?";
}
