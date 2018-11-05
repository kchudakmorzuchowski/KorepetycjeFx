package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import service.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AddStudentLessonController {

    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private ObservableList<String> selectStudentList = FXCollections.observableArrayList();
    private Map<String, Integer> selectStudentMap = new HashMap<>();
    private ObservableList<String> selectTutorList = FXCollections.observableArrayList();
    private Map<String, Integer> selectTutorMap = new HashMap<>();
    private Map<String, Integer> selectTutorIdMap = new HashMap<>();
    private ObservableList<String> selectAvailabilityList = FXCollections.observableArrayList();
    private Map<String, Integer> selectAvailabilityMap = new HashMap<>();


    @FXML
    private ComboBox<String> cb_select_student;

    @FXML
    private ComboBox<String> cb_select_tutor;

    @FXML
    private ComboBox<String> cb_select_availability;

    @FXML
    void comeback(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/studentView.fxml"));
        adminStage.setTitle("Panel ucznia");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) cb_select_student.getScene().getWindow();
        primary.close();
    }

    @FXML
    void addLesson(ActionEvent event) throws SQLException, IOException {
        if(cb_select_availability.getValue() != null){
            ps = conn.prepareStatement("insert into lekcje (id_uczniowie, id_przedmioty_korepetytorzy, id_dys_kor) values (?, ?, ?)");
            ps.setInt(1, selectStudentMap.get(cb_select_student.getValue()));
            ps.setInt(2,selectTutorMap.get(cb_select_tutor.getValue()));
            ps.setInt(3,selectAvailabilityMap.get(cb_select_availability.getValue()));
            ps.executeUpdate();
            ps = conn.prepareStatement("update dys_kor set status = true where id_dys_kor = ?");
            ps.setInt(1,selectAvailabilityMap.get(cb_select_availability.getValue()));
            ps.executeUpdate();
            Stage adminStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/studentView.fxml"));
            adminStage.setTitle("Panel ucznia");
            adminStage.setScene(new Scene(root));
            adminStage.show();
            Stage primary = (Stage) cb_select_student.getScene().getWindow();
            primary.close();
        }
    }



    @FXML
    void selectStudent(ActionEvent event) throws SQLException {
        selectTutorList.clear();
        if(cb_select_student.getValue() != null){
            ps = conn.prepareStatement("select * from select_tutor");
            ResultSet selectTutorSet = ps.executeQuery();
            while (selectTutorSet.next()){
                String value ="Imię i nazwisko: " + selectTutorSet.getString(2) + " " + selectTutorSet.getString(3) + " Przedmiot: " + selectTutorSet.getString(4);
                selectTutorList.add(value);
                selectTutorMap.put(value,selectTutorSet.getInt(1));
                selectTutorIdMap.put(value,selectTutorSet.getInt(5));
            }
            cb_select_tutor.setItems(selectTutorList);
            cb_select_student.setDisable(true);
            cb_select_tutor.setDisable(false);
        }
    }

    @FXML
    void selectTutor(ActionEvent event) throws SQLException {
        if(cb_select_tutor.getValue() != null){
            cb_select_tutor.setDisable(true);
            ps = conn.prepareStatement("select d.id_dys_kor, d.data, g.godziny, d.id_korepetytorzy from dys_kor d join godz_dys g on d.id_godz_dys = g.id_godz_dys where id_korepetytorzy = ? and d.status = false");
            ps.setInt(1,selectTutorIdMap.get(cb_select_tutor.getValue()));
            ResultSet selectAvailabilitySet = ps.executeQuery();
            while (selectAvailabilitySet.next()){
                String value = "Data: " + selectAvailabilitySet.getString(2) + " Godzina: " + selectAvailabilitySet.getString(3);
                selectAvailabilityList.add(value);
                selectAvailabilityMap.put(value,selectAvailabilitySet.getInt(1));
            }
            cb_select_availability.setItems(selectAvailabilityList);
            cb_select_availability.setDisable(false);
        }
    }

    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
        ps = conn.prepareStatement("select * from uczniowie where email = ?");
        ps.setString(1,LoginController.login);
        ResultSet selectStudentSet = ps.executeQuery();
        while (selectStudentSet.next()){
            String value ="Imię i nazwisko: " + selectStudentSet.getString(2) + " " + selectStudentSet.getString(3);
            selectStudentList.add(value);
            selectStudentMap.put(value,selectStudentSet.getInt(1));
        }
        cb_select_student.setItems(selectStudentList);
        cb_select_tutor.setDisable(true);
        cb_select_availability.setDisable(true);
    }

}
