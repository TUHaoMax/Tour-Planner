package TourModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tour {

    private String name;
    private String Departure;
    private String destination;
    private String Description;
    private int ID;

    public Tour(String name, String departure, String destination, String description) {
        this.name = name;
        Departure = departure;
        this.destination = destination;
        Description = description;
    }
}
