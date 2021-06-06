package GUI.Controller;

import GUI.VIewModel.TableViewModel;
import TourModels.TourLogs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable, EventHandler<ActionEvent> {
    private static final Logger logger= LoggerFactory.getLogger(TableController.class);
    public static TableViewModel tableViewModel=new TableViewModel();

   @FXML
   private TableView<TourLogs> TableView;
   @FXML
   private Label LogsLabel;
    @FXML
    private Button logminus;
    @FXML
    private TableColumn<TourLogs,String> Date,Time,Distance,Weather,Rating,Transport;

    private static int TourID;
    private static int LogID;
    private static String Tourname;

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==logminus){
            tableViewModel.deletelog(LogID);
            tableViewModel.settourLogs(TourID);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date.setCellValueFactory(new PropertyValueFactory<>("LogDate"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Logtime"));
        Distance.setCellValueFactory(new PropertyValueFactory<>("Distance"));
        Weather.setCellValueFactory(new PropertyValueFactory<>("weather"));
        Rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        Transport.setCellValueFactory(new PropertyValueFactory<>("transport"));

        LogsLabel.textProperty().bind(tableViewModel.Loglabel);
        TableView.setItems(tableViewModel.getTourLogs());

        TableListener();
        TableMouseClick();

    }



   public void setTableinfor(String name,int Id){
       Tourname=name;
      TourID=Id;
   }

   private void TableListener(){
       TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TourLogs>() {
           @Override
           public void changed(ObservableValue<? extends TourLogs> observableValue, TourLogs tourLogs, TourLogs t1) {
               if(t1!=null){
                   LogID=t1.getId();
                   logger.debug("Logs finded {}",LogID);
               }
           }
       });
   }

    private void TableMouseClick(){
        TableView.setOnMouseClicked(mouseEvent -> {
            switch (mouseEvent.getClickCount()) {
                case 2:
                    LogDetailController.LogID=LogID;
                    LogDetailController.Tname=Tourname;
                    LogDetailController.TourID=TourID;
                    try {
                        WindowController.Windowlunch("LogDetail.fxml",300,300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        });
    }
}
