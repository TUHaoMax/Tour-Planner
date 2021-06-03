package BusinessLayer;

import org.junit.jupiter.api.Test;

class tourinformanagerTest {

    @Test
    void gettourinfor() {
        tourinformanager tim=new tourinformanager();

        tim.settour("Tour 1");

        System.out.println(tim.Departure);
        System.out.println(tim.index);
        System.out.println(tim.destination);
        System.out.println(tim.Name);
        System.out.println(tim.TourId);
        System.out.println(tim.tourinforlist);
    }

    @Test
    void setTourclass(){
        tourinformanager tim=new tourinformanager();
        tim.settour("Tour 3");
        System.out.println(tim.tour.getName());
        System.out.println(tim.tour.getDestination());
        System.out.println(tim.tour.getDeparture());
        System.out.println(tim.tour.getDescription());
    }
}