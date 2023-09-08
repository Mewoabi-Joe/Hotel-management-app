package controllerPac;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainImageController implements Initializable {
    @FXML
    private JFXButton exitBtn;
     @FXML
    private JFXButton closeBtn;
     @FXML
    private JFXButton logoutBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView image;



    @FXML
    private HBox myHbox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void closeClicked(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        loadDialog(window);
       // window.close();
    }

    public void loadDialog(Stage window){

        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("Sample Dialog"));
        content.setBody(image,new Text("fsdf fsfsdfsd dffsfsdf fsf dsfsdf sff  fsfsf fsdfsf dfdf s fsfsf sdfsf sdfs dfs sf f sf fsfsdf dfsdff fs f    "));
        JFXButton button = new JFXButton("Yes");
        JFXButton button2 = new JFXButton("No");
         JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialog.close();
            }
        });
        content.setActions(button,button2);
        dialog.show();
    }


}