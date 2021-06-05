package GUI.VIewModel;

import org.junit.jupiter.api.Test;

class ReportingViewModelTest {

    @Test
    void PDfcreate() {
          ReportingViewModel reportingViewModel=new ReportingViewModel();
          reportingViewModel.getDatetime();
        System.out.println(reportingViewModel.getDate());
    }



}