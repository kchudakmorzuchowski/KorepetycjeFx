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

public class RegisterStudentController {
    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private String permission = "role_student";
    private boolean active = true;

    @FXML
    private TextField tf_name_s;

    @FXML
    private TextField tf_lastname_s;

    @FXML
    private TextField tf_adress_s;

    @FXML
    private TextField tf_city_s;

    @FXML
    private TextField tf_postcode_s;

    @FXML
    private TextField tf_phone_s;

    @FXML
    private TextField tf_email_s;

    @FXML
    private TextField tf_parent_name_s;

    @FXML
    private TextField tf_parent_lastname_s;

    @FXML
    private TextField tf_parent_phone_s;

    @FXML
    private TextField tf_parent_email_s;

    @FXML
    private PasswordField pf_password_s;

    @FXML
    private PasswordField pf_password_confirm_s;

    @FXML
    void comeback(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) pf_password_s.getScene().getWindow();
        primary.close();
    }


    @FXML
    void studentRegister(ActionEvent event) throws SQLException, IOException {
        if(pf_password_s.getText().equals(pf_password_confirm_s.getText())) {
            if (tf_name_s.getText() != null && tf_lastname_s != null && tf_adress_s != null && tf_city_s != null && tf_postcode_s != null && tf_phone_s != null && tf_email_s != null && pf_password_s != null && pf_password_confirm_s != null) {
                ps = conn.prepareStatement("insert into uczniowie (imie, nazwisko, adres, miasto, kod_pocztowy, nr_tel, email, imie_rodzica, nazwisko_rodzica, nr_tel_rodzica, email_rodzica) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, tf_name_s.getText());
                ps.setString(2, tf_lastname_s.getText());
                ps.setString(3, tf_adress_s.getText());
                ps.setString(4, tf_city_s.getText());
                ps.setString(5, tf_postcode_s.getText());
                ps.setString(6, tf_phone_s.getText());
                ps.setString(7, tf_email_s.getText());
                ps.setString(8, tf_parent_name_s.getText());
                ps.setString(9, tf_parent_lastname_s.getText());
                ps.setString(10, tf_parent_phone_s.getText());
                ps.setString(11, tf_parent_email_s.getText());
                ps.executeUpdate();
                ps = conn.prepareStatement("insert into users (login, password, permission, active) values (?, ?, ?, ?)");
                ps.setString(1, tf_email_s.getText());
                ps.setString(2, pf_password_s.getText());
                ps.setString(3, permission);
                ps.setBoolean(4, active);
                ps.executeUpdate();
                Popup alert = new Popup(Alert.AlertType.INFORMATION, "Informacja", "Dodadno nowego ucznia",tf_name_s.getText() + " " + tf_lastname_s.getText());
                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setTitle("Panel administratora");
                adminStage.setScene(new Scene(root));
                adminStage.show();
                Stage primary = (Stage) tf_email_s.getScene().getWindow();
                primary.close();
            } else {
                Popup alert = new Popup(Alert.AlertType.ERROR, "Błąd", "Wystąpił bład przy wprowadzaniu danych.", "Wszystkie wymagane pola nie zostały wypełnione.");
            }
        }
        else {
            Popup alert = new Popup(Alert.AlertType.ERROR, "Błąd", "Wystąpił bład przy wprowadzaniu danych.", "Podane hasła nie zgadzają się.");
        }
    }

    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
    }

}
