package GUI.VIewModel;

import org.junit.jupiter.api.Test;

class ReportingViewModelTest {

    @Test
    void PDfcreate() {
       ReportingViewModel rpm=new ReportingViewModel();
       rpm.PDfcreate("Tour-1");
    }



}