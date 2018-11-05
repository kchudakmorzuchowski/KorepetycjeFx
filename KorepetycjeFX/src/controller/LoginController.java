package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import service.DBConnector;
import service.Popup;
import service.UserDeactivator;

import java.io.IOException;
import java.sql.*;

public class LoginController {


    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private int loginCounter = 3;
    private int id_u;
    private String permission, password;
    private boolean active;
    static String login;


    @FXML
    private TextField tf_login;

    @FXML
    private PasswordField pf_password;

    public LoginController() throws SQLException {

    }
    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
    }


    @FXML
    void loginAction(ActionEvent event) throws IOException, SQLException {
        login();
    }

    @FXML
    void loginKeyAction(KeyEvent event) throws IOException, SQLException {
    if(event.getCode() == KeyCode.ENTER) {
        login();
    }
    }

    private void login() throws SQLException, IOException {
        ps = conn.prepareStatement("select password, id_u, permission, active from users where login = ?");
        ps.setString(1, tf_login.getText());
        ResultSet loginSet = ps.executeQuery();
        if (loginSet.next() && loginCounter <= 3) {
            login = tf_login.getText();
            password = loginSet.getString(1);
            id_u = loginSet.getInt(2);
            permission = loginSet.getString(3);
            active = loginSet.getBoolean(4);
            if (password.equals(pf_password.getText()) && active == true) {
                if (permission.equals("role_admin")) {
                    loginCounter = 3;
                    Stage adminStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/adminView.fxml"));
                    adminStage.setTitle("Panel administratora");
                    adminStage.setScene(new Scene(root));
                    adminStage.show();
                    Stage primary = (Stage) tf_login.getScene().getWindow();
                    primary.close();
                } else if (permission.equals("role_student")) {
                    loginCounter = 3;
                    Stage userStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/studentView.fxml"));
                    userStage.setTitle("Panel ucznia");
                    userStage.setScene(new Scene(root));
                    userStage.show();
                    Stage primary = (Stage) tf_login.getScene().getWindow();
                    primary.close();
                }else if (permission.equals("role_tutor")){
                    loginCounter = 3;
                    Stage userStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/view/tutorView.fxml"));
                    userStage.setTitle("Panel korepetytora");
                    userStage.setScene(new Scene(root));
                    userStage.show();
                    Stage primary = (Stage) tf_login.getScene().getWindow();
                    primary.close();
                }
                else{
                    Popup popup = new Popup(Alert.AlertType.WARNING, "BŁĄD", "Wystąpił błąd przy logowaniu.", "Konto nie ma przypisanego typu uprawnień. Skontaktuj się z administratorem KOREPETYTOR++");
                }
            }
            else if(password.equals(pf_password.getText()) && active == false) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "BŁĄD", "Wystąpił błąd przy logowaniu.", "Konto jest nieaktywne. Skontaktuj się z administratorem KOREPETYTOR++");
            }
            else if(!password.equals(pf_password.getText()) && active == false) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "BŁĄD", "Wystąpił błąd przy logowaniu.", "Podano złe hasło. Konto jest nieaktywne. Skontaktuj się z administratorem KOREPETYTOR++");
            }
            else {
                Popup popup3 = new Popup(Alert.AlertType.WARNING, "BŁĄD", "Wystąpił błąd przy logowaniu.", "Podano błędne hasło. Pozostało prób logowania: " + loginCounter);
                loginCounter--;
                if (this.loginCounter == 0) {
                    UserDeactivator ud = new UserDeactivator(conn, id_u);
                }
            }
        }
        else {
            Popup popup2 = new Popup(Alert.AlertType.WARNING, "BŁĄD", "Błąd przy logowaniu", "Podano błędny login lub hasło.");
            this.loginCounter--;
        }

    }
}
