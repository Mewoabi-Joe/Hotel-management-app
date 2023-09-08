package controllerPac;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tablePac.ClientSpending;
import utilitiesPac.Select;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientDrawerContentController implements Initializable {

    @FXML
    private Label amountMadeLabel;
    @FXML
    private Label paymentMethodLabel;
    @FXML
    private TableView<ClientSpending> tvClientSpendings;
    @FXML
    private TableColumn<ClientSpending, String> colFNameCS;
    @FXML
    private TableColumn<ClientSpending, String> colLNameCS;
    @FXML
    private TableColumn<ClientSpending, String> colEmailCS;
    @FXML
    private TableColumn<ClientSpending, Double> colSpendingCS;

    @FXML
    private JFXDatePicker lowerDP;
    @FXML
    private JFXDatePicker higherDP;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showClientSpending(getClientSpendingList("select  firstName,  lastName,  email,  sum(paid) as amount  from customers join payments using(customers_id) group by email order by amount desc"));
        amountMadeLabel.setText(""+getAmountMade("select sum(paid) from payments join bookings using(customers_id)"));
        paymentMethodLabel.setText(getMostUsedPayMethod("select count(method) as count, method from payments join bookings using(customers_id) group by method order by count desc limit 1"));

    }

    public double getAmountMade(String query) {
        ResultSet rs;
        double amountMade =0;
        try {
            rs = Select.getData(query);
            while (rs.next()) {
                amountMade = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amountMade;
    }

    public String getMostUsedPayMethod(String query) {
        ResultSet rs;
        String mostUsedPayMethod = null ;
        try {
            rs = Select.getData(query);
            while (rs.next()) {
                mostUsedPayMethod = rs.getString(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mostUsedPayMethod;
    }

    public ObservableList<ClientSpending> getClientSpendingList(String query) {
        ObservableList<ClientSpending> clientSpendingList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            ClientSpending clientSpending;
            while (rs.next()) {
                clientSpending = new ClientSpending(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                clientSpendingList.add(clientSpending);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientSpendingList;
    }

    public void showClientSpending(ObservableList<ClientSpending> listClientSpendings) {
        ObservableList<ClientSpending> list = listClientSpendings;
        colFNameCS.setCellValueFactory(new PropertyValueFactory<ClientSpending, String>("firstName"));
        colLNameCS.setCellValueFactory(new PropertyValueFactory<ClientSpending, String>("lastName"));
        colEmailCS.setCellValueFactory(new PropertyValueFactory<ClientSpending, String>("email"));
        colSpendingCS.setCellValueFactory(new PropertyValueFactory<ClientSpending, Double>("amount"));
        tvClientSpendings.setItems(list);
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
        showClientSpending(getClientSpendingList("select  firstName,  lastName,  email,  sum(paid) as amount  from customers join payments using(customers_id) join bookings using(customers_id) where checkin between '"+lowerSQLDate+"' and '"+higherSQLDate+"' group by email order by amount desc"));
        amountMadeLabel.setText(""+getAmountMade("select sum(paid) from payments join bookings using(customers_id) where checkin between '"+lowerSQLDate+"' and '"+higherSQLDate+"'"));
        paymentMethodLabel.setText(getMostUsedPayMethod("select count(method) as count, method from payments join bookings using(customers_id) where checkin between '"+lowerSQLDate+"' and '"+higherSQLDate+"' group by method order by count desc limit 1"));

    }

    @FXML
    void restoreClicked(ActionEvent event) {
        lowerDP.setValue(getDate("select customers_regisTime from customers limit 1").toLocalDate());
        higherDP.setValue(getDate("select checkout from bookings order by checkout desc limit 1").toLocalDate());
        showClientSpending(getClientSpendingList("select  firstName,  lastName,  email,  sum(paid) as amount  from customers join payments using(customers_id) group by email order by amount desc"));
        amountMadeLabel.setText(""+getAmountMade("select sum(paid) from payments join bookings using(customers_id)"));
        paymentMethodLabel.setText(getMostUsedPayMethod("select count(method) as count, method from payments join bookings using(customers_id) group by method order by count desc limit 1"));

    }

}
