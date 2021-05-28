package TourModels;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Setter
@Getter

public class TourLogs {
    private Date LogDate;
    private Time Logtime;
    private int tourid;
    private int Id;
    private String weather;
    private int Rating;
    private int Distance;

    public TourLogs(Object Id, Object logDate, Object logtime, Object tourid, Object Rating, Object weather, Object Distance) {
        this.Id=(int)Id;
        this.LogDate = (Date) logDate;
        this.Logtime = (Time) logtime;
        this.tourid=(int)tourid;
        this.Rating=(int)Rating;
        this.weather=(String) weather;
        this.Distance=(int)Distance;
    }


}
