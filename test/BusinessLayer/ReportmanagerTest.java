package BusinessLayer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportmanagerTest {

    @Test
    void PDfcreate() {
    }

    @Test
    void creatmsg() {
        Reportmanager rpm=new Reportmanager();
        rpm.Creatmsg("Tour-1");
        System.out.println(rpm.getMsg());
    }

    @Test
    void creatparagraph() {
    }

    @Test
    void getDatetime() {
        Reportmanager rpm=new Reportmanager();
        rpm.getDatetime();
        System.out.println(rpm.getDate());
    }
}