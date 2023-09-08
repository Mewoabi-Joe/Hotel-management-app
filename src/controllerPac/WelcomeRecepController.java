package controllerPac;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utilitiesPac.ConnectionProvider;
import utilitiesPac.JavaFXDialogs;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.sql.DriverManager.getConnection;

public class WelcomeRecepController implements Initializable {

    @FXML
    private Label recepName;

    @FXML
    private Label infoLabel;

    private int id;
    private String firstName;

    public void setUser(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
        recepName.setText(firstName);
    }

    public void minimiseImageClicked(MouseEvent e){
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setIconified(true);
    }

    @FXML
    public void closeImageClicked(MouseEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Do you really want to exit?");
        if (result.get() == ButtonType.OK){
            window.close();
        }
    }

    @FXML
    public void nextClicked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmlPac/receptionistFXML.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        ReceptionistController rcon = fxmlLoader.<ReceptionistController>getController();
        rcon.setUserId(id);
                   /* ReceptionistController rcon = fxmlLoader.<ReceptionistController>getController();
                    rcon.setUserId(rs.getInt(1));*/
        Scene loginScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();;
    }

    public void recherche_hotel()//cette fonction recherche les chambres dont la date d'occupation est arrive a terme et change leur status
    {
        java.util.Date debut_occupation = (Calendar.getInstance()).getTime();
        LocalDate debut_occ = debut_occupation.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        java.sql.Date Debut_occup = java.sql.Date.valueOf(debut_occ);

        Connection connection=null;
        //String query1="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET rooms.rooms_status='occupe', customers.status='Occupant' WHERE checkin='"+Debut_occup+"';";
        //String query2="UPDATE (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id) SET rooms.rooms_status='non-occupe', customers.status='non-Occupant' WHERE checkout>'"+Debut_occup+"';";
        String query3="SELECT * FROM (rooms LEFT JOIN bookings USING(rooms_id))LEFT JOIN customers USING(customers_id)  WHERE checkout<'"+Debut_occup+"' AND (customers.status !='non-Occupant' OR customers.status IS NULL);";
        String url = "jdbc:mysql://127.0.0.1:3306/hotelprojetbd?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false";
        PreparedStatement prs1=null;
        PreparedStatement prs2=null;
        Statement sd=null;
        String non_Occupant="";
        String str="";
        ArrayList<String> liste_non_Occupant = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try
        {
            connection= ConnectionProvider.getCon();
            //prs1=connection.prepareStatement(query1);
            //prs2=connection.prepareStatement(query2);
            sd=connection.createStatement();
            //prs2.executeUpdate();
            //prs1.executeUpdate();
            ResultSet rsd= sd.executeQuery(query3);

            liste_non_Occupant.add("The following Clients have Completed their stays\n");
            while(rsd.next())
            {
                non_Occupant="\nsir/Mrs "+rsd.getString("firstName")+" "+rsd.getString("lastName")+"     ID: "+rsd.getInt("customers_id")+"";
                liste_non_Occupant.add(non_Occupant);
            }

            for(int j=0;j<=liste_non_Occupant.size()-1;j++)
            {
                //JavaFXDialogs.informationDialog(liste_non_Occupant.get(j));
                str= str+" "+liste_non_Occupant.get(j);
            }
            infoLabel.setText(str);
            liste_non_Occupant.clear();

            //prs1.close();

            //prs2.close();
            connection.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recherche_hotel();
     }
}
