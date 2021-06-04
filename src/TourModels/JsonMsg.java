package TourModels;

import lombok.Getter;

@Getter
public class JsonMsg {

    private String TourName;
    private String Departure;
    private String Destination;
    private String Description;

    private String LogDate;
    private String Logtime;
    private String weather;
    private int Rating;
    private int Distance;



}
