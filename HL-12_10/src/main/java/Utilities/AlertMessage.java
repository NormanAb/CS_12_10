package Utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertMessage {
    public static void showAlert(String type) {
        Alert alert;

        switch(type) {
            case "incorrect data":
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Make sure your file is correct!");
                break;
            case "file missing":
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("You have not selected a file!");
                break;
            case "no algorithm":
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("An error occurred with the algorithm. Please check that you have selected an algorithm.");
                break;
            case "no data":
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No data was found. Please verify that the file is correct and has information in it");
                break;
            default:
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Info");
                alert.setHeaderText("Unknown message type.");
                break;
        }

        // Show the alert
        alert.showAndWait();
    }
}