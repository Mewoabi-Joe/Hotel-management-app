package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Date debut_reservation;
    private Date fin_reservation;
    private int nombre_adults;
    private int nombre_enfants;
    private int Room_number;
    private int idReceptionist;


    public Reservation(Date debut_reservatio, Date fin_reservatio, int nombre_adult, int nombre_enfant, int a, int idReceptionist) {
        this.debut_reservation = debut_reservatio;
        this.fin_reservation = fin_reservatio;
        this.nombre_adults = nombre_adult;
        this.nombre_enfants = nombre_enfant;
        this.Room_number=a;
        this.idReceptionist = idReceptionist;
    }

    public void ajouterReservation1() throws SQLException {
        //int cle=
        Connection connex = null;
        PreparedStatement ps = null;
        PreparedStatement ps2=null;
        Statement stt1=null;
        Statement stt2=null;
        //PreparedStatement pst=null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";

        int ID_client=0;
        int ID_chambre=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //sql="YOUR INSERT STATEMENT HERE";
            connex = DriverManager.getConnection(url, "root", "1 guy 2 code");
            //ps=con.prepareStatement("INSERT INTO chambre (bed, telephone_chambre, room_type, room_number, price_per_day, status) VALUES (?,?,?,?,?); ")

            //stt=connex.prepareStatement(sql.Statement.RETURN_GENERATED_KEYS);
            //stt.execute();
            //ResultSet resultSet= stt.getGeneratedKeys();
            //if(resultSet.next())
            //{
             //   ID_client=resultSet.getInt(1);
           // }
            stt1= connex.createStatement();
            // stt2= connex.createStatement();
            ResultSet RS= stt1.executeQuery("SELECT customers_id FROM customers ORDER BY customers_id DESC LIMIT 1");
            while(RS.next())
            {
               ID_client=RS.getInt("customers_id");
            }

            stt2= connex.createStatement();
            ResultSet RS1= stt2.executeQuery("SELECT rooms_id FROM rooms WHERE rooms_number="+this.Room_number+";");
            while(RS1.next())
            {
               ID_chambre=RS1.getInt("rooms_id");
            }

            ps = connex.prepareStatement("INSERT INTO bookings(numberOfAdults, numberOfChildren, customers_id, rooms_id, checkin, checkout, receptionists_id)VALUES ("+this.nombre_adults+","+this.nombre_enfants+","+ID_client+","+ID_chambre+",'"+ this.debut_reservation+"','"+ this.fin_reservation+"',"+idReceptionist+");");
            ps.executeUpdate();




            ps2=connex.prepareStatement("UPDATE customers SET status='Occupant' where customers_id="+ID_client+";");
            ps2.executeUpdate();





            RS.close();
            stt2.close();
            RS1.close();
            ps2.close();

            ps.close();
            connex.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterReservation2() throws SQLException //cette fonction est appelee lors d'une reservation
    {
        Connection connex = null;
        PreparedStatement ps = null;
        PreparedStatement ps2=null;
        Statement stt1=null;
        Statement stt2=null;
        //PreparedStatement pst=null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";

        int ID_client=0;
        int ID_chambre=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //sql="YOUR INSERT STATEMENT HERE";
            connex = DriverManager.getConnection(url, "root", "1 guy 2 code");
            //ps=con.prepareStatement("INSERT INTO chambre (bed, telephone_chambre, room_type, room_number, price_per_day, status) VALUES (?,?,?,?,?); ")

            //stt=connex.prepareStatement(sql.Statement.RETURN_GENERATED_KEYS);
            //stt.execute();
            //ResultSet resultSet= stt.getGeneratedKeys();
            //if(resultSet.next())
            //{
            //   ID_client=resultSet.getInt(1);
            // }
            stt1= connex.createStatement();
            // stt2= connex.createStatement();
            ResultSet RS= stt1.executeQuery("SELECT customers_id FROM customers ORDER BY customers_id DESC LIMIT 1;");
            while(RS.next())
            {
                ID_client=RS.getInt("customers_id");
            }

            stt2= connex.createStatement();
            ResultSet RS1= stt2.executeQuery("SELECT rooms_id FROM rooms WHERE rooms_number="+this.Room_number+";");
            while(RS1.next())
            {
                ID_chambre=RS1.getInt("rooms_id");
            }

            ps = connex.prepareStatement("INSERT INTO bookings(numberOfAdults, numberOfChildren, customers_id, rooms_id, checkin, checkout, receptionists_id)VALUES ("+this.nombre_adults+","+this.nombre_enfants+","+ID_client+","+ID_chambre+",'"+ this.debut_reservation+"','"+ this.fin_reservation+"',"+idReceptionist+");");
            ps.executeUpdate();




            ps2=connex.prepareStatement("UPDATE customers SET status='Reservator' where customers_id="+ID_client+";");
            ps2.executeUpdate();





            RS.close();
            stt2.close();
            RS1.close();
            ps2.close();

            ps.close();
            connex.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    }
