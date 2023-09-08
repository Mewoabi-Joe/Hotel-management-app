package sample;

import java.sql.*;

public class Client {
    private int ID_client;
    private String nom;
    private String prenom;
    private int numero_telephone;
    private String nationality;
    private String gender;
    private String email;
    private Date Check_in_date;
    private String address;
    private int number_of_day;
    private String room_service;
    private int room_number;
   // private  String status;

    public Client(String nom, String prenom,int numero_telephone, String nationality, String gender, String email,  String address,Date check_in_date, int number_of_day, String room_service, int room_number) {

        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.nationality = nationality;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.Check_in_date = check_in_date;
        this.number_of_day = number_of_day;
        this.room_service = room_service;
        this.room_number = room_number;
    }

    public Client(int ID_client, String nom, String prenom, int numero_telephone, String nationality, String gender, String email, Date check_in_date) {
        this.ID_client = ID_client;
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.nationality = nationality;
        this.gender = gender;
        this.email = email;
        this.Check_in_date = check_in_date;
     //   this.status=sat;
    }


    public void ajouterclient()  {
        Connection connextio = null;
        PreparedStatement ps = null;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //String rep="OK";
            connextio = DriverManager.getConnection(url, "root", "1 guy 2 code");
            //ps=con.prepareStatement("INSERT INTO chambre (bed, telephone_chambre, room_type, room_number, price_per_day, status) VALUES (?,?,?,?,?); ")
            ps = connextio.prepareStatement("INSERT INTO customers (firstName, lastName, phone, country, gender, email, address, customers_regisTime, number_of_day)VALUES ('"+this.nom+"','"+this.prenom+"',"+this.numero_telephone+",'"+this.nationality+"','"+this.gender+"','"+this.email+"','"+this.address+"','"+this.Check_in_date+"',"+this.number_of_day+");");

            ps.executeUpdate();


            ps.close();
            connextio.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    public void supprimerclient() throws SQLException {
        Connection conne = null;
        PreparedStatement prs = null;
        PreparedStatement prs2=null;
        PreparedStatement prs3=null;
        Statement s=null;
        int ID_client=0;
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        PreparedStatement prs1=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            conne = DriverManager.getConnection(url, "root", "1 guy 2 code");

             s= conne.createStatement();
            ResultSet R= s.executeQuery("SELECT customers_id FROM customers WHERE firstName ='"+this.nom+"' ORDER BY customers_id DESC LIMIT 1 ;");
            while(R.next())
            {
                ID_client=R.getInt(1);
            }
            prs2=conne.prepareStatement("DELETE FROM bookings WHERE customers_id="+ID_client+";");
            prs2.executeUpdate();

            prs3=conne.prepareStatement("DELETE FROM payments WHERE customers_id="+ID_client+";");
            prs3.executeUpdate();

            prs = conne.prepareStatement("DELETE  FROM customers WHERE customers_id="+ID_client+";");
            prs.executeUpdate();


            prs1 =conne.prepareStatement("UPDATE rooms SET rooms_status='non-occupe' WHERE rooms_number="+this.room_number+";");
            prs1.executeUpdate();



        prs1.close();
            prs.close();
            conne.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

    }
    }



