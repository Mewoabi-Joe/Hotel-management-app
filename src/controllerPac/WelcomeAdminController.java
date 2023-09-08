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
import utilitiesPac.JavaFXDialogs;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class WelcomeAdminController implements Initializable {

    @FXML
    private Label adminName;

    private int id;
    private String firstName;

    public void setUser(int id, String firstName){
        this.id = id;
        this.firstName = firstName;
        adminName.setText(firstName);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        Parent loginParent = FXMLLoader.load(getClass().getResource("../fxmlPac/adminFXML.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

}
