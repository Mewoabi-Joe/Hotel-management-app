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
import tablePac.RecepWorkRate;
import utilitiesPac.Select;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeeDrawerContentController implements Initializable {
    @FXML
    private TableView<RecepWorkRate> tvRecepWorkRate;
    @FXML
    private TableColumn<RecepWorkRate, String> colFNameRWR;
    @FXML
    private TableColumn<RecepWorkRate, String> colLNameRWR;
    @FXML
    private TableColumn<RecepWorkRate, String> colEmailRWR;
    @FXML
    private TableColumn<RecepWorkRate, Integer> colNoClientsRWR;

    @FXML
    private JFXDatePicker lowerDP;
    @FXML
    private JFXDatePicker higherDP;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showRecepWorkRate(getRecepWorkRateList("select receptionists_firstName, receptionists_lastName,receptionists_email, count(receptionists_id) as count from receptionists join bookings using(receptionists_id) group by(receptionists_id) order by count desc"));

    }

    public ObservableList<RecepWorkRate> getRecepWorkRateList(String query) {
        ObservableList<RecepWorkRate> recepWorkRateList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            RecepWorkRate recepWorkRate;
            while (rs.next()) {
                recepWorkRate = new RecepWorkRate(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                recepWorkRateList.add(recepWorkRate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recepWorkRateList;
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

    public void showRecepWorkRate(ObservableList<RecepWorkRate> listRecepWorkRate) {
        ObservableList<RecepWorkRate> list = listRecepWorkRate;
        colFNameRWR.setCellValueFactory(new PropertyValueFactory<RecepWorkRate, String>("firstName"));
        colLNameRWR.setCellValueFactory(new PropertyValueFactory<RecepWorkRate, String>("lastName"));
        colEmailRWR.setCellValueFactory(new PropertyValueFactory<RecepWorkRate, String>("email"));
        colNoClientsRWR.setCellValueFactory(new PropertyValueFactory<RecepWorkRate, Integer>("numberOfClients"));
        tvRecepWorkRate.setItems(list);
    }

    @FXML
    void loadBtnPressed(ActionEvent event) {
        LocalDate lowerLD = lowerDP.getValue();
        LocalDate higherLD = higherDP.getValue();
        Date lowerSQLDate = Date.valueOf(lowerLD);
        Date higherSQLDate = Date.valueOf(higherLD);
        showRecepWorkRate(getRecepWorkRateList("select receptionists_firstName, receptionists_lastName,receptionists_email, count(receptionists_id) as count from receptionists join bookings using(receptionists_id) join customers using(customers_id) where customers_regisTime between '"+lowerSQLDate+"' and '"+higherSQLDate+"' group by(receptionists_id) order by count desc"));
    }

    @FXML
    void restoreClicked(ActionEvent event) {
        lowerDP.setValue(getDate("select customers_regisTime from customers limit 1").toLocalDate());
        higherDP.setValue(getDate("select checkout from bookings order by checkout desc limit 1").toLocalDate());
        showRecepWorkRate(getRecepWorkRateList("select receptionists_firstName, receptionists_lastName,receptionists_email, count(receptionists_id) as count from receptionists join bookings using(receptionists_id) group by(receptionists_id) order by count desc"));
    }

}
