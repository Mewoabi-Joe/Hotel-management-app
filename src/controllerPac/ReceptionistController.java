package controllerPac;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;

//
//import  com.lowagie.text.pdf.*;
//import  com.lowagie.text.*;
import javafx.stage.Stage;
import sample.*;
import tablePac.Planning;
import tablePac.PlanningInP;
import utilitiesPac.InsertUpdateDelete;
import utilitiesPac.Select;

import javax.swing.*;
//import static sample.JavaFXDialogs.*;

public class ReceptionistController implements Initializable {
    private final DropShadow shadow=new DropShadow(10, Color.ORANGERED);
    @FXML
    private Button voirimage;

    @FXML
    private JFXButton book;

    @FXML
    private JFXDatePicker debut_reser;

    @FXML
    private JFXDatePicker fin_reser;

    @FXML
    private JFXComboBox<String> room_service;

    @FXML
    private Label EnCli;

    @FXML
    private JFXButton enregistrer;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    private JFXComboBox<String> bed;

    @FXML
    private JFXComboBox<String> room_type;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField lastname;


    @FXML
    private JFXTextField nbreadult;

    @FXML
    private JFXTextField nbreenfant;

    @FXML
    private JFXTextField email=new JFXTextField();

    @FXML
    private JFXComboBox<String> room_number;

    @FXML
    private JFXTextField mobile=new JFXTextField();

    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField checkin;

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField numberofday;

    @FXML
    private JFXTextField finalprice;


    @FXML
    private JFXButton supprimer;

    ////Elements de Rooms de la receptionniste
    @FXML
    private TableView<Chambre> chambre;

    @FXML
    private TableColumn<Chambre,Integer> col_ID_chambre;

    @FXML
    private TableColumn<Chambre, Integer> col_num_chambre;

    @FXML
    private TableColumn<Chambre, Double> col_prix_chambre;

    @FXML
    private TableColumn<Chambre, Integer> col_phone_cham;

    @FXML
    private TableColumn<Chambre, String> col_status_cham;

    @FXML
    private TableColumn<Chambre, String> col_bed_cham;

    @FXML
    private TableColumn<Chambre, java.sql.Date> col_deb_occup;

    @FXML
    private TableColumn<Chambre, java.sql.Date> col_fin_occup;

    @FXML
    private TableColumn<Chambre, String> col_type_cham;

    @FXML
    private TableColumn<Chambre, Integer> col_max_people;

    @FXML
    private JFXButton search;


    @FXML
    private JFXTextField element_rechercher;

    @FXML
    private JFXComboBox<String> type_recherche;

    @FXML
    private JFXDatePicker start_date;

    @FXML
    private JFXDatePicker end_date;

    @FXML
    private JFXComboBox<String> compare;

    @FXML
    private JFXButton refresh_chambre;

    @FXML
    private JFXTextField chambre_libre;

    @FXML
    private JFXTextField total_chambre;

////Elements de Rooms de la receptionniste

    /////Elements de check_in
    @FXML
    private TableView<Reservator> table_view_check_in;

    @FXML
    private TableColumn<Reservator, String> col_name1;

    @FXML
    private TableColumn<Reservator, String> col_name2;

    @FXML
    private TableColumn<Reservator, Integer> col_phone_client;

    @FXML
    private TableColumn<Reservator, String> col_nationality;

    @FXML
    private TableColumn<Reservator, String> col_gender;

    @FXML
    private TableColumn<Reservator, String> col_email;

    @FXML
    private TableColumn<Reservator, java.sql.Date> col_check_in;

    @FXML
    private TableColumn<Client, String> col_status_reservateur;

    @FXML
    private TableColumn<Reservator, Integer> col_ID_client_reservator;

    @FXML
    private JFXButton refresh_check_in;

    @FXML
    private JFXButton delete_check_in;

    @FXML
    private JFXButton update_check_in;

    @FXML
    private JFXButton check_statut;

    @FXML
    private JFXTextField text_field_firstname;

    @FXML
    private JFXTextField text_field_lastname;

    @FXML
    private JFXTextField text_field_mobile_number;

    @FXML
    private JFXTextField text_field_nationality;

    @FXML
    private JFXTextField text_field_id_gender;

    @FXML
    private JFXTextField text_field_id_email;

    @FXML
    private JFXTextField text_field_id;

    @FXML
    private JFXButton search_check_in;

    @FXML
    private JFXComboBox<String> combo_check_in;

    @FXML
    private JFXTextField search_barre;

    //Elements de check_in


    //////ELEMENTS DE CHECK OUT
    @FXML
    private TableView<Customer_end> table_view_check_in1;

    @FXML
    private TableColumn<Customer_end, Integer> col_ID_client_reservator2;

    @FXML
    private TableColumn<Customer_end, String> col_name21;

    @FXML
    private TableColumn<Customer_end, String> col_name3;

    @FXML
    private TableColumn<Customer_end, Integer> col_phone_client2;

    @FXML
    private TableColumn<Customer_end, String> col_nationality2;

    @FXML
    private TableColumn<Customer_end, String> col_gender2;

    @FXML
    private TableColumn<Customer_end, String> col_email2;

    @FXML
    private TableColumn<Customer_end, java.sql.Date> col_check_in2;

    @FXML
    private TableColumn<Customer_end, Integer> room_number2;

    @FXML
    private TableColumn<Customer_end, Double> Price_per_Day2;

    @FXML
    private JFXTextField text_field_ID;

    @FXML
    private JFXButton refresh2;

    @FXML
    private JFXButton search2;

    @FXML
    private JFXButton check_out;

    @FXML
    private JFXButton clear_check_out;



    @FXML
    private JFXComboBox<String> search_field_check_out;

    @FXML
    private JFXTextField text_field_research;

    //////ELEMENTS DE CHECK OUT


    ///////Elements de BOOKING
    @FXML
    private TableView<tablePac.Client> tvClientsRecep;
    @FXML
    private TableColumn<tablePac.Client, Integer> ClIDCol;
    @FXML
    private TableColumn<tablePac.Client, String> ClFirstNameCol;
    @FXML
    private TableColumn<tablePac.Client, String> ClEmailCol;
    @FXML
    private TableColumn<tablePac.Client, String> ClCountryCol;
    @FXML
    private TableColumn<tablePac.Client, String> ClStatusCol;
    @FXML
    private TableColumn<tablePac.Client, String> ClMethodCol;
    @FXML
    private TableColumn<tablePac.Client, Double> ClPaidCol;
    @FXML
    private TableColumn<tablePac.Client, java.sql.Date> ClCheckInCol;
    @FXML
    private TableColumn<tablePac.Client, java.sql.Date> ClCheckOutCol;
    @FXML
    private TableColumn<tablePac.Client, Integer> ClRoomNumCol;
    @FXML
    private JFXTextField searchTFCl;
    private  int RecepId;

    @FXML
    private TableView<PlanningInP> tvPlanning;

    @FXML
    private TableColumn<PlanningInP, Integer> pIDCol;

    @FXML
    private TableColumn<PlanningInP, String> pMonthCol;

    @FXML
    private TableColumn<PlanningInP, Integer> pStartDayCol;

    @FXML
    private TableColumn<PlanningInP, Integer> pEndDayCol;

    @FXML
    private TableColumn<PlanningInP, Integer> pStartHourCol;

    @FXML
    private TableColumn<PlanningInP, Integer> pEndHourCol;

    @FXML
    private JFXTextField pFirstNameTF;

    @FXML
    private JFXTextField pLastNameTF;

    @FXML
    private JFXTextField pEmailTF;

    @FXML
    private JFXComboBox<String> pGenderCB;

    @FXML
    private JFXDatePicker pDateOfBirthDP;

    @FXML
    private JFXTextField pIDCardNoTF;

    @FXML
    private JFXTextField pAddressTF;

    @FXML
    private JFXButton refresh_booking;



    public void setUserId(int id){
        this.RecepId = id;
        setProfile();
        showPlannings(getPlanningList());
    }

    public void minimiseBtnClicked(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setIconified(true);
    }


    @FXML
    void exitBtnClicked(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Optional<ButtonType> result = utilitiesPac.JavaFXDialogs.confirmationDialog("Do you really want to exit?");
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


    public void refreshBtnClClicked(ActionEvent actionEvent) {
        showClients(getClientList());
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
                    java.sql.Date date = java.sql.Date.valueOf(search);
                    query += " WHERE checkin = '" + date + "' OR checkout = '" + date + "'";
                } catch (Exception e2) {
                    query += " WHERE firstname = '" + search + "' OR email ='" + search + "' OR country ='" + search + "'OR status ='" + search + "'OR method ='" + search + "'";
                }
            }
        }
        ObservableList<tablePac.Client> clientList = FXCollections.observableArrayList();
        ResultSet rs;

        try {
            rs = Select.getData(query);
            tablePac.Client client;
            while (rs.next()) {
                client = new tablePac.Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                clientList.add(client);
            }
        } catch (Exception e) {
            utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Error in occurred while typing get customers from DB");
        }
        showClients(clientList);
    }


    public ObservableList<tablePac.Client> getClientList() {
        ObservableList<tablePac.Client> clientList = FXCollections.observableArrayList();
        String query = "Select customers_id, firstname , email, country, status, method,paid,checkin,checkout,rooms_number from customers left join payments using(customers_id) left join bookings using(customers_id) left join rooms using(rooms_id)";
        ResultSet rs;

        try {
            rs = Select.getData(query);
            tablePac.Client client;
            while (rs.next()) {
                client = new tablePac.Client(rs.getInt("customers_id"), rs.getString("firstname"), rs.getString("email"), rs.getString("country"), rs.getString("status"), rs.getString("method"), rs.getDouble("paid"), rs.getDate("checkin"), rs.getDate("checkout"), rs.getInt("rooms_number"));
                clientList.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientList;
    }

    public void showClients(ObservableList<tablePac.Client> listClient) {
        ObservableList<tablePac.Client> list = listClient;
        ClIDCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, Integer>("clId"));
        ClFirstNameCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, String>("clFName"));
        ClEmailCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, String>("clEmail"));
        ClCountryCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, String>("clCountry"));
        ClStatusCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, String>("clStatus"));
        ClMethodCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, String>("clPayMethod"));
        ClPaidCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, Double>("clAmtPaid"));
        ClCheckInCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, java.sql.Date>("clCheckIn"));
        ClCheckOutCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, java.sql.Date>("clCheckOut"));
        ClRoomNumCol.setCellValueFactory(new PropertyValueFactory<tablePac.Client, Integer>("clRoomNum"));
        tvClientsRecep.setItems(list);
    }

    public void action4()//cette methode modifit le status d'une chambre une fois que celle ci a ete choisi par un client
    {
        String query = "";
        int Room_number = Integer.parseInt(room_number.getSelectionModel().getSelectedItem());
        java.sql.Date Debut_occup;
        if(!((numberofday.getText()).equals(""))) {
            query = "UPDATE rooms SET rooms_status='occupe' WHERE rooms_number="+Room_number+";";

            String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
            String userName = "root";
            String password = "1 guy 2 code";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException ignored) {
            }
            try {
                Connection connect = DriverManager.getConnection(url, userName, password);
                PreparedStatement stat = connect.prepareStatement(query);
                stat.executeUpdate();


                stat.close();
                connect.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        else if((debut_reser.getValue()!=null)&&(fin_reser.getValue()!=null)&&((numberofday.getText()).equals(""))) {
            LocalDate date1 = debut_reser.getValue();
            Debut_occup = java.sql.Date.valueOf(date1);

            java.util.Date debut_occupation2 =  (Calendar.getInstance()).getTime();
            LocalDate debut_occ2 = debut_occupation2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            java.sql.Date Debut_occup2 = java.sql.Date.valueOf(debut_occ2);
            if (Debut_occup.equals(Debut_occup2)) {
                query = "UPDATE rooms SET rooms_status='occupe' WHERE  rooms_number="+Room_number+";";

                String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
                String userName = "root";
                String password = "1 guy 2 code";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                } catch (ClassNotFoundException ignored) {
                }
                try {
                    Connection connect = DriverManager.getConnection(url, userName, password);
                    PreparedStatement stat = connect.prepareStatement(query);
                    stat.executeUpdate();


                    stat.close();
                    connect.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

        /*
        LocalDate date1 = debut_reser.getValue();
        Debut_occup1 = java.sql.Date.valueOf(date1);

        SimpleDateFormat myformat=new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal1= Calendar.getInstance();
        Date debut_occupation2 = (Calendar.getInstance()).getTime();
        LocalDate debut_occ2 = debut_occupation2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Debut_occup2 = java.sql.Date.valueOf(debut_occ2);
        */

            /*String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
            String userName = "root";
            String password = "";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                } catch (ClassNotFoundException ignored) {
                }
                try {
                    Connection connect = DriverManager.getConnection(url, userName, password);
                    PreparedStatement stat = connect.prepareStatement(query);
                    stat.executeUpdate();


                    stat.close();
                    connect.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
*/

    }

    public void action3()//cette fonction affiche le montant total que devra payer le client une fois les jours passes
    {
        if (!((numberofday.getText()).equals("")))
        {
            double final_price=Double.parseDouble(price.getText())*Integer.parseInt(numberofday.getText());
            finalprice.setText(""+final_price);
        }
        if((debut_reser.getValue()!=null)&&(fin_reser.getValue()!=null)&&((numberofday.getText()).equals("")))
        {
            LocalDate date1= debut_reser.getValue();
            LocalDate date2= fin_reser.getValue();
            int jour= (int)ChronoUnit.DAYS.between(date1, date2)+1;
            double final_price=jour*Double.parseDouble(price.getText());
            finalprice.setText(""+final_price);
        }
        //Paiement paye=new Paiement()

    }

    public void action2()//action2 permet d'afficher le prix de la chambre choisit
    {
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        String userName= "root";
        String password="1 guy 2 code";

        int Room_number=Integer.parseInt(room_number.getSelectionModel().getSelectedItem());
        String query ="SELECT * FROM rooms WHERE  rooms_number="+Room_number+";";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException ignored)
        {
            JavaFXDialogs.confirmationDialog("there is a problem with the connections to the database");
        }
        try
        {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();
            ResultSet rs1 = statement.executeQuery(query);

            while (rs1.next())
            {
                price.setText(""+rs1.getInt("rooms_pricePerNight"));
            }

            statement.close();
            connection.close();


        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        action3();
    }

    public void action1() throws ParseException//cette fonction permet d'afficher toute les chambres verifiant les conditions du client
    {

        ////
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        String userName= "root";
        String password="1 guy 2 code";
        String Bed = bed.getSelectionModel().getSelectedItem();
        String Room_type = room_type.getSelectionModel().getSelectedItem();
        int total_pers=Integer.parseInt(nbreenfant.getText())+Integer.parseInt(nbreadult.getText());
        if((debut_reser.getValue()==null)&&(fin_reser.getValue()==null))
        {
            SimpleDateFormat myforma=new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal1= Calendar.getInstance();

            cal1.add(Calendar.DATE, Integer.parseInt(numberofday.getText())-1);

            java.util.Date fin_occupation=   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format(cal1.getTime()));
            java.util.Date debut_occupation =   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format((Calendar.getInstance()).getTime()));

            LocalDate fin_occ= fin_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate debut_occ= debut_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            java.sql.Date Debut_occup= java.sql.Date.valueOf( debut_occ);
            java.sql.Date Fin_occup= java.sql.Date.valueOf( fin_occ);
            //String query = "SELECT * FROM rooms LEFT JOIN bookings on rooms.rooms_id=bookings.rooms_id  WHERE rooms_bedType='" + Bed + "' and rooms_type ='" + Room_type + "' and rooms_status='non-occupe' and rooms_maxPersons<="+total_pers+" and  checkin>'"+Fin_occup+"' or checkout <'"+Debut_occup+"';";

            String query = "SELECT * FROM rooms LEFT JOIN bookings USING(rooms_id)  WHERE (rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and (checkin<'"+Debut_occup+"' and checkout<'"+Debut_occup+"')) or ((rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and checkin>'"+Fin_occup+"' and checkout>'"+Fin_occup+"')) or ((rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and checkin is null and checkout is null)) ORDER BY rooms_number;";



            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException ignored) {
            }
            try {
                Connection con = DriverManager.getConnection(url, userName, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    room_number.getItems().addAll(""+rs.getString("rooms_number"));
                }
                rs.close();
                st.close();
                con.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if((debut_reser.getValue()!=null)&&(fin_reser.getValue()!=null)&&((numberofday.getText()).equals("")))//si les champs de dates de reservation ne sont pas vides
        {

            LocalDate debut_occ1=debut_reser.getValue();

            LocalDate fin_occ1=fin_reser.getValue();

            java.sql.Date debut_re= java.sql.Date.valueOf( debut_occ1);
            java.sql.Date fin_re= java.sql.Date.valueOf( fin_occ1);


            String query = "SELECT * FROM rooms LEFT JOIN bookings USING(rooms_id)  WHERE (rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and (checkin<'"+debut_re+"' and checkout<'"+debut_re+"')) or ((rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and checkin>'"+fin_re+"' and checkout>'"+fin_re+"')) or ((rooms_bedType='" + Bed + "' and rooms_type='"+Room_type+"' and rooms_status='non-occupe' and rooms_maxPersons>="+total_pers+" and checkin is null and checkout is null)) ORDER BY rooms_number;";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            } catch (ClassNotFoundException ignored) {
            }
            try {
                Connection connector = DriverManager.getConnection(url, userName, password);
                Statement st = connector.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    room_number.getItems().addAll(rs.getString("rooms_number"));
                }
                rs.close();

                st.close();
                connector.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void effet1(MouseEvent event) {
        if(event.getSource()==enregistrer)
        {
            enregistrer.setEffect(shadow);
        }
        if(event.getSource()==book)
        {
            book.setEffect(shadow);
        }
        if(event.getSource()==supprimer)
        {
            supprimer.setEffect(shadow);
        }
        if(event.getSource()==search)
        {
            search.setEffect(shadow);
        }
        if(event.getSource()==refresh_chambre)
        {
            refresh_chambre.setEffect(new DropShadow(10, Color.BLUEVIOLET));
        }
        if(event.getSource()==search)
        {
            search.setEffect(new DropShadow(10, Color.BLUEVIOLET));
        }
        if(event.getSource()==refresh_check_in)
        {
            refresh_check_in.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==delete_check_in)
        {
            delete_check_in.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==update_check_in)
        {
            update_check_in.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==search_check_in)
        {
            search_check_in.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==search_check_in)
        {
            search_check_in.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==search2)
        {
            search2.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==refresh2)
        {
            refresh2.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==check_out)
        {
            check_out.setEffect(new DropShadow(15, Color.GOLD));
        }
        if(event.getSource()==clear_check_out)
        {
            clear_check_out.setEffect(new DropShadow(15, Color.GOLD));
        }




    }

    @FXML
    void effet2(MouseEvent event) {
        if(event.getSource()==enregistrer)
        {
            enregistrer.setEffect(null);
        }
        if(event.getSource()==book)
        {
            book.setEffect(null);
        }
        if(event.getSource()==supprimer)
        {
            supprimer.setEffect(null);
        }
        if(event.getSource()==search)
        {
            search.setEffect(null);
        }
        if(event.getSource()==refresh_chambre)
        {
            refresh_chambre.setEffect(null);
        }
        if(event.getSource()==search)
        {
            search.setEffect(null);
        }
        if(event.getSource()==refresh_check_in)
        {
            refresh_check_in.setEffect(null);
        }
        if(event.getSource()==delete_check_in)
        {
            delete_check_in.setEffect(null);
        }
        if(event.getSource()==update_check_in)
        {
            update_check_in.setEffect(null);
        }
        if(event.getSource()==search_check_in)
        {
            search_check_in.setEffect(null);
        }
        if(event.getSource()==search_check_in)
        {
            search_check_in.setEffect(null);
        }
        //
        if(event.getSource()==search2)
        {
            search2.setEffect(null);
        }
        if(event.getSource()==refresh2)
        {
            refresh2.setEffect(null);
        }
        if(event.getSource()==check_out)
        {
            check_out.setEffect(null);
        }
        if(event.getSource()==clear_check_out)
        {
            clear_check_out.setEffect(null);
        }
    }

    @FXML
    void  Refresh_booking(ActionEvent event) throws IOException {
     FXMLLoader loader= new FXMLLoader(getClass().getResource("../fxmlPac/receptionistFXML.fxml"));
     Parent root=(Parent)loader.load();
     Scene scene=new Scene(root);
     Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();


    }


    @FXML
    void valeurs(ActionEvent event) throws ParseException //affecte a un bouton une action
    {
        if(event.getSource()==gender)
        {
            gender.getValue();
        }
        if(event.getSource()==bed)
        {
            bed.getValue();
            //action1();
        }
        if(event.getSource()==room_type)
        {
            room_type.getValue();
            action1();
        }
        if(event.getSource()==room_service)
        {
            room_service.getValue();
        }
        if(event.getSource()==room_number)
        {
            action2();
        }

    }


    @FXML
    void enregistrer_client_chambre(ActionEvent event) throws SQLException, ParseException, NumberFormatException {
//information du client
        //informationDialog("Enregistrement_reussi");
        JavaFXDialogs.confirmationDialog("do you want this room to be occupied");
        String Name = name.getText();
        String Lastname= lastname.getText();
        int nbadult=Integer.parseInt(nbreadult.getText());
        int nbenfant=Integer.parseInt(nbreenfant.getText());
        int mobile_number = Integer.parseInt(""+mobile.getText());
        String Nationality = nationality.getText();
        String Gender = gender.getSelectionModel().getSelectedItem();
        String Email = email.getText();
        String Address = address.getText();
        String mode_paye=room_service.getSelectionModel().getSelectedItem();//
        Double prix_payer=Double.parseDouble(""+finalprice.getText());//
        String check_in_date = checkin.getText();
        java.util.Date Check=   new SimpleDateFormat("yyyy/MM/dd").parse(""+check_in_date);

        LocalDate chec= Check.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date Check_in_date= java.sql.Date.valueOf(chec);

        //int Number_of_day = Integer.parseInt(numberofday.getText());
        String Room_service = room_service.getSelectionModel().getSelectedItem();
        int Room_number = Integer.parseInt(room_number.getSelectionModel().getSelectedItem());

        Paiement paye=new Paiement(mode_paye, prix_payer, Room_number);
        if((debut_reser.getValue()!=null)&&(fin_reser.getValue()!=null))
        {
            LocalDate date1= debut_reser.getValue();
            LocalDate date2= fin_reser.getValue();
            int jourenter= (int)ChronoUnit.DAYS.between(date1, date2);

            LocalDate debut_rese = debut_reser.getValue();
            java.sql.Date debut_re = java.sql.Date.valueOf(debut_rese);//date de debut d'occupation de la chambre

            LocalDate fin_rese = fin_reser.getValue();
            java.sql.Date fin_re = java.sql.Date.valueOf(fin_rese);//date de fin d'occupation de la chambre

            Client client2 = new Client(Name, Lastname, mobile_number, Nationality, Gender, Email, Address, Check_in_date, jourenter, Room_service, Room_number);
            Reservation reservation2=new Reservation(debut_re, fin_re,nbadult,nbenfant,Room_number,RecepId);

            if (event.getSource() == enregistrer) {

                client2.ajouterclient();
                reservation2.ajouterReservation1();
                action4();//cette fontion permet de changer le status d'une chambre si la date de debut de reservation est celle d'aujourd'hui;
                paye.ajouter_paiement();
                JavaFXDialogs.informationDialog("Recording perform");
            }
            if(event.getSource()==supprimer)
            {
                client2.supprimerclient();
                JavaFXDialogs.informationDialog("Successful Deletion");
            }
        }
        if((!(numberofday.getText().equals("")))&& (debut_reser.getValue()==null)&&(fin_reser.getValue()==null) )
        {
            int Number_of_day = Integer.parseInt(numberofday.getText());

            SimpleDateFormat myforma=new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal1= Calendar.getInstance();

            cal1.add(Calendar.DATE, Integer.parseInt(numberofday.getText())-1);

            java.util.Date fin_occupation=   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format(cal1.getTime()));
            java.util.Date debut_occupation =   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format((Calendar.getInstance()).getTime()));

            LocalDate fin_occ= fin_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate debut_occ= debut_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            java.sql.Date debut_re= java.sql.Date.valueOf( debut_occ);
            java.sql.Date fin_re= java.sql.Date.valueOf( fin_occ);

            Client client = new Client(Name, Lastname, mobile_number, Nationality, Gender, Email, Address, Check_in_date, Number_of_day, Room_service, Room_number);
            Reservation reservation=new Reservation(debut_re, fin_re,nbadult,nbenfant,Room_number,RecepId);
            if (event.getSource() == enregistrer) {

                client.ajouterclient();
                reservation.ajouterReservation1();
                action4();//cette fontion permet de changer le status d'une chambre si la date de debut de reservation est celle d'aujourd'hui;
                paye.ajouter_paiement();
                // informationDialog("Enregistrement_reussi");
                JavaFXDialogs.informationDialog("Recording perform");
            }
            if(event.getSource()==supprimer)
            {
                client.supprimerclient();
                JavaFXDialogs.informationDialog("Successful Deletion");
                //informationDialog("Suppression_reussi");
            }
        }

    }
    @FXML
    void reserver_chambre(ActionEvent event) throws ParseException, SQLException {

        String Name = name.getText();
        String Lastname= lastname.getText();
        int nbadult=Integer.parseInt(nbreadult.getText());
        int nbenfant=Integer.parseInt(nbreenfant.getText());
        int mobile_number = Integer.parseInt(""+mobile.getText());
        String Nationality = nationality.getText();
        String Gender = gender.getSelectionModel().getSelectedItem();
        String Email = email.getText();
        String Address = address.getText();
        String mode_paye=room_service.getSelectionModel().getSelectedItem();//
        Double prix_payer=Double.parseDouble(""+finalprice.getText());//
        String check_in_date = checkin.getText();
        java.util.Date Check=  new SimpleDateFormat("yyyy/MM/dd").parse(""+check_in_date);

        LocalDate chec= Check.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date Check_in_date= java.sql.Date.valueOf(chec);

        //int Number_of_day = Integer.parseInt(numberofday.getText());
        String Room_service = room_service.getSelectionModel().getSelectedItem();
        int Room_number = Integer.parseInt(room_number.getSelectionModel().getSelectedItem());

        Paiement paye=new Paiement(mode_paye, prix_payer, Room_number);
        if((debut_reser.getValue()!=null)&&(fin_reser.getValue()!=null))
        {
            LocalDate date1= debut_reser.getValue();
            LocalDate date2= fin_reser.getValue();
            int jourenter= (int)ChronoUnit.DAYS.between(date1, date2)+1;

            LocalDate debut_rese = debut_reser.getValue();
            java.sql.Date debut_re = java.sql.Date.valueOf(debut_rese);//date de debut d'occupation de la chambre

            LocalDate fin_rese = fin_reser.getValue();
            java.sql.Date fin_re = java.sql.Date.valueOf(fin_rese);//date de fin d'occupation de la chambre

            Client client2 = new Client(Name, Lastname, mobile_number, Nationality, Gender, Email, Address, Check_in_date, jourenter, Room_service, Room_number);
            Reservation reservation2=new Reservation(debut_re, fin_re,nbadult,nbenfant,Room_number,RecepId);

            if (event.getSource() == book) {
                JavaFXDialogs.confirmationDialog("do you want to make this reservation?");

                client2.ajouterclient();
                reservation2.ajouterReservation2();
                action4();//cette fontion permet de changer le status d'une chambre si la date de debut de reservation est celle d'aujourd'hui;
                paye.ajouter_paiement();
                JavaFXDialogs.informationDialog("Successful Reservation");
            }

            if(event.getSource()==supprimer)
            {
                JavaFXDialogs.confirmationDialog("want to Delete this Reservation?");
                client2.supprimerclient();
                JavaFXDialogs.informationDialog("Successful Deletion");
            }
            //../ressources/dialogStyling.css
        }
        if((!(numberofday.getText().equals("")))&& (debut_reser.getValue()==null)&&(fin_reser.getValue()==null) )
        {
            int Number_of_day = Integer.parseInt(numberofday.getText());

            SimpleDateFormat myforma=new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal1= Calendar.getInstance();

            cal1.add(Calendar.DATE, Integer.parseInt(numberofday.getText())-1);

            java.util.Date fin_occupation=   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format(cal1.getTime()));
            java.util.Date debut_occupation =   new SimpleDateFormat("yyyy/MM/dd").parse(""+myforma.format((Calendar.getInstance()).getTime()));

            LocalDate fin_occ= fin_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate debut_occ= debut_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            java.sql.Date debut_re= java.sql.Date.valueOf( debut_occ);
            java.sql.Date fin_re= java.sql.Date.valueOf( fin_occ);

            Client client = new Client(Name, Lastname, mobile_number, Nationality, Gender, Email, Address, Check_in_date, Number_of_day, Room_service, Room_number);
            Reservation reservation=new Reservation(debut_re, fin_re,nbadult,nbenfant,Room_number,RecepId);
            if (event.getSource() == book) {
                JavaFXDialogs.confirmationDialog("do you want to make this reservation?");

                client.ajouterclient();
                reservation.ajouterReservation2();
                action4();//cette fontion permet de changer le status d'une chambre si la date de debut de reservation est celle d'aujourd'hui;
                paye.ajouter_paiement();
                //informationDialog("Enregistrement_reussi");
                JavaFXDialogs.informationDialog("Successful Reservation");
            }
            if(event.getSource()==supprimer)
            {
                JavaFXDialogs.confirmationDialog("Do you want to cancel the previous Operation?");
                client.supprimerclient();
                JavaFXDialogs.informationDialog("Successful Deletion");
                //informationDialog("Suppression_reussi");
            }
        }

    }
    ///////ELEMENTS DE BOOKING

    /////ELEMENTS DE ROOMS

    @FXML
    void rafraichir(ActionEvent event) {
        Showchambre();
    }



    @FXML
    void recherche_chambre(ActionEvent event) throws SQLException //cette fonction, utiliser dans Rooms permet d'afficher des chambres dans un tableview
    {
        Connection cone = null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        Statement s = null;
        String query = null;
        ObservableList<Chambre> liste1 = FXCollections.observableArrayList();
        Chambre cham;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {

            if (type_recherche.getSelectionModel().getSelectedItem().equals("room number")) {
                query = "SELECT * FROM rooms WHERE rooms_number=" + Integer.parseInt(element_rechercher.getText()) + ";";
            /*
            cone=getConnection();
            s=cone.createStatement();
            ResultSet rst=s.executeQuery(query);
            while(rst.next())
            {
                cham=new Chambre(rst.getInt("ID_chambre"), rst.getInt("room_number"), rst.getDouble("price_per_day"), rst.getInt("telephone_chambre"), rst.getString("status"), rst.getString("bed"),rst.getString("room_type"), rst.getInt("max_personnes"));

                liste1.add(cham);
            }
            chambre.setItems(liste1);
            */
            }
            //type_recherche.getItems().addAll("room number", "price per day", "phone", "status", "bed", "Date of occupation", "room type", "Max people");
            if (type_recherche.getSelectionModel().getSelectedItem().equals("price per day")) {
                if (compare.getSelectionModel().getSelectedItem().equals(">")) {
                    query = "SELECT * FROM rooms WHERE rooms_pricePerNight>" + Double.parseDouble("" + element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals("<")) {
                    query = "SELECT * FROM rooms WHERE rooms_pricePerNight<" + Double.parseDouble("" + element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals("<=")) {
                    query = "SELECT * FROM rooms WHERE rooms_pricePerNight<=" + Double.parseDouble("" + element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals(">=")) {
                    query = "SELECT * FROM rooms WHERE rooms_pricePerNight>=" + Double.parseDouble("" + element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals("=")) {
                    query = "SELECT * FROM rooms WHERE rooms_pricePerNight=" + Double.parseDouble("" + element_rechercher.getText()) + ";";
                }
            }

            if (type_recherche.getSelectionModel().getSelectedItem().equals("phone")) {
                query = "SELECT * FROM rooms WHERE phone_rooms=" + Integer.parseInt("" + element_rechercher.getText()) + ";";
            }
            if (type_recherche.getSelectionModel().getSelectedItem().equals("bed")) {
                if (element_rechercher.getText().equals("Single") || element_rechercher.getText().equals("single") || element_rechercher.getText().equals("SINGLE")) {
                    query = "SELECT * FROM rooms WHERE rooms_bedType='Single';";
                }
                //bed.getItems().addAll("Single", "Double", "King", "Queen");
                if (element_rechercher.getText().equals("Double") || element_rechercher.getText().equals("double") || element_rechercher.getText().equals("DOUBLE")) {
                    query = "SELECT * FROM rooms WHERE rooms_bedType='Double';";
                }
                if (element_rechercher.getText().equals("King") || element_rechercher.getText().equals("king") || element_rechercher.getText().equals("KING")) {
                    query = "SELECT * FROM rooms WHERE rooms_bedType='King';";
                }
                if (element_rechercher.getText().equals("Queen") || element_rechercher.getText().equals("queen") || element_rechercher.getText().equals("QUEEN")) {
                    query = "SELECT * FROM rooms WHERE rooms_bedType='Queen';";
                }

            }
            if (type_recherche.getSelectionModel().getSelectedItem().equals("status")) {
                if (element_rechercher.getText().equals("occupe") || element_rechercher.getText().equals("OCCUPE") || element_rechercher.getText().equals("Occupe")) {
                    query = "SELECT * FROM rooms WHERE rooms_status='occupe';";
                }
                if (element_rechercher.getText().equals("non-occupe") || element_rechercher.getText().equals("NON-OCCUPE") || element_rechercher.getText().equals("Non-Occupe") || element_rechercher.getText().equals("Non Occupe") || element_rechercher.getText().equals("non occupe") || element_rechercher.getText().equals("NON OCCUPE")) {
                    query = "SELECT * FROM rooms WHERE rooms_status='non-occupe';";
                }
            }
            if (type_recherche.getSelectionModel().getSelectedItem().equals("room type")) {
                //"Regular Room", "Family Room", "Deluxe Room"
                try {
                    if (element_rechercher.getText().equals("Regular") || element_rechercher.getText().equals("REGULAR") || element_rechercher.getText().equals(" REGULAR") || element_rechercher.getText().equals(" regular") || element_rechercher.getText().equals(" regular room") || element_rechercher.getText().equals(" REGULAR Room") || element_rechercher.getText().equals(" Regular Room") || element_rechercher.getText().equals("regular")) {
                        query = "SELECT * FROM rooms WHERE rooms_type='Regular Room';";
                    }
                    if (element_rechercher.getText().equals("Family") || element_rechercher.getText().equals("FAMILY") || element_rechercher.getText().equals(" FAMILY ROOM") || element_rechercher.getText().equals(" family room")) {
                        query = "SELECT * FROM rooms WHERE rooms_type='Family Room';";
                    }
                    if (element_rechercher.getText().equals("Deluxe Room") || element_rechercher.getText().equals("deluxe room") || element_rechercher.getText().equals(" deluxe") || element_rechercher.getText().equals("  Deluxe")) {
                        query = "SELECT * FROM rooms WHERE rooms_type='Deluxe Room';";
                    }
                } catch (Exception e) {
                    // JavaFXDialogs.exceptionDialog(e, "check the item you want to search or the field you want to search");
                }
            }
            if (type_recherche.getSelectionModel().getSelectedItem().equals("Max people")) {
                //compare.getItems().addAll("<",">","=","<=",">=");
                if (compare.getSelectionModel().getSelectedItem().equals("<")) {
                    query = query = "SELECT * FROM rooms WHERE rooms_maxPersons <" + Integer.parseInt(element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals(">")) {
                    query = query = "SELECT * FROM rooms WHERE rooms_maxPersons >" + Integer.parseInt(element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals("<=")) {
                    query = query = "SELECT * FROM rooms WHERE rooms_maxPersons <=" + Integer.parseInt(element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals(">=")) {
                    query = query = "SELECT * FROM rooms WHERE rooms_maxPersons >=" + Integer.parseInt(element_rechercher.getText()) + ";";
                }
                if (compare.getSelectionModel().getSelectedItem().equals("=")) {
                    query = query = "SELECT * FROM rooms WHERE rooms_maxPersons =" + Integer.parseInt(element_rechercher.getText()) + ";";
                }
            }


            cone = getConnection();
            s = cone.createStatement();
            ResultSet rst = s.executeQuery(query);
            while (rst.next()) {
                cham = new Chambre(rst.getInt("rooms_id"), rst.getInt("rooms_number"), rst.getDouble("rooms_pricePerNight"), rst.getInt("phone_rooms"), rst.getString("rooms_status"), rst.getString("rooms_bedType"), rst.getString("rooms_type"), rst.getInt("rooms_maxPersons"));

                liste1.add(cham);
            }
            chambre.setItems(liste1);

            rst.close();
            s.close();
            cone.close();
        }catch(Exception e)
        {
            //  JavaFXDialogs.exceptionDialog(e,"check the item you want to search or the field you want to search");
        }


    }

    ////ELEMENTS DE ROOMS

    ////ELEMENTS DE CHECK_IN
    @FXML
    void refresh_check_in(ActionEvent event) {
        Show_client_reservator();
    }

    @FXML
    void delete_check_in(ActionEvent event) {
        Connection conne = null;
        PreparedStatement prs = null;
        PreparedStatement prs2=null;
        PreparedStatement prs3=null;
        int ID_client=Integer.parseInt(""+text_field_id.getText());
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            conne = DriverManager.getConnection(url, "root", "1 guy 2 code");

            prs2=conne.prepareStatement("DELETE FROM bookings WHERE customers_id="+ID_client+";");
            prs2.executeUpdate();

            prs3=conne.prepareStatement("DELETE FROM payments WHERE customers_id="+ID_client+";");
            prs3.executeUpdate();

            prs = conne.prepareStatement("DELETE  FROM customers WHERE customers_id="+ID_client+";");
            prs.executeUpdate();

            JavaFXDialogs.informationDialog("Successful deletion");
            prs.close();
            conne.close();
        }catch(SQLException e)
        {
            //e.printStackTrace();
            //  JavaFXDialogs.exceptionDialog(e,"Cannot delete customer information");
        }

        Show_client_reservator();
    }

    @FXML
    void handleMouseAction(MouseEvent event) //cette fonction affiche les elements d'un tuple du tableview dans des textfields
    {
        Reservator reservateur= table_view_check_in.getSelectionModel().getSelectedItem();

        text_field_id.setText(""+reservateur.getID_client());
        text_field_firstname.setText(""+reservateur.getNom());
        text_field_lastname.setText(""+reservateur.getPrenom());
        text_field_mobile_number.setText(""+reservateur.getNumero_telephone());
        text_field_nationality.setText(""+reservateur.getNationality());
        text_field_id_gender.setText(""+reservateur.getGender());
        text_field_id_email.setText(""+reservateur.getEmail());
        Show_client_reservator();
    }

    @FXML
    void Update_check_in(ActionEvent event) {
        Connection cone=null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        PreparedStatement ps=null;
        String query="UPDATE customers SET firstname='"+text_field_firstname.getText()+"', lastname='"+text_field_lastname.getText()+"', phone="+Integer.parseInt(""+text_field_mobile_number.getText())+", country='"+text_field_nationality.getText()+"',gender='"+text_field_id_gender.getText()+"',email='"+text_field_id_email.getText()+"' WHERE customers_id="+Integer.parseInt(text_field_id.getText())+";";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            cone=getConnection();
            ps=cone.prepareStatement(query);
            ps.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Show_client_reservator();
    }

    @FXML
    void recherche_check_in(ActionEvent event) {
        //combo_check_in.getItems().addAll("firstname", "lastname","Mobile Number", "Nationality", "Gender", "Email", "Check in date");
        ObservableList<Reservator> liste2=FXCollections.observableArrayList();
        Connection connex=null;
        String query=null;
        Statement str=null;
        ResultSet Rstr=null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        PreparedStatement prs1=null;
        try {
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("first name")) {
                query = "SELECT * FROM customers WHERE firstName='" + search_barre.getText() + "' AND status='Reservator';";
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("last name")) {
                query = "SELECT * FROM customers WHERE lastName='" + search_barre.getText() + "' AND status='Reservator';";
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("Mobile Number")) {
                query = "SELECT * FROM customers WHERE phone=" + Integer.parseInt("" +search_barre.getText()) + "AND status='Reservator';";
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("Nationality")) {
                query = "SELECT * FROM customers WHERE country='" + search_barre.getText() + "' AND status='Reservator';";
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("Gender")) {
                if (search_barre.getText().equals("MAlE") || search_barre.getText().equals("Male") || search_barre.getText().equals("male") || search_barre.getText().equals(" MAlE") || search_barre.getText().equals(" Male")) {
                    query = "SELECT * FROM customers WHERE gender='Male' AND status='Reservator';";
                }
                if (search_barre.getText().equals("Female") || search_barre.getText().equals("female") || search_barre.getText().equals("FEMALE") || search_barre.getText().equals(" FEMALE") || search_barre.getText().equals(" Female")) {
                    query = "SELECT * FROM customers WHERE gender='Female' AND status='Reservator';";
                }
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("Email")) {
                query = "SELECT * FROM customers WHERE email='" + search_barre.getText() + "' AND status='Reservator';";
            }
            if (combo_check_in.getSelectionModel().getSelectedItem().equals("Check in date")) {
                query = "SELECT * FROM customers WHERE customers_regisTime='" + search_barre.getText() + "' AND status='Reservator';";
            }
        }catch (Exception e)
        {
            //JavaFXDialogs.exceptionDialog(e,"check the item you want to search or the field you want to search");
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            connex=getConnection();
            str=connex.createStatement();
            Rstr=str.executeQuery(query);
            while(Rstr.next())
            {
                Reservator res=new Reservator(Rstr.getInt("customers_id"), Rstr.getString("firstName"), Rstr.getString("lastName"), Rstr.getInt("phone"), Rstr.getString("country"), Rstr.getString("email"), Rstr.getString("gender"), Rstr.getDate("customers_regisTime"));
                liste2.add(res);
            }

            table_view_check_in.setItems(liste2);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void Check_statut(ActionEvent event)//cette fonction change le status d'un client dans check_In
    {
        PreparedStatement pstt=null;
        Connection connection=null;
        ResultSet rs=null;
        String query1="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET rooms.rooms_status='occupe', customers.status='Occupant' WHERE customers_id="+Integer.parseInt(""+text_field_id.getText())+";";
        //String query2="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET rooms.rooms_status='non-occupe', customers.status='non-Occupant' WHERE checkout>'"+Debut_occup+"';";
        try
        {
            connection=getConnection();
            pstt=connection.prepareStatement(query1);
            pstt.executeUpdate();
            utilitiesPac.JavaFXDialogs.informationDialog("Client can now enter his room");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    ////ELEMENTS DE CHECK_IN


    //////ELEMENTS DE CHECK OUT
    @FXML
    void handleMouseAction2(MouseEvent event) //cette fonction affiche les elements d'un tuple du tableview dans des textfields
    {
        Customer_end cust = table_view_check_in1.getSelectionModel().getSelectedItem();
        text_field_ID.setText(""+cust.getID_client());
    }

    @FXML
    void delete_Customer(ActionEvent event) {
        Connection conne = null;
        PreparedStatement prs = null;
        PreparedStatement prs2=null;
        PreparedStatement prs3=null;
        int ID_client=Integer.parseInt(""+text_field_ID.getText());
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            conne = DriverManager.getConnection(url, "root", "1 guy 2 code");

            prs2=conne.prepareStatement("DELETE FROM bookings WHERE customers_id="+ID_client+";");
            prs2.executeUpdate();

            prs3=conne.prepareStatement("DELETE FROM payments WHERE customers_id="+ID_client+";");
            prs3.executeUpdate();

            prs = conne.prepareStatement("DELETE  FROM customers WHERE customers_id="+ID_client+";");
            prs.executeUpdate();


            prs.close();
            conne.close();
        }catch(SQLException e)
        {
            //e.printStackTrace();
            JavaFXDialogs.informationDialog("Database modification not possible");
        }

        Show_check_out();
    }

//    @FXML
//    void execute_check_out(ActionEvent event) throws IOException, DocumentException //cette fonction permet de faire les factures d'un client une fois qu'on a clique sur 'Check_out'
//    {
//        java.util.Date debut_occupation3 = (Calendar.getInstance()).getTime();
//        LocalDate debut_occ3 = debut_occupation3.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        java.sql.Date Debut_occup3 = java.sql.Date.valueOf(debut_occ3);
//
//        Connection connect = null;
//        PreparedStatement pr1,pr2,pr3;
//        PreparedStatement ppcd=null;
//        Statement stt = null;
//        Statement stt1 = null;
//        ResultSet rst = null;
//        ResultSet rst1 = null;
//        int nomb=0;
//        java.sql.Date debut_resa = null;
//
//        String prenom = "";
//        int numero_telephone = 0;
//        String nationality = "";
//        String email = "";
//        double Price_per_Day = 0.0;
//        int numero_chambre = 0;
//        String type_chambre = "";
//        java.sql.Date check_IN_Date = null;
//        String bed = "";
//        int nbre_jour_stay = 0;
//        double total_amount=0.0;
//        String method_pay="";
//        String query2="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET rooms.rooms_status='non-occupe', customers.status='non-Occupant' WHERE customers_id="+Integer.parseInt(""+text_field_ID.getText())+";";
//        String query3="";
//        int ID_client = Integer.parseInt(""+text_field_ID.getText());
//        String query4="";
//        String nom = "";
//        //String query5="SELECT checkin FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE customers_id="+Integer.parseInt(""+text_field_ID.getText())+";";
//
//        //PreparedStatement ppcm=null;
//        String query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE customers_id="+ID_client+";";
//        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connect = getConnection();
//            stt = connect.createStatement();
//            //stt1=connect.createStatement();
//            rst=stt.executeQuery(query);
//            //rst1= stt1.executeQuery(query5);
//            ppcd=connect.prepareStatement(query2);
//
//
//            //ppcm=connect.prepareStatement("UPDATE customers SET status=null WHERE customers_id="+ID_client+";");
//            //rst = stt.executeQuery(query);
//
//            while (rst.next()) {
//                nom = rst.getString("firstName");
//                prenom = rst.getString("lastName");
//                numero_telephone = rst.getInt("phone");
//                nationality = rst.getString("country");
//                email = rst.getString("email");
//                numero_chambre = rst.getInt("rooms_number");
//                type_chambre = rst.getString("rooms_type");
//                bed = rst.getString("rooms_bedType");
//                Price_per_Day = rst.getDouble("rooms_pricePerNight");
//                check_IN_Date = rst.getDate("customers_regisTime");
//                //nbre_jour_stay = rst.getInt("number_of_day");
//                //total_amount=rst.getDouble("totalAmount");
//                method_pay=rst.getString("method");
//                debut_resa=rst.getDate("checkin");
//
//            }
//            query3="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET bookings.checkout='"+Debut_occup3+"', customers.status='non-Occupant' WHERE customers_id="+Integer.parseInt(""+text_field_ID.getText())+";";
//            pr1=connect.prepareStatement(query3);
//            pr1.executeUpdate();
//            if((debut_resa.toLocalDate()).isEqual(Debut_occup3.toLocalDate()))
//            {
//                query4="UPDATE ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) SET number_of_day= DATEDIFF('"+Debut_occup3+"','"+debut_resa+"'), totalAmount="+Price_per_Day+"* (DATEDIFF('"+Debut_occup3+"','"+debut_resa+"')),paid="+Price_per_Day+"* (DATEDIFF('"+Debut_occup3+"','"+debut_resa+"')) WHERE customers_id="+ID_client+";";
//
//            }
//
//            if(!((debut_resa.toLocalDate()).isEqual(Debut_occup3.toLocalDate())))
//            {
//                query4="UPDATE ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) SET number_of_day= DATEDIFF('"+Debut_occup3+"','"+debut_resa+"')+1, totalAmount="+Price_per_Day+"* (DATEDIFF('"+Debut_occup3+"','"+debut_resa+"')+1),paid="+Price_per_Day+"* (DATEDIFF('"+Debut_occup3+"','"+debut_resa+"')+1) WHERE customers_id="+ID_client+";";
//
//            }
//
//
//
//            pr2=connect.prepareStatement(query4);
//            pr2.executeUpdate();
//            Statement statement=connect.createStatement();
//            ResultSet RSt=statement.executeQuery(query);
//            while (RSt.next())
//            {
//                nbre_jour_stay = RSt.getInt("number_of_day");
//                total_amount=RSt.getDouble("totalAmount");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // JavaFXDialogs.exceptionDialog(e,"Impossible to access all the information in the database");
//        }
////        Document document = new Document();
////        try
////        {
////            PdfWriter.getInstance(document, new FileOutputStream("G:\\projet BD\\" + ID_client + ".pdf"));
////            document.open();
////            Image image = Image.getInstance("G:\\IntelliJ_IdeaProjects\\HotelManagementTrails\\src\\ressources\\image_logo_hotel.PNG");
////            image.setAbsolutePosition(250, 750);
////            document.add(image);
////            for (int i = 0; i <= 3; i++) {
////                document.add(new Paragraph("\n"));
////            }
////            Paragraph para1 = new Paragraph("****************************************************************************************************************");
////            document.add(para1);
////            //addEmtyLine(para, 7);
////            //para.setClip(250, 720);
////            //document.add(Chunk.NEWLINE);
////            Paragraph para2 = new Paragraph("\tBill ID: " + ID_client + "\nCustomer Details:\nFirst Name:" + nom + "\nLast Name: " + prenom + "\nMobile Number: " + numero_telephone + "\nNationality: " + nationality + "\nEmail: "+email+"\nRegistration Time: "+check_IN_Date+"");
////            document.add(para2);
////            document.add(para1);
////
////            Paragraph para3 = new Paragraph("\tRoom Details: \nNumber: " + numero_chambre + "\nRoomType: " + type_chambre + "\nBed: " + bed + "\nPrice per Day: " + Price_per_Day + "\npayments method: "+method_pay+"");
////            document.add(para3);
////            document.add(para1);
////
////            PdfPTable table = new PdfPTable(4);
////            table.addCell("Check IN Date: " + debut_resa + "");
////            table.addCell("Check OUT Date: " + Debut_occup3 + "");
////            table.addCell("No of Day(s) Stay: " + nbre_jour_stay + "");
////            table.addCell("Total Amount Paid: " + total_amount+ "");
////            document.add(table);
////            document.add(para1);
////            Paragraph para4 = new Paragraph("Thank You, Please Visit Again");
////            document.add(para4);
////            //ppcm.executeUpdate();
////            ppcd.executeUpdate();
////
////        }catch(Exception e)
////        {
////            //JavaFXDialogs.exceptionDialog(e,"an error occured");
////        }
////        document.close();
//        int a=JOptionPane.showConfirmDialog(null, "Do you Want to Print Bill", "SELECT",JOptionPane.YES_NO_OPTION);
//        if(a==0)
//        {
//            try
//            {
//                if((new File("G:\\projet BD\\"+ID_client+".pdf")).exists());
//                {
//                    Process p= Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler G:\\projet BD\\"+ID_client+".pdf");
//                }
//                if (!((new File("G:\\projet BD\\"+ID_client+".pdf")).exists()))
//                {
//                    JavaFXDialogs.informationDialog("File Is Not Exists");
//                }
//            }catch (Exception e)
//            {
//                //  JavaFXDialogs.exceptionDialog(e,"an error occured");
//            }
//        }
//
//    }



    @FXML
    void recherche_check_out(ActionEvent event) {
        ObservableList<Customer_end> liste4=FXCollections.observableArrayList();
        Connection connex=null;
        String query=null;
        Statement str=null;
        ResultSet Rstr=null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        PreparedStatement prs1=null;
        try {
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("first name")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE firstName='" + text_field_research.getText() + "' AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("last name")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE lastName='" + text_field_research.getText() + "' AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Mobile Number")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE phone=" + Integer.parseInt("" + text_field_research.getText()) + " AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Nationality")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE country='" + text_field_research.getText() + "' AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Gender")) {
                if (text_field_research.getText().equals("MAlE") || text_field_research.getText().equals("Male") | text_field_research.getText().equals("male") || text_field_research.getText().equals(" MAlE") || text_field_research.getText().equals(" Male")) {
                    query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE gender='Male' AND status='Occupant';";
                }
                if (text_field_research.getText().equals("Female") || text_field_research.getText().equals("female") || text_field_research.getText().equals("FEMALE") || text_field_research.getText().equals(" FEMALE") || text_field_research.getText().equals(" Female")) {
                    query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE gender='Female' AND status='Occupant';";
                }
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Email")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE email='" + text_field_research.getText() + "' AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Check in date")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE customers_regisTime='" + text_field_research.getText() + "' AND status='Occupant';";
            }
            //"Room Number", "Price per Day"
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Room Number")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE rooms_number=" + text_field_research.getText() + " AND status='Occupant';";
            }
            if (search_field_check_out.getSelectionModel().getSelectedItem().equals("Price per Day")) {
                query = "SELECT * FROM ((rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id))LEFT JOIN payments USING(customers_id) WHERE rooms_pricePerNight=" + text_field_research.getText() + " AND status='Occupant';";
            }
        }catch (Exception e)
        {
           // JavaFXDialogs.exceptionDialog(e,"check the item you want to search or the field you want to search");
            e.printStackTrace();
        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //JavaFXDialogs.exceptionDialog(e, "\nCheck the information you want to search");
        }
        try
        {
            connex=getConnection();
            str=connex.createStatement();
            Rstr=str.executeQuery(query);
            while(Rstr.next())
            {
                Customer_end rest=new Customer_end(Rstr.getInt("customers_id"), Rstr.getString("firstName"), Rstr.getString("lastName"), Rstr.getInt("phone"), Rstr.getString("country"), Rstr.getString("email"), Rstr.getString("gender"), Rstr.getDate("customers_regisTime"), Rstr.getInt("rooms_number"), Rstr.getDouble("rooms_pricePerNight"));
                liste4.add(rest);
            }

            table_view_check_in1.setItems(liste4);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void refresh_check_out (ActionEvent event)
    {

        Show_check_out();
    }


    //////ELEMENTS DE CHECK OUT
    public void setProfile(){
        pGenderCB.getItems().addAll("male","female");
        String query = "select receptionists_firstName,receptionists_lastName,receptionists_email,receptionists_sex,receptionists_dateOfBirth,receptionists_idCardNumber,receptionists_address from receptionists where receptionists_id ="+RecepId;
        ResultSet rs = Select.getData(query);
        try {
            if(rs.next()) {
                try {
                    pFirstNameTF.setText(rs.getString(1));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pLastNameTF.setText(rs.getString(2));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pEmailTF.setText(rs.getString(3));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pGenderCB.setValue(rs.getString(4));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pDateOfBirthDP.setValue(rs.getDate(5).toLocalDate());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pIDCardNoTF.setText(rs.getString(6));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    pAddressTF.setText(rs.getString(7));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        showClients(getClientList());
        text_field_id.setEditable(false);
        text_field_ID.setEditable(false);
        text_field_ID.setDisable(false);
        Show_check_out();
        try {
            combo_check_in.getItems().addAll("first name", "last name","Mobile Number", "Nationality", "Gender", "Email", "Check in date");
            gender.getItems().removeAll(gender.getItems());
            gender.getItems().addAll("Female", "Male");
            gender.getSelectionModel().select("SELECT THE GENDER");
            room_type.getSelectionModel().select("SELECT THE ROOM TYPE");
            room_type.getItems().addAll("Regular Room", "Family Room", "Deluxe Room");
            room_service.getItems().addAll("Card", "Cash");//"Check", "Bank Cards", "species"
            bed.getSelectionModel().select("SELECT THE BED TYPE");
            bed.getItems().addAll("Single", "Double", "King", "Queen");
            checkin.setEditable(false);
            //SimpleDateFormat myformat=new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat myformat=new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal= Calendar.getInstance();
            checkin.setText("         "+myformat.format(cal.getTime()));

            type_recherche.getItems().addAll("room number", "price per day", "phone", "status", "bed", "room type", "Max people");
            search_field_check_out.getItems().addAll("first name", "last name","Mobile Number", "Nationality", "Gender", "Email", "Check in date","Room Number", "Price per Day");
            compare.getItems().addAll("<",">","=","<=",">=");
            Show_client_reservator();
            Showchambre();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ObservableList<PlanningInP> getPlanningList() {
        ObservableList<PlanningInP> planningList = FXCollections.observableArrayList();
        String query = "SELECT plannings_id, month, start_day, end_day, start_hour, end_hour FROM plannings where receptionists_id ="+ RecepId;
        ResultSet rs;

        try {
            rs = Select.getData(query);
            PlanningInP planning;
            while (rs.next()) {
                planning = new PlanningInP(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                planningList.add(planning);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planningList;
    }

    public void showPlannings(ObservableList<PlanningInP> listPlannings) {
        ObservableList<PlanningInP> list = listPlannings;
        pIDCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, Integer>("planningId"));
        pMonthCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, String>("workMonth"));
        pStartDayCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, Integer>("startDay"));
        pEndDayCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, Integer>("endDay"));
        pStartHourCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, Integer>("startHour"));
        pEndHourCol.setCellValueFactory(new PropertyValueFactory<PlanningInP, Integer>("endHour"));
         tvPlanning.setItems(list);
    }

    ////////Elemts de ROOMS
    public Connection getConnection()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        Connection conne;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conne = DriverManager.getConnection(url, "root", "1 guy 2 code");
            return conne;
        }catch (Exception e)
        {
            //faut gerer exceptions
            return  null;
        }
    }

    public ObservableList<Chambre> getlistechambre()
    {
        ObservableList<Chambre> listechambre= FXCollections.observableArrayList();
        Connection cone=getConnection();
        Statement str=null;
        ResultSet rst=null;
        String query="SELECT * FROM rooms;";
        try {
            str= cone.createStatement();
            rst=str.executeQuery(query);
            Chambre cham;
            while(rst.next())
            {
                cham=new Chambre(rst.getInt("rooms_id"), rst.getInt("rooms_number"), rst.getDouble("rooms_pricePerNight"), rst.getInt("phone_rooms"), rst.getString("rooms_status"), rst.getString("rooms_bedType"),rst.getString("rooms_type"), rst.getInt("rooms_maxPersons"));
                listechambre.add(cham);
            }

            rst.close();
            str.close();
            cone.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listechambre;
    }

    public void Showchambre()
    {
        Connection con=null;
        Statement srt=null;
        Statement srt1=null;
        int i = 0;
        int j = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            con=getConnection();
            srt=con.createStatement();
            srt1=con.createStatement();
            ResultSet request=srt.executeQuery("SELECT * FROM rooms WHERE rooms_id IS NOT NULL;");
            ResultSet request1=srt1.executeQuery("SELECT * FROM rooms WHERE rooms_status !='non-occupe';");
            while(request.next())
            {
                i++;
            }
            while(request1.next())
            {
                j++;
            }
            total_chambre.setText(""+i);
            chambre_libre.setText(""+j);

            srt.close();
            srt1.close();
            request.close();
            request1.close();
            con.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        ObservableList<Chambre> list=getlistechambre();
        //col_ID_chambre.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("ID_chambres"));

        col_ID_chambre.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("ID_chambres"));
        col_num_chambre.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("room_number"));
        col_prix_chambre.setCellValueFactory(new PropertyValueFactory<Chambre, Double>("price_per_day"));
        col_phone_cham.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("phone"));
        col_status_cham.setCellValueFactory(new PropertyValueFactory<Chambre, String>("status"));
        col_bed_cham.setCellValueFactory(new PropertyValueFactory<Chambre, String>("bed"));
        col_type_cham.setCellValueFactory(new PropertyValueFactory<Chambre, String>("room_type"));
        col_max_people.setCellValueFactory(new PropertyValueFactory<Chambre, Integer>("Max_people"));

        chambre.setItems(list);

    }

    ///Elements de ROOMS

    ///Elements de Check in
    public ObservableList<Reservator> getlistecheck_in()
    {
        ObservableList<Reservator> liste_chech_in= FXCollections.observableArrayList();
        Connection cone1=getConnection();
        Statement str1=null;
        ResultSet rst1=null;
        String query="SELECT * FROM customers WHERE status= 'Reservator';";
        //String query="SELECT * FROM client WHERE status is null;";
        try {
            str1= cone1.createStatement();
            rst1=str1.executeQuery(query);
            Reservator client_reservator;
            while(rst1.next())
            {
                client_reservator=new Reservator(rst1.getInt("customers_id"), rst1.getString("firstName"), rst1.getString("lastName"), rst1.getInt("phone"), rst1.getString("country"), rst1.getString("gender"),rst1.getString("email"), rst1.getDate("customers_regisTime"));
                liste_chech_in.add(client_reservator);
            }

            rst1.close();
            str1.close();
            cone1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste_chech_in;
    }

    public void Show_client_reservator()
    {
        ObservableList<Reservator> list_client_res=getlistecheck_in();

        col_ID_client_reservator.setCellValueFactory(new PropertyValueFactory<Reservator, Integer>("ID_client"));
        col_name1.setCellValueFactory(new PropertyValueFactory<Reservator, String>("nom"));
        col_name2.setCellValueFactory(new PropertyValueFactory<Reservator, String>("prenom"));
        col_phone_client.setCellValueFactory(new PropertyValueFactory<Reservator, Integer>("numero_telephone"));
        col_nationality.setCellValueFactory(new PropertyValueFactory<Reservator, String>("nationality"));
        col_gender.setCellValueFactory(new PropertyValueFactory<Reservator, String>("gender"));
        col_email.setCellValueFactory(new PropertyValueFactory<Reservator, String>("email"));
        col_check_in.setCellValueFactory(new PropertyValueFactory<Reservator, java.sql.Date>("Check_in_date"));

        table_view_check_in.setItems(list_client_res);

    }

    ///Elements de Check in

    ///ELEMENTS DE CHECK OUT
    public ObservableList<Customer_end> getNonOccupant()
    {
        ObservableList<Customer_end> liste3=FXCollections.observableArrayList();
        Connection cone1=getConnection();
        Statement str1=null;
        ResultSet rst1=null;
        //UPDATE (chambre LEFT JOIN reservation USING(ID_chambre))LEFT JOIN client USING(ID_client) SET chambre.status='occupe', client.status='Occupant' WHERE debut_reservation='2021/05/14';
        String query="SELECT * FROM (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) WHERE customers.status='Occupant';";
        //String query="SELECT * FROM  WHERE status is null;";
        try {
            str1= cone1.createStatement();
            rst1=str1.executeQuery(query);
            Customer_end cuto=null;
            while(rst1.next())
            {
                cuto=new Customer_end(rst1.getInt("customers_id"), rst1.getString("firstName"), rst1.getString("lastName"), rst1.getInt("phone"), rst1.getString("country"), rst1.getString("gender"),rst1.getString("email"), rst1.getDate("customers_regisTime"),rst1.getInt("rooms_number"),rst1.getDouble("rooms_pricePerNight"));
                liste3.add(cuto);
            }

            rst1.close();
            str1.close();
            cone1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return liste3;
    }

    public void Show_check_out()
    {
        ObservableList<Customer_end> list3=getNonOccupant();

        col_ID_client_reservator2.setCellValueFactory(new PropertyValueFactory<Customer_end, Integer>("ID_client"));
        col_name21.setCellValueFactory(new PropertyValueFactory<Customer_end, String>("nom"));
        col_name3.setCellValueFactory(new PropertyValueFactory<Customer_end, String>("prenom"));
        col_phone_client2.setCellValueFactory(new PropertyValueFactory<Customer_end, Integer>("numero_telephone"));
        col_nationality2.setCellValueFactory(new PropertyValueFactory<Customer_end, String>("nationality"));
        col_gender2.setCellValueFactory(new PropertyValueFactory<Customer_end, String>("gender"));
        col_email2.setCellValueFactory(new PropertyValueFactory<Customer_end, String>("email"));
        col_check_in2.setCellValueFactory(new PropertyValueFactory<Customer_end, java.sql.Date>("Check_in_date"));
        room_number2.setCellValueFactory(new PropertyValueFactory<Customer_end, Integer>("room_number"));
        Price_per_Day2.setCellValueFactory(new PropertyValueFactory<Customer_end, Double>("Price_per_Day"));

        table_view_check_in1.setItems(list3);
    }
    ///ELEMENTS DE CHECK OUT
    @FXML
    private void pUpdateBtnClicked() {
        int success = 0;
        int Number;
        if (!(pFirstNameTF.getText() == null || pFirstNameTF.getText().trim().isEmpty())) {
            try {
                 String query = "update receptionists set receptionists_firstName ='" + pFirstNameTF.getText() + "' where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for first name");
            }
        }
        if (!(pLastNameTF.getText() == null || pLastNameTF.getText().trim().isEmpty())) {
            try {
                String query = "update receptionists set receptionists_lastName ='" + pLastNameTF.getText() + "' where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for last name");
            }
        }
        if (!(pEmailTF.getText() == null || pEmailTF.getText().trim().isEmpty())) {
            try {
                String query = "update receptionists set receptionists_email ='" + pEmailTF.getText() + "' where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for email");
            }
        }
        String query = "update receptionists set receptionists_sex ='" +pGenderCB.getSelectionModel().getSelectedItem() + "' where receptionists_id = " + RecepId;
        InsertUpdateDelete.runQuery(query, "");
        success++;
        if (!(pDateOfBirthDP.getValue() == null)) {
            try {
                LocalDate localDate = pDateOfBirthDP.getValue();
                Date sqlDate = Date.valueOf(localDate);
                query = "update receptionists set receptionists_dateOfBirth ='" +sqlDate+ "' where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for date of birth");
            }
        }
        if (!(pIDCardNoTF.getText() == null | pIDCardNoTF.getText().trim().isEmpty())) {
            try {
                Number = Integer.parseInt(pIDCardNoTF.getText().trim());
                query = "update receptionists set receptionists_idCardNumber =" +Number+ " where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for id card number");
            }
        }
        if (!(pAddressTF.getText() == null || pAddressTF.getText().trim().isEmpty())) {
            try {
                query = "update receptionists set receptionists_address ='" + pAddressTF.getText() + "' where receptionists_id = " + RecepId;
                InsertUpdateDelete.runQuery(query, "");
                success++;
            } catch (Exception e) {
                utilitiesPac.JavaFXDialogs.exceptionDialog(e, "Entry not valid for last name");
            }
        }
        if (success > 0)
            utilitiesPac.JavaFXDialogs.informationDialog("Successful Update");
        showPlannings(getPlanningList());
    }

}

