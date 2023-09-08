package controllerPac;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxmlPac/welcomeFXML.fxml")); //../fxmPac/main.fxml
        primaryStage.setTitle("Joe's Hotel Manager");
        Scene scene = new Scene(root);
       /* String cssURL = "styles.css";
        String css = this.getClass().getResource(cssURL).toExternalForm();
        scene.getStylesheets().add(css);*/
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
