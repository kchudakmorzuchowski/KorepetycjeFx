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
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterTutorController {

    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private String permission = "role_tutor";
    private boolean active = true;

    @FXML
    private TextField tf_name_t;

    @FXML
    private TextField tf_lastname_t;

    @FXML
    private TextField tf_adress_t;

    @FXML
    private TextField tf_city_t;

    @FXML
    private TextField tf_postcode_t;

    @FXML
    private TextField tf_phone_t;

    @FXML
    private TextField tf_email_t;

    @FXML
    private PasswordField pf_password_t;

    @FXML
    private PasswordField pf_password_confirm_t;

    @FXML
    void comeback(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
        adminStage.setTitle("Panel administratora");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tf_city_t.getScene().getWindow();
        primary.close();
    }


    @FXML
    void tutorRegister(ActionEvent event) throws IOException, SQLException {
        if(pf_password_t.getText().equals(pf_password_confirm_t.getText())) {
            if (tf_name_t.getText() != null && tf_lastname_t != null && tf_phone_t != null && tf_email_t != null && pf_password_t != null && pf_password_confirm_t != null) {
                ps = conn.prepareStatement("insert into korepetytorzy (imie, nazwisko, adres, miasto, kod_pocztowy, nr_tel, email) values (?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, tf_name_t.getText());
                ps.setString(2, tf_lastname_t.getText());
                ps.setString(3, tf_adress_t.getText());
                ps.setString(4, tf_city_t.getText());
                ps.setString(5, tf_postcode_t.getText());
                ps.setString(6, tf_phone_t.getText());
                ps.setString(7, tf_email_t.getText());
                ps.executeUpdate();
                ps = conn.prepareStatement("insert into users (login, password, permission, active) values (?, ?, ?, ?)");
                ps.setString(1, tf_email_t.getText());
                ps.setString(2, pf_password_t.getText());
                ps.setString(3, permission);
                ps.setBoolean(4, active);
                ps.executeUpdate();
                ps = conn.prepareStatement("select id_korepetytorzy from korepetytorzy where email = ?");
                ps.setString(1,tf_email_t.getText());
                ResultSet rs = ps.executeQuery();
                rs.next();
                int id = rs.getInt(1);
                ps = conn.prepareStatement("insert into przedmioty_korepetytorzy (id_przedmioty, id_korepetytorzy) values (?, ?)");
                ps.setInt(1,14);
                ps.setInt(2,id);
                ps.executeUpdate();
                Popup alert = new Popup(Alert.AlertType.INFORMATION, "Informacja", "Dodadno nowego korepetytora",tf_name_t.getText() + " " + tf_lastname_t.getText());
                Stage adminStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                adminStage.setTitle("Panel administratora");
                adminStage.setScene(new Scene(root));
                adminStage.show();
                Stage primary = (Stage) tf_phone_t.getScene().getWindow();
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
