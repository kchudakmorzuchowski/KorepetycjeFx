package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.DBConnector;
import service.Popup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserController {

    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private String permission = "role_admin";
    private boolean active = true;

    @FXML
    private TextField tf_login_au;

    @FXML
    private PasswordField pf_password_au;

    @FXML
    private PasswordField pf_password_confirm_au;

    @FXML
    void addAdmin(ActionEvent event) throws IOException, SQLException {
        if(pf_password_au.getText().equals(pf_password_confirm_au.getText())) {
            if (tf_login_au.getText() != null && pf_password_au != null && pf_password_confirm_au != null ) {
                ps = conn.prepareStatement("insert into users (login, password, permission, active) values (?, ?, ?, ?)");
                ps.setString(1, tf_login_au.getText());
                ps.setString(2, pf_password_au.getText());
                ps.setString(3, permission);
                ps.setBoolean(4, active);
                ps.executeUpdate();
                Popup alert = new Popup(Alert.AlertType.INFORMATION, "Informacja", "Dodadno nowego admina",tf_login_au.getText());
                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setTitle("Panel administratora");
                adminStage.setScene(new Scene(root));
                adminStage.show();
                Stage primary = (Stage) tf_login_au.getScene().getWindow();
                primary.close();
            } else {
                Popup alert = new Popup(Alert.AlertType.ERROR, "Błąd", "Wystąpił bład przy wprowadzaniu danych.", "Wszystkie wymagane pola nie zostały wypełnione.");
            }
        }
        else {
            Popup alert = new Popup(Alert.AlertType.ERROR, "Błąd", "Wystąpił bład przy wprowadzaniu danych.", "Podane hasła nie zgadzają się.");
        }
    }

    @FXML
    void comeback(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tf_login_au.getScene().getWindow();
        primary.close();
    }

    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
    }
}
