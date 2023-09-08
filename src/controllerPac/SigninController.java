package controllerPac;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitiesPac.JavaFXDialogs;
import utilitiesPac.Select;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SigninController implements Initializable {
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXPasswordField passwordPassF;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void loginButtonClicked(ActionEvent event) throws IOException, SQLException {
        String email = emailTF.getText();
        String password = passwordPassF.getText();
        //Test for emptiness: email==null|email.trim().isEmpty()||password==null|password.trim().isEmpty()
        ResultSet rs = Select.getData("select A_id, A_fName from admins where A_email ='"+email.trim()+"' and A_password='"+password.trim()+"'");
        if(email==null|email.trim().isEmpty()||password==null|password.trim().isEmpty()){
            JavaFXDialogs.errorDialog("Every field is required");
        }else if (rs.next()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmlPac/welcomeAdminFXML.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            WelcomeAdminController rcon = fxmlLoader.<WelcomeAdminController>getController();
            rcon.setUser(rs.getInt(1),rs.getString(2));
                   /* ReceptionistController rcon = fxmlLoader.<ReceptionistController>getController();
                    rcon.setUserId(rs.getInt(1));*/
            Scene loginScene = new Scene(root);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(loginScene);
            window.show();
        }else{
             rs = Select.getData("select receptionists_id,receptionists_firstName from receptionists where receptionists_email ='"+email.trim()+"' and receptionists_password='"+password.trim()+"'");
            try{
                if(rs.next()){
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmlPac/welcomeRecepFXML.fxml"));
                    Parent root = (Parent)fxmlLoader.load();
                    WelcomeRecepController rcon = fxmlLoader.<WelcomeRecepController>getController();
                    rcon.setUser(rs.getInt(1),rs.getString(2));
                   /* ReceptionistController rcon = fxmlLoader.<ReceptionistController>getController();
                    rcon.setUserId(rs.getInt(1));*/
                    Scene loginScene = new Scene(root);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(loginScene);
                    window.show();

                        /**/
                        /**/

                }else{
                    JavaFXDialogs.informationDialog("User does not exist you can signUp");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void passwordForgottenButtonClicked(ActionEvent event) throws IOException {
        Parent sceneParent = FXMLLoader.load(getClass().getResource("../fxmlPac/forgotPassFXML.fxml"));
        Scene newScene = new Scene(sceneParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);window.show();
    }
}
