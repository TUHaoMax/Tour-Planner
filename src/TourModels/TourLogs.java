package TourModels;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Setter
@Getter
public class TourLogs {
    private Date LogDate;
    private Time Logtime;


}
