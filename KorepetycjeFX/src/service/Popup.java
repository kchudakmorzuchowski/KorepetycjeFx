package service;

import javafx.scene.control.Alert;

public class Popup {

    public Popup(Alert.AlertType a, String title, String header, String content){
        Alert alert = new Alert(a);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();

    }
}
