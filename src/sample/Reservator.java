package sample;

import java.sql.Date;

public class Reservator {

    private  int ID_client;
    private  String nom;
    private  String prenom;
    private  int numero_telephone;
    private  String nationality;
    private  String gender;
    private String email;
    private  Date Check_in_date;


    public Reservator(int ID_client, String nom, String prenom, int numero_telephone, String nationality, String gender, String email, Date check_in_date) {
        this.ID_client = ID_client;
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.nationality = nationality;
        this.gender = gender;
        this.email = email;
        Check_in_date = check_in_date;
    }

    public Reservator(String nom, String prenom, int numero_telephone, String nationality, String gender, String email, Date check_in_date) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_telephone = numero_telephone;
        this.nationality = nationality;
        this.gender = gender;
        this.email = email;
        Check_in_date = check_in_date;
    }

    public int getID_client() {
        return ID_client;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumero_telephone() {
        return numero_telephone;
    }

    public String getNationality() {
        return nationality;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Date getCheck_in_date() {
        return Check_in_date;
    }
}
