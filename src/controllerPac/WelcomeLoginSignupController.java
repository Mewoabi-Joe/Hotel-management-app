package controllerPac;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utilitiesPac.JavaFXDialogs;

import java.io.IOException;
import java.util.Optional;

public class WelcomeLoginSignupController {

    public void minimiseImageClicked(MouseEvent e){
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setIconified(true);
    }

    public void closeImageClicked(MouseEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Optional<ButtonType> result = JavaFXDialogs.confirmationDialog("Do you really want to exit?");
        if (result.get() == ButtonType.OK){
            window.close();
        }
    }

    public void nextClicked(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../fxmlPac/main.fxml"));
        Scene loginScene = new Scene(loginParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

}
