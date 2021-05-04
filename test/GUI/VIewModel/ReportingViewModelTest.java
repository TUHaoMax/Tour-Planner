package GUI.VIewModel;

import org.junit.jupiter.api.Test;

class ReportingViewModelTest {

    @Test
    void PDfcreate() {
       ReportingViewModel rpm=new ReportingViewModel();
       rpm.PDfcreate("Tour-1");
    }

    @Test
    void Createmsg(){
        ReportingViewModel rpm=new ReportingViewModel();
        rpm.Creatmsg("Tour-1");
        System.out.println(rpm.getMsg());

    }
}