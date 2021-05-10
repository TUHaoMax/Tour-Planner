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


    public TourLogs(Object logDate, Object logtime) {
        LogDate = (Date) logDate;
        Logtime = (Time) logtime;
    }


}
