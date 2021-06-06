package GUI.VIewModel;

import BusinessLayer.tourinformanager;
import GUI.Controller.DescriptionController;
import GUI.Controller.MainController;

public class DetailViewModel {
    public BusinessLayer.tourinformanager tourinformanager=new tourinformanager();
    public TMViewModel tmViewModel=new TMViewModel();
   // public ListViewModel listViewModel=new ListViewModel();


    public void setDPDT(String name){
        tourinformanager.settour(name);
        System.out.println(tourinformanager.getName());
        System.out.println(tourinformanager.getTourId());

    }

    public void UpdateTourDP(String Departure){
        tmViewModel.UPdateTDP(Departure,tourinformanager.TourId);
    }
    public void UpdateTourDT(String Destination){
        tmViewModel.UPdateTDT(Destination,tourinformanager.TourId);
    }

    public void UpdateDS(String Description){
        tmViewModel.UPdataTDS(Description,tourinformanager.TourId);
    }
    public void UpdateTourName(String name){
            MainController.listViewModel.UpTourName(name,tourinformanager.TourId);
    }

    public void resetDescription(String name){
        tourinformanager.settour(name);
        tourinformanager.BuildTourDescription();
        DescriptionController.descriptionViewModel.Description.set(tourinformanager.FinalDescription);
    }

}
