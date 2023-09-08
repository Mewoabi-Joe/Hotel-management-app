package controllerPac;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import utilitiesPac.JavaFXDialogs;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private VBox vBox;
    @FXML
    private AnchorPane anchorPane;
    private Parent fxml;
    @FXML
    private VBox mainSmallLeftVBox;
    boolean value = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        mainSmallLeftVBox.setVisible(false);
       try {
            fxml = FXMLLoader.load(getClass().getResource("../fxmlPac/signinFXML.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        vBox.getChildren().removeAll();
        vBox.getChildren().setAll(fxml);
    }

    public void rightBtnClicked(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1),vBox);
        t.setToX(200);
        t.play();
        t.setOnFinished(e->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("../fxmlPac/signupFXML.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            vBox.getChildren().removeAll();
            vBox.getChildren().setAll(fxml);
        });
     }

    public void leftButtonClicked(ActionEvent event){
        TranslateTransition t = new TranslateTransition(Duration.seconds(1),vBox);
        t.setToX(0);
        t.play();
        t.setOnFinished(e->{
            try {
                fxml = FXMLLoader.load(getClass().getResource("../fxmlPac/signinFXML.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            vBox.getChildren().removeAll();
            vBox.getChildren().setAll(fxml);
        });
    }

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



}
