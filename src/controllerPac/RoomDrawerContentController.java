package controllerPac;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tablePac.RoomBookFrequency;
import utilitiesPac.Select;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RoomDrawerContentController implements Initializable {
    @FXML
    private TableView<RoomBookFrequency> tvRoomBookFrequency;
    @FXML
    private TableColumn<RoomBookFrequency, Integer> colNumberRBF;
    @FXML
    private TableColumn<RoomBookFrequency, Integer> colFrequencyRBF;

    @FXML
    private JFXDatePicker lowerDP;
    @FXML
    private JFXDatePicker higherDP;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showRoomBookFrequency(getRoomBookFrequencyList("select rooms_number, count(rooms_id) as NumberOfVisits from rooms join bookings using(rooms_id) group by rooms_id order by NumberOfVisits desc"));

    }

    public ObservableList<RoomBookFrequency> getRoomBookFrequencyList(String query) {
        ObservableList<RoomBookFrequency> roomBookFrequencyList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            RoomBookFrequency roomBookFrequency;
            while (rs.next()) {
                roomBookFrequency = new RoomBookFrequency(rs.getInt(1), rs.getInt(2));
                roomBookFrequencyList.add(roomBookFrequency);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomBookFrequencyList;
    }

    public void showRoomBookFrequency(ObservableList<RoomBookFrequency> listRoomBookFrequency) {
        ObservableList<RoomBookFrequency> list = listRoomBookFrequency;
        colNumberRBF.setCellValueFactory(new PropertyValueFactory<RoomBookFrequency, Integer>("roomNumber"));
        colFrequencyRBF.setCellValueFactory(new PropertyValueFactory<RoomBookFrequency, Integer>("bookingFrequency"));
        tvRoomBookFrequency.setItems(list);
    }

    public Date getDate(String query) {
        ResultSet rs;
        Date date = null ;
        try {
            rs = Select.getData(query);
            while (rs.next()) {
                date = rs.getDate(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


    @FXML
    void loadBtnPressed(ActionEvent event) {
        LocalDate lowerLD = lowerDP.getValue();
        LocalDate higherLD = higherDP.getValue();
        Date lowerSQLDate = Date.valueOf(lowerLD);
        Date higherSQLDate = Date.valueOf(higherLD);
         showRoomBookFrequency(getRoomBookFrequencyList("select rooms_number, count(rooms_id) as NumberOfVisits from rooms join bookings using(rooms_id) where checkin between '"+lowerSQLDate+"' and '"+higherSQLDate+"' group by rooms_id order by NumberOfVisits desc"));
     }

    @FXML
    void restoreClicked(ActionEvent event) {
        lowerDP.setValue(getDate("select customers_regisTime from customers limit 1").toLocalDate());
        higherDP.setValue(getDate("select checkout from bookings order by checkout desc limit 1").toLocalDate());
         showRoomBookFrequency(getRoomBookFrequencyList("select rooms_number, count(rooms_id) as NumberOfVisits from rooms join bookings using(rooms_id) group by rooms_id order by NumberOfVisits desc"));
    }
}
