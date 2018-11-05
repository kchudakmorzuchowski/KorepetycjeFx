package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.LessonsS;
import service.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentController {

    private ObservableList<LessonsS>  lessonsSList = FXCollections.observableArrayList();
    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private int id_s;

    @FXML
    private TableView<LessonsS> tbl_lessons_s;

    @FXML
    private TableColumn<LessonsS, String> col_data_sl;

    @FXML
    private TableColumn<LessonsS, String> col_hour_sl;

    @FXML
    private TableColumn<LessonsS, String> col_subject_sl;

    @FXML
    private TableColumn<LessonsS, String> col_tutor_name_sl;

    @FXML
    private TableColumn<LessonsS, String> col_tutor_lastname_sl;

    @FXML
    private TableColumn<LessonsS, String> col_tutor_phone_sl;

    @FXML
    private TableColumn<LessonsS, String> col_tutor_email_sl;

    @FXML
    private Label lbl_loggedas_s;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void addLesson(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/addLessonS.fxml"));
        adminStage.setTitle("Dodaj lekcje");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tbl_lessons_s.getScene().getWindow();
        primary.close();
    }


    @FXML
    void logout(ActionEvent event) throws IOException {
        Stage userStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
        userStage.setTitle("Panel logowania");
        userStage.setScene(new Scene(root));
        userStage.show();
        Stage primary = (Stage) tbl_lessons_s.getScene().getWindow();
        primary.close();
    }



    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
        lbl_loggedas_s.setText("zalogowano: " + LoginController.login);
        ps = conn.prepareStatement("select id_uczniowie from uczniowie where email = ?");
        ps.setString(1,LoginController.login);
        ResultSet idSet = ps.executeQuery();
        idSet.next();
        id_s = idSet.getInt(1);
        tableLessonsSFill();
    }

    public void tableLessonsSFill() throws SQLException {
        lessonsSList.clear();
        ps = conn.prepareStatement("select * from tbl_lessons_s where id_uczniowie = ?");
        ps.setInt(1,id_s);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            LessonsS lessonsS = new LessonsS(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            lessonsSList.add(lessonsS);
        }
        col_data_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("data_sl"));
        col_hour_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("hour_sl"));
        col_subject_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("subject_sl"));
        col_tutor_name_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("tutor_name_sl"));
        col_tutor_lastname_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("tutor_lastname_sl"));
        col_tutor_phone_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("tutor_phone_sl"));
        col_tutor_email_sl.setCellValueFactory(new PropertyValueFactory<LessonsS, String>("tutor_email_sl"));
        tbl_lessons_s.setItems(lessonsSList);
    }

}
