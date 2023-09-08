package controllerPac;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import utilitiesPac.InsertUpdateDelete;
import utilitiesPac.JavaFXDialogs;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private JFXTextField firstNameTF;
     @FXML
    private JFXTextField lastNameTF;
     @FXML
    private JFXTextField emailTF;
    @FXML
    private JFXTextField answerTF;
    @FXML
    private JFXPasswordField passwordPassF;
    @FXML
    private JFXComboBox<String> securityQuesCB;
    @FXML
    private JFXRadioButton maleRB;
     @FXML
    private JFXRadioButton femaleRB;
     @FXML
    private JFXDatePicker dateOfBirthDP;
     @FXML
    private JFXTextField idCardNoTF;
     @FXML
    private JFXTextField addressTF;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        securityQuesCB.getItems().addAll("The of your first pet?","The name of your fist car?","Name of elementary school?","Town where you where born?");

    }

    public void signUpButtonClicked(){
        String firstName = firstNameTF.getText();
        String lastName = lastNameTF.getText();
        String password = passwordPassF.getText();
        String email = emailTF.getText();
        String answer = answerTF.getText();
        String idCardNo = idCardNoTF.getText();
        String address = addressTF.getText();
        String securityQues = securityQuesCB.getSelectionModel().getSelectedItem();
         if(firstName.equals("")|lastName.equals("")|password.equals("")|email.equals("")|answer.equals("")|idCardNo.equals("")|address.equals("")|((TextField)dateOfBirthDP.getEditor()).getText().equals("")){
            JavaFXDialogs.errorDialog("Information in all fields is required");
        }else{
            int intIdCardNo = 0;
            try{
               intIdCardNo = Integer.parseInt(idCardNo);
            }catch (NumberFormatException ex) {
                JavaFXDialogs.exceptionDialog(ex, "Invalid entry for id Card number");
            }
            LocalDate localDate = dateOfBirthDP.getValue();
            Date dateOfBirth = Date.valueOf(localDate);
            String sex;
            if(maleRB.isSelected())
                sex = "male";
            else
                sex = "female";
            String query;
            query ="insert into receptionists(receptionists_firstName,receptionists_lastName,receptionists_email,receptionists_password,receptionists_sex,receptionists_dateOfBirth,receptionists_idCardNumber,receptionists_address,receptionists_securityQuestion,receptionists_answer) values('"+firstName+"','"+lastName+"','"+email+"','"+password+"','"+sex+"','"+dateOfBirth+"','"+intIdCardNo+"','"+address+"','"+securityQues+"','"+answer+"')";
            InsertUpdateDelete.runQuery(query,"You have been successfully registered");
        }

    }
}
