package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class JavaFXDialogs {
    static Alert alert;
    public static void setAlert(Alert alert) {
        DialogPane dialogPane = alert.getDialogPane();
        Stage stage =(Stage)dialogPane.getScene().getWindow();
        dialogPane.getStylesheets().add(JavaFXDialogs.class.getResource("../cssPac/styles.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");

    }
/*

    public static void exceptionDialog(Exception ex, String msg){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("An Exception occurred");
        alert.setContentText(msg);

// Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);
        setAlert(alert);
        alert.showAndWait();

    }
*/

    public static void informationDialog(String msg){
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        setAlert(alert);

        alert.showAndWait();

    }

    public static void errorDialog(String msg){
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        setAlert(alert);
        alert.showAndWait();
    }

    public static Optional<ButtonType> confirmationDialog(String msg){
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you wish to perform this action?");
        alert.setContentText(msg);
        setAlert(alert);
        return alert.showAndWait();

        /*Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }*/
    }
}
