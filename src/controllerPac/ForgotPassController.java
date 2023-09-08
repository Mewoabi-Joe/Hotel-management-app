package controllerPac;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utilitiesPac.InsertUpdateDelete;
import utilitiesPac.JavaFXDialogs;
import utilitiesPac.Select;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;

public class ForgotPassController implements Initializable{
    private int numberOfClicks;
    private boolean emailExist;
    private boolean emailMatches;
    private ResultSet rs;
    private String email;
    @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXTextField newPassTF;
    @FXML
    private JFXTextField answerTF;
    @FXML
    private JFXTextField securityQuessTF;
    @FXML
    private JFXButton proceedBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        securityQuessTF.setDisable(true);
        newPassTF.setDisable(true);
        answerTF.setDisable(true);
    }

    public void loginBtn(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../fxmlPac/main.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    @FXML
    void ProceedBtnClicked(ActionEvent event) {
        numberOfClicks++;
        if (!emailExist) {
            email = emailTF.getText();
            if (email.equals("")) {
                JavaFXDialogs.errorDialog("email is required");
            } else {
                rs = Select.getData("select * from receptionists where receptionists_email = '" + email + "'");
                try {
                    if (rs.next()) {
                        emailExist = true;
                        securityQuessTF.setDisable(false);
                        securityQuessTF.setText(rs.getString("receptionists_securityQuestion"));
                        emailTF.setEditable(false);
                        securityQuessTF.setEditable(false);
                        answerTF.setDisable(false);
                    } else
                        JavaFXDialogs.errorDialog("Email does not exist");
                } catch (Exception e) {
                    JavaFXDialogs.exceptionDialog(e, "Error occured while trying to get email");
                }
            }
        }
        else if(answerTF.getText().length()==0 && emailExist && !emailMatches){
            JavaFXDialogs.errorDialog("Enter an answer");
        }
        else if(answerTF.getText().length()>0 && emailExist && !emailMatches){
            String answer = answerTF.getText();
            try{
                if(answerTF.getText().length()==0)
                    JavaFXDialogs.errorDialog("you provided no answer");
                else if (answer.equals(rs.getString("receptionists_answer"))){
                    emailMatches = true;
                    answerTF.setEditable(false);
                    newPassTF.setDisable(false);
                    proceedBtn.setText("Save");
                }else{
                    JavaFXDialogs.errorDialog("Wrong answer");
                }
            }catch (Exception e){
                JavaFXDialogs.exceptionDialog(e,"Error occured while trying to get answer from result set");
            }
        }
        else if (newPassTF.getText().length() >0 ){
            String newPass = newPassTF.getText();
            try{
                String query = "UPDATE receptionists SET receptionists_password = '"+newPass+"' WHERE receptionists_email = '"+email+"'";
                InsertUpdateDelete.runQuery(query,"password successfully modified");
            }catch (Exception e){
                JavaFXDialogs.exceptionDialog(e,"Error occurred while trying to modify password from query");
            }
        }
        else
            JavaFXDialogs.errorDialog("A password needs to be set");
    }

    public void minimiseImageClicked(MouseEvent e){
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setIconified(true);
    }

    public void closeImageClicked(MouseEvent event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Do you really want to exit?");
        if (result.get() == ButtonType.OK) {
            window.close();
        }
    }

}
