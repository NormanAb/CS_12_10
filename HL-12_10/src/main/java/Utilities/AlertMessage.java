package Utilities;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertMessage {
    public static void showAlert(String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        switch(type) {
            case "incorrect data":
                alert.setTitle("Error");
                alert.setHeaderText("Make sure your file is correct!");
                Optional<ButtonType> result = alert.showAndWait();
            case "file missing":
                alert.setTitle("Warning");
                alert.setHeaderText("You have not selected a file!");
        }

    }
}
