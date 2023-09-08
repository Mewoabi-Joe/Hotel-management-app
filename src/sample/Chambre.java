package sample;

import javafx.scene.control.ComboBox;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Chambre {
    private int ID_chambres;
    private int room_number;
    private  double price_per_day;
    private  int phone;
    private  String status;
    private  String bed;
    private String room_type;
    private int Max_people;


    public Chambre(int ID_chambres, int room_number, double price_per_day, int phone, String status, String bed, String room_type, int max_people) {
        this.ID_chambres = ID_chambres;
        this.room_number = room_number;
        this.price_per_day = price_per_day;
        this.phone = phone;
        this.status = status;
        this.bed = bed;
        this.room_type = room_type;
        Max_people = max_people;
    }

    public int getID_chambres() {
        return ID_chambres;
    }

    public int getRoom_number() {
        return room_number;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public int getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getBed() {
        return bed;
    }

    public String getRoom_type() {
        return room_type;
    }

    public int getMax_people() {
        return Max_people;
    }
}
