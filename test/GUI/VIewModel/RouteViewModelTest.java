package GUI.VIewModel;

import org.junit.jupiter.api.Test;

class RouteViewModelTest {


    @Test
    void deleteImage() {
        RouteViewModel routeViewModel=new RouteViewModel();
        routeViewModel.deleteImage("test");
    }
}