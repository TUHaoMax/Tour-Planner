package BusinessLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tourinformanagerTest {

    @Test
    void gettourinfor() {
        tourinformanager tim=new tourinformanager();

        tim.settour("Tour-1");
        System.out.println(tim.Departure);
        System.out.println(tim.index);
        System.out.println(tim.destination);
        System.out.println(tim.name);
        System.out.println(tim.tourinforlist);
    }
}