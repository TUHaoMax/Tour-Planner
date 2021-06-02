package GUI.Controller;

import GUI.VIewModel.TableViewModel;
import TourModels.TourLogs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable, EventHandler<ActionEvent> {
    public static TableViewModel tableViewModel=new TableViewModel();

   @FXML
   private TableView<TourLogs> TableView;
   @FXML
   private Label LogsLabel;
    @FXML
    private Button logminus;
    @FXML
    private TableColumn<TourLogs,String> Date,Time,Distance,Weather,Rating;

    private static int TourID;
    private static String Tourname;

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==logminus){
            tableViewModel.deletelog(TourID);
            //TableView.setItems(tableViewModel.settourLogs(TourID));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date.setCellValueFactory(new PropertyValueFactory<>("LogDate"));
        Time.setCellValueFactory(new PropertyValueFactory<>("Logtime"));
        Distance.setCellValueFactory(new PropertyValueFactory<>("Distance"));
        Weather.setCellValueFactory(new PropertyValueFactory<>("weather"));
        Rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        TableView.setItems(tableViewModel.getTourLogs());
           /*TableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TourLogs>() {
            @Override
            public void changed(ObservableValue<? extends TourLogs> observableValue, TourLogs tourLogs, TourLogs t1) {
                if(t1!=null){
                    currentLogId=t1.getId();
                    logger.debug("Logs finded {}", t1.getId());
                }

            }
        });*/
    }
}
