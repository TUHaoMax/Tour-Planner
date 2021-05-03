package GUI.VIewModel;

import DataALayer.DataRst;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListViewModelTest {
    @Test
    void listviewtest() {
       ListViewModel listView=new ListViewModel();
        System.out.println(listView.getNamelist());
    }

}