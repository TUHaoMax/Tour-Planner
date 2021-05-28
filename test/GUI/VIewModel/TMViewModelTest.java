package GUI.VIewModel;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class TMViewModelTest {

    @Test
    void insertLog() {
        TMViewModel tmViewModel=new TMViewModel();
        String date="2021-05-02";
        String Duration="05:05:05";
        String weather="sun";
        String Dt="15";
        tmViewModel.insertLog(Date.valueOf(date), Time.valueOf(Duration),80,10,weather, Integer.parseInt(Dt));
    }
}