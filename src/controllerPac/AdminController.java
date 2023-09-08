package controllerPac;

 import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
 import javafx.scene.Node;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.StackPane;
 import javafx.scene.layout.VBox;
 import javafx.stage.Stage;
 import tablePac.*;
import utilitiesPac.InsertUpdateDelete;
import utilitiesPac.JavaFXDialogs;
import utilitiesPac.Select;

 import javax.swing.*;
 import java.io.IOException;
 import java.net.URL;
 import java.sql.Date;
import java.sql.ResultSet;
 import java.util.Optional;
import java.util.ResourceBundle;


public class AdminController implements Initializable {
    @FXML
    private TableView<Room> tvRooms;
    @FXML
    private TableColumn<Room, Integer> colRoomId;
    @FXML
    private TableColumn<Room, String> colRoomType;
    @FXML
    private TableColumn<Room, String> colBedType;
    @FXML
    private TableColumn<Room, Double> colPricePerNight;
    @FXML
    private TableColumn<Room, Integer> colMaxPersons;
    @FXML
    private TableColumn<Room, String> colRoomStatus;
    @FXML
    private TableColumn<Room, Integer> colRoomNumber;
    @FXML
    private JFXTextField tfNumber;
    @FXML
    private JFXTextField tfRoomType;
    @FXML
    private JFXTextField tfBedType;
    @FXML
    private JFXTextField tfPricePerNight;
    @FXML
    private JFXTextField tfMaxNoPersons;
    @FXML
    private JFXTextField tfStatus;
    int id;
    @FXML
    private JFXTextField searchTF;

    @FXML
    private TableView<Employee> tvEmployees;
    @FXML
    private TableColumn<Employee, Integer> colEmpId;
    @FXML
    private TableColumn<Employee, String> colEmpFirstName;
    @FXML
    private TableColumn<Employee, String> colEmpLastName;
    @FXML
    private TableColumn<Employee, String> colEmpEmail;
    @FXML
    private TableColumn<Employee, String> colEmpSex;
    @FXML
    private TableColumn<Employee, Date> colEmpDOB;
    @FXML
    private TableColumn<Employee, String> colEmpAddress;
    int idEmp;
    String nameOfEmp;
    int roomNumber;
    @FXML
    private TableView<Client> tvClients;
    @FXML
    private TableColumn<Client, Integer> ClIDCol;
    @FXML
    private TableColumn<Client, String> ClFirstNameCol;
    @FXML
    private TableColumn<Client, String> ClEmailCol;
    @FXML
    private TableColumn<Client, String> ClCountryCol;
    @FXML
    private TableColumn<Client, String> ClStatusCol;
    @FXML
    private TableColumn<Client, String> ClMethodCol;
    @FXML
    private TableColumn<Client, Double> ClPaidCol;
    @FXML
    private TableColumn<Client, Date> ClCheckInCol;
    @FXML
    private TableColumn<Client, Date> ClCheckOutCol;
    @FXML
    private TableColumn<Client, Integer> ClRoomNumCol;
    @FXML
    private JFXTextField searchTFCl;
    @FXML
    private JFXTextField searchTFEmp;

    @FXML
    private JFXHamburger roomsHamburger;
     @FXML
    private JFXDrawer roomsDrawer;
    @FXML
    private JFXHamburger clientsHamburger;
    @FXML
    private JFXDrawer clientsDrawer;
    @FXML
    private JFXHamburger employeesHamburger;
    @FXML
    private JFXDrawer employeesDrawer;

    @FXML
    private TableView<Planning> tvPlannings;

    @FXML
    private TableColumn<Planning, Integer> pIdCol;

    @FXML
    private TableColumn<Planning, String> pRecepNameCol;

    @FXML
    private TableColumn<Planning, Integer> pRecepIdCol;

    @FXML
    private TableColumn<Planning, String> pWorkMonthcol;

    @FXML
    private TableColumn<Planning, Integer> pStartDayCol;

    @FXML
    private TableColumn<Planning, Integer> pEndDayCol;

    @FXML
    private TableColumn<Planning, Integer> pStartHourCol;

    @FXML
    private TableColumn<Planning, Integer> pEndHourCol;

    @FXML
    private JFXTextField searchPlanningTF;

    @FXML
    private JFXTextField tfPRecepId;

    @FXML
    private JFXTextField tfPWorkMonth;

    @FXML
    private JFXTextField tfPStartDay;

    @FXML
    private JFXTextField tfPEndDay;

    @FXML
    private JFXTextField tfPStartHour;

    @FXML
    private JFXTextField tfPEndHour;

    private int planId;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showRooms(getRoomList());
        showEmployees(getEmployeeList());
        showClients(getClientList());
        showPlannings(getPlanningList());
        hamDraw("../fxmlPac/roomDrawerContentFXML.fxml",roomsDrawer,roomsHamburger);
        hamDraw("../fxmlPac/clientDrawerContentFXML.fxml",clientsDrawer,clientsHamburger);
        hamDraw("../fxmlPac/employeeDrawerContentFXML.fxml",employeesDrawer,employeesHamburger);

        /*try {
            VBox vBox = FXMLLoader.load(getClass().getResource("../fxmlPac/roomDrawerContentFXML.fxml"));
            roomsDrawer.setSidePane(vBox);
            HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(roomsHamburger);
            burger.setRate(-1);
            roomsDrawer.setDisable(true);
             roomsHamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burger.setRate(burger.getRate() * -1);
                burger.play();

                if (roomsDrawer.isOpened()) {
                    roomsDrawer.close();
                    roomsDrawer.setDisable(true);
                } else {
                    roomsDrawer.open();
                     roomsDrawer.setDisable(false);
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }*/
    }

    public void hamDraw(String fxmlPath, JFXDrawer drawer, JFXHamburger hamburger){
        try{
            VBox vBox = FXMLLoader.load(getClass().getResource(fxmlPath));
            drawer.setSidePane(vBox);
            HamburgerBackArrowBasicTransition burger = new HamburgerBackArrowBasicTransition(hamburger);
            burger.setRate(-1);
            drawer.setDisable(true);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burger.setRate(burger.getRate() * -1);
                burger.play();

                if (drawer.isOpened()) {
                    drawer.close();
                    drawer.setDisable(true);
                } else {
                    drawer.open();
                    drawer.setDisable(false);
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ObservableList<Room> getRoomList() {
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        String query = "SELECT * FROM rooms";
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Room room;
            while (rs.next()) {
                room = new Room(rs.getInt("rooms_id"), rs.getInt("rooms_number"), rs.getString("rooms_type"), rs.getString("rooms_bedType"), rs.getDouble("rooms_pricePerNight"), rs.getInt("rooms_maxPersons"), rs.getString("rooms_status"));
                roomList.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomList;
    }

    public ObservableList<Planning> getPlanningList() {
        ObservableList<Planning> planningList = FXCollections.observableArrayList();
        String query = "SELECT plannings_id, receptionists_firstName, receptionists_id, month, start_day, end_day, start_hour, end_hour FROM plannings join receptionists using(receptionists_id)";
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Planning planning;
            while (rs.next()) {
                planning = new Planning(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
                planningList.add(planning);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planningList;
    }


    public ObservableList<Client> getClientList() {
        ObservableList<Client> clientList = FXCollections.observableArrayList();
        String query = "Select customers_id, firstname , email, country, status, method,paid,checkin,checkout,rooms_number from customers left join payments using(customers_id) left join bookings using(customers_id) left join rooms using(rooms_id)";
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Client client;
            while (rs.next()) {
                client = new Client(rs.getInt("customers_id"), rs.getString("firstname"), rs.getString("email"), rs.getString("country"), rs.getString("status"), rs.getString("method"), rs.getDouble("paid"), rs.getDate("checkin"), rs.getDate("checkout"), rs.getInt("rooms_number"));
                clientList.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientList;
    }

    public ObservableList<Employee> getEmployeeList() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        String query = "SELECT receptionists_id,receptionists_firstName,receptionists_lastName,receptionists_email,receptionists_sex,receptionists_dateOfBirth,receptionists_address FROM receptionists";
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Employee employee;
            while (rs.next()) {
                employee = new Employee(rs.getInt("receptionists_id"), rs.getString("receptionists_firstName"), rs.getString("receptionists_lastName"), rs.getString("receptionists_email"), rs.getString("receptionists_sex"), rs.getDate("receptionists_dateOfBirth"), rs.getString("receptionists_address"));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public void showRooms(ObservableList<Room> listRooms) {
        ObservableList<Room> list = listRooms;
        colRoomId.setCellValueFactory(new PropertyValueFactory<Room, Integer>("id"));
        colRoomNumber.setCellValueFactory(new PropertyValueFactory<Room, Integer>("number"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<Room, String>("roomType"));
        colBedType.setCellValueFactory(new PropertyValueFactory<Room, String>("bedType"));
        colPricePerNight.setCellValueFactory(new PropertyValueFactory<Room, Double>("pricePerNight"));
        colMaxPersons.setCellValueFactory(new PropertyValueFactory<Room, Integer>("noMaxPersons"));
        colRoomStatus.setCellValueFactory(new PropertyValueFactory<Room, String>("status"));
        tvRooms.setItems(list);
    }

    public void showPlannings(ObservableList<Planning> listPlannings) {
        ObservableList<Planning> list = listPlannings;
        pIdCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("planningId"));
        pRecepNameCol.setCellValueFactory(new PropertyValueFactory<Planning, String>("recepFName"));
        pRecepIdCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("recepId"));
        pWorkMonthcol.setCellValueFactory(new PropertyValueFactory<Planning, String>("workMonth"));
        pStartDayCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("startDay"));
        pEndDayCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("endDay"));
        pStartHourCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("startHour"));
        pEndHourCol.setCellValueFactory(new PropertyValueFactory<Planning, Integer>("endHour"));
        tvPlannings.setItems(list);
    }

    public void showEmployees(ObservableList<Employee> listEmployees) {
        ObservableList<Employee> list = listEmployees;
        colEmpId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("idEmp"));
        colEmpFirstName.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstNameEmp"));
        colEmpLastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastNameEmp"));
        colEmpEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("emailEmp"));
        colEmpSex.setCellValueFactory(new PropertyValueFactory<Employee, String>("sexEmp"));
        colEmpDOB.setCellValueFactory(new PropertyValueFactory<Employee, Date>("dobEmp"));
        colEmpAddress.setCellValueFactory(new PropertyValueFactory<Employee, String>("addressEmp"));
        tvEmployees.setItems(list);
    }

    public void showClients(ObservableList<Client> listClient) {
        ObservableList<Client> list = listClient;
        ClIDCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clId"));
        ClFirstNameCol.setCellValueFactory(new PropertyValueFactory<Client, String>("clFName"));
        ClEmailCol.setCellValueFactory(new PropertyValueFactory<Client, String>("clEmail"));
        ClCountryCol.setCellValueFactory(new PropertyValueFactory<Client, String>("clCountry"));
        ClStatusCol.setCellValueFactory(new PropertyValueFactory<Client, String>("clStatus"));
        ClMethodCol.setCellValueFactory(new PropertyValueFactory<Client, String>("clPayMethod"));
        ClPaidCol.setCellValueFactory(new PropertyValueFactory<Client, Double>("clAmtPaid"));
        ClCheckInCol.setCellValueFactory(new PropertyValueFactory<Client, Date>("clCheckIn"));
        ClCheckOutCol.setCellValueFactory(new PropertyValueFactory<Client, Date>("clCheckOut"));
        ClRoomNumCol.setCellValueFactory(new PropertyValueFactory<Client, Integer>("clRoomNum"));
        tvClients.setItems(list);
    }

    @FXML
    private void insertRecord() {
        int intRoomNo = 0;
        int intMaxNoPersons = 0;
        double doublePrice = 0;
        try {
            intRoomNo = Integer.parseInt(tfNumber.getText());
            intMaxNoPersons = Integer.parseInt(tfMaxNoPersons.getText());
            doublePrice = Double.parseDouble(tfPricePerNight.getText());
            String query = "INSERT INTO rooms(rooms_number,rooms_type,rooms_bedType,rooms_pricePerNight,rooms_maxPersons,rooms_status) VALUES (" + intRoomNo + ",'" + tfRoomType.getText() + "','" + tfBedType.getText() + "'," + doublePrice + "," + intMaxNoPersons + ",'" + tfStatus.getText() + "')";
            InsertUpdateDelete.runQuery(query, "Room added successfully");
            showRooms(getRoomList());
        } catch (NumberFormatException ex) {
            JavaFXDialogs.exceptionDialog(ex, "Field requires a number");
        }
    }

    @FXML
    private void insertPlanningRecord() {
        int  pRecepId = 0;
        int pStartDay = 0;
        int pEndDay = 0;
        int pStartHour = 0;
        int pEndHour = 0;
        try {
            pRecepId = Integer.parseInt(tfPRecepId.getText());
            pStartDay = Integer.parseInt(tfPStartDay.getText());
            pEndDay = Integer.parseInt(tfPEndDay.getText());
            pStartHour = Integer.parseInt(tfPStartHour.getText());
            pEndHour = Integer.parseInt(tfPEndHour.getText());
            String query = "INSERT INTO plannings(month,start_day,end_day,start_hour,end_hour,receptionists_id) VALUES ('" + tfPWorkMonth.getText() + "'," + pStartDay + "," + pEndDay + "," + pStartHour + "," + pEndHour +","+pRecepId+")";
            InsertUpdateDelete.runQuery(query, "Plan added successfully");
            showPlannings(getPlanningList());
        } catch (NumberFormatException ex) {
            JavaFXDialogs.exceptionDialog(ex, "Field requires a number");
        }
    }

    @FXML
    private void deleteRecord() {
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Are you sure you want to delete room number " + roomNumber + " ?");
        if (result.get() == ButtonType.OK) {
            String query = "DELETE FROM rooms WHERE rooms_id = " + id;
            InsertUpdateDelete.runQuery(query, "Room deleted successfully");
            showRooms(getRoomList());
        }
    }

    @FXML
    private void deletePlanningRecord() {
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Are you sure you want to delete the planning with id: " + planId + " ?");
        if (result.get() == ButtonType.OK) {
            String query = "DELETE FROM plannings WHERE plannings_id = " + planId;
            InsertUpdateDelete.runQuery(query, "plan deleted successfully");
            showPlannings(getPlanningList());
        }
    }

    @FXML
    private void deleteRecordEmp() {
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Are you sure you want to delete " + nameOfEmp + " ?");
        if (result.get() == ButtonType.OK) {
            String query = "DELETE FROM receptionists WHERE receptionists_id = " + idEmp;
            InsertUpdateDelete.runQuery(query, "Employee deleted successfully");
            showEmployees(getEmployeeList());
        }
    }

    @FXML
    private void setterClicked(MouseEvent event) {
        try {
            Room room = tvRooms.getSelectionModel().getSelectedItem();
            id = room.getId();
            roomNumber = room.getNumber();
        } catch (Exception e) {
        }
    }

    @FXML
    private void tvPlanningClicked(MouseEvent event) {
        try {
            Planning plan = tvPlannings.getSelectionModel().getSelectedItem();
            planId = plan.getPlanningId();
        } catch (Exception e) {
        }
    }

    @FXML
    void tvEmployeeClicked(MouseEvent event) {
        try {
            Employee employee = tvEmployees.getSelectionModel().getSelectedItem();
            idEmp = employee.getIdEmp();
            nameOfEmp = employee.getFirstNameEmp();
        } catch (Exception e) {
        }
    }

    @FXML
    private void updateRecord() {
        int success = 0;
        int roomNumber;
        double price;
        if (!(tfNumber.getText() == null || tfNumber.getText().trim().isEmpty())) {
            try {
                roomNumber = Integer.parseInt(tfNumber.getText().trim());
                String query = "update rooms set rooms_number =" + roomNumber + " where rooms_id = " + id;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for room number");
            }
        }
        if (!(tfMaxNoPersons.getText() == null | tfMaxNoPersons.getText().trim().isEmpty())) {
            try {
                roomNumber = Integer.parseInt(tfMaxNoPersons.getText().trim());
                String query = "update rooms set rooms_maxPersons =" + roomNumber + " where rooms_id = " + id;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for maximum number of persons");
            }
        }
        if (!(tfPricePerNight.getText() == null | tfPricePerNight.getText().trim().isEmpty())) {
            try {
                price = Double.parseDouble(tfPricePerNight.getText().trim());
                String query = "update rooms set rooms_pricePerNight =" + price + " where rooms_id = " + id;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for price per night");
            }
        }
        if (!(tfRoomType.getText() == null | tfRoomType.getText().trim().isEmpty())) {
            String query = "UPDATE rooms SET rooms_type = '" + tfRoomType.getText().trim() + "' WHERE rooms_id=" + id;
            InsertUpdateDelete.runQuery(query, "");
            success++;
        }
        if (!(tfStatus.getText() == null | tfStatus.getText().trim().isEmpty())) {
            String query = "UPDATE rooms SET rooms_status = '" + tfStatus.getText().trim() + "' WHERE rooms_id=" + id;
            InsertUpdateDelete.runQuery(query, "");
            success++;
        }
        if (!(tfBedType.getText() == null | tfBedType.getText().trim().isEmpty())) {
            String query = "UPDATE rooms SET rooms_bedType = '" + tfBedType.getText().trim() + "' WHERE rooms_id=" + id;
            InsertUpdateDelete.runQuery(query, "");
            success++;
        }
        if (success > 0)
            JavaFXDialogs.informationDialog("Successful Update");
        showRooms(getRoomList());
    }

    @FXML
    private void updatePlanningRecord() {
        int success = 0;
        int Number;
        if (!(tfPRecepId.getText() == null || tfPRecepId.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(tfPRecepId.getText().trim());
                String query = "update plannings set receptionists_id =" + Number + " where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for receptionist id");
            }
        }
        if (!(tfPWorkMonth.getText() == null | tfPWorkMonth.getText().trim().isEmpty())) {
                String query = "update plannings set month ='" + tfPWorkMonth.getText() + "' where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
        }
        if (!(tfPStartDay.getText() == null | tfPStartDay.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(tfPStartDay.getText().trim());
                String query = "update plannings set start_day =" + Number + " where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for start day");
            }
        }
        if (!(tfPEndDay.getText() == null | tfPEndDay.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(tfPEndDay.getText().trim());
                String query = "update plannings set end_day =" + Number + " where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for end day");
            }
        }
        if (!(tfPStartHour.getText() == null | tfPStartHour.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(tfPStartHour.getText().trim());
                String query = "update plannings set start_hour =" + Number + " where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for start hour");
            }
        }
        if (!(tfPEndHour.getText() == null | tfPEndHour.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(tfPEndHour.getText().trim());
                String query = "update plannings set end_hour =" + Number + " where plannings_id = " + planId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                JavaFXDialogs.exceptionDialog(e, "Entry not valid for end hour");
            }
        }
        if (success > 0)
            JavaFXDialogs.informationDialog("Successful Update");
        showPlannings(getPlanningList());
    }

    @FXML
    void searchBtnClicked(ActionEvent event) {
        String search = searchTF.getText();
        if (search != null)
            search = search.trim();
        String query = "";
        try {
            int searchInt = Integer.parseInt(search);
            query = "SELECT * FROM rooms WHERE rooms_number = " + searchInt + "  OR rooms_maxPersons =" + searchInt;
        } catch (Exception e) {
            try {
                double searchDouble = Double.parseDouble(search);
                query = "SELECT * FROM rooms WHERE rooms_pricePerNight = " + searchDouble;
            } catch (Exception e1) {
                query = "SELECT * FROM rooms WHERE rooms_type = '" + search + "' OR rooms_bedType ='" + search + "' OR rooms_status ='" + search + "'";
            }
        }
        ObservableList<Room> roomList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Room room;
            while (rs.next()) {
                room = new Room(rs.getInt("rooms_id"), rs.getInt("rooms_number"), rs.getString("rooms_type"), rs.getString("rooms_bedType"), rs.getDouble("rooms_pricePerNight"), rs.getInt("rooms_maxPersons"), rs.getString("rooms_status"));
                roomList.add(room);
            }
        } catch (Exception e) {
            JavaFXDialogs.exceptionDialog(e, "Error in occurred while typing get book from DB");
        }
        showRooms(roomList);
    }

    @FXML
    void searchPlanningBtnClicked(ActionEvent event) {
        String search = searchPlanningTF.getText();
        if (search != null)
            search = search.trim();
        String query = "";
        try {
            int searchInt = Integer.parseInt(search);
            query = "SELECT plannings_id, receptionists_firstName, receptionists_id, month, start_day, end_day, start_hour, end_hour FROM plannings join receptionists using(receptionists_id) where receptionists_id =" + searchInt;
        } catch (Exception e) {
                query = "SELECT plannings_id, receptionists_firstName, receptionists_id, month, start_day, end_day, start_hour, end_hour FROM plannings join receptionists using(receptionists_id) where month ='" + search + "'";
        }
        ObservableList<Planning> planningsList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Planning planning;
            while (rs.next()) {
                planning = new Planning(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),rs.getInt(8));
                planningsList.add(planning);
            }
        } catch (Exception e) {
            JavaFXDialogs.exceptionDialog(e, "Error in occurred while typing get book from DB");
        }
        showPlannings(planningsList);
    }

    public void searchBtnClClicked(ActionEvent actionEvent) {
        String search = searchTFCl.getText();
        if (search != null)
            search = search.trim();
        String query = "Select customers_id, firstname , email, country, status, method,paid,checkin,checkout,rooms_number from customers left join payments using(customers_id) left join bookings using(customers_id) left join rooms using(rooms_id)";
        try {
            int searchInt = Integer.parseInt(search);
            query += " WHERE rooms_number = " + searchInt;
        } catch (Exception e) {
            try {
                double searchDouble = Double.parseDouble(search);
                query += " WHERE paid = " + searchDouble;
            } catch (Exception e1) {
                try {
                    Date date = Date.valueOf(search);
                    query += " WHERE checkin = '" + date + "' OR checkout = '" + date + "'";
                } catch (Exception e2) {
                    query += " WHERE firstname = '" + search + "' OR email ='" + search + "' OR country ='" + search + "'OR status ='" + search + "'OR method ='" + search + "'";
                }
            }
        }
        ObservableList<Client> clientList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Client client;
            while (rs.next()) {
                client = new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                clientList.add(client);
            }
        } catch (Exception e) {
            JavaFXDialogs.exceptionDialog(e, "Error in occurred while typing get customers from DB");
        }
        showClients(clientList);
    }

    @FXML
    void searchBtnEmpClicked(ActionEvent event) {
        String search = searchTFEmp.getText();
        if (search != null)
            search = search.trim();
        Date date;
        String query = "";
        try {
            date = Date.valueOf(search);
            query = "SELECT * FROM receptionists WHERE receptionists_dateOfBirth = '" + date + "'";
        } catch (Exception e) {
            query = "SELECT * FROM receptionists WHERE receptionists_firstName = '" + search + "' OR receptionists_lastName ='" + search + "' OR receptionists_email ='" + search + "' OR receptionists_sex ='" + search + "' OR receptionists_address = '" + search + "'";
        }
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            Employee employee;
            while (rs.next()) {
                employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getDate(7), rs.getString(9));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            JavaFXDialogs.exceptionDialog(e, "Error in occurred while typing get employee from DB");
        }
        showEmployees(employeeList);
    }

    @FXML
    void refreshBtnClicked(ActionEvent event) {
        showRooms(getRoomList());
    }

    @FXML
    void refreshPlanningBtnClicked(ActionEvent event) {
        showPlannings(getPlanningList());
    }


    @FXML
    void refreshBtnEmpClicked(ActionEvent event) {
        showEmployees(getEmployeeList());
    }

    public void refreshBtnClClicked(ActionEvent actionEvent) {
        showClients(getClientList());
    }

    public void minimiseBtnClicked(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setIconified(true);
    }


    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Do you really want to exit?");
        if (result.get() == ButtonType.OK){
            window.close();
        }
    }

    public void logOutBtnClicked(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../fxmlPac/main.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }



}

