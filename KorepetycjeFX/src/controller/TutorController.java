package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.AvailabilityT;
import model.LessonsT;
import model.SubjectsT;
import service.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TutorController {

    private ObservableList<String> selectSubjectsList = FXCollections.observableArrayList();
    private Map<String, Integer> selectSubjectsMap = new HashMap<>();
    private ObservableList<String> selectHourList = FXCollections.observableArrayList();
    private Map<String, Integer> selectHourMap = new HashMap<>();
    private ObservableList<LessonsT> lessonsTList = FXCollections.observableArrayList();
    private ObservableList<AvailabilityT> availabilityTList = FXCollections.observableArrayList();
    private ObservableList<SubjectsT> subjectsTList = FXCollections.observableArrayList();
    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;
    private int id_k;

    @FXML
    private TableView<LessonsT> tbl_lessons_t;

    @FXML
    private TableColumn<LessonsT, String> col_data_tl;

    @FXML
    private TableColumn<LessonsT, String> col_hour_tl;

    @FXML
    private TableColumn<LessonsT, String> col_subject_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_name_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_lastname_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_adress_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_city_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_postcode_tl;

    @FXML
    private TableColumn<LessonsT, String> col_student_phone_tl;

    @FXML
    private TableView<AvailabilityT> tbl_tutor_availibility_t;

    @FXML
    private TableColumn<AvailabilityT, Integer> col_id_availibility_ta;

    @FXML
    private TableColumn<AvailabilityT, Integer> col_id_hour_ta;

    @FXML
    private TableColumn<AvailabilityT, String> col_hour_ta;

    @FXML
    private TableColumn<AvailabilityT, String> col_data_ta;

    @FXML
    private TableColumn<AvailabilityT, Boolean> col_status_ta;

    @FXML
    private ComboBox<String> cb_hour_t;

    @FXML
    private DatePicker dp_data_t;

    @FXML
    private TableView<SubjectsT> tbl_subjects_t;

    @FXML
    private TableColumn<SubjectsT, Integer> col_id_subject_ts;

    @FXML
    private TableColumn<SubjectsT, String> col_subject_name_ts;

    @FXML
    private ComboBox<String> cb_subject_t;

    @FXML
    private Label lbl_loggedas_t;

    @FXML
    void addAvailibility(ActionEvent event) throws SQLException {
        if(cb_hour_t.getValue() != null && String.valueOf(dp_data_t.getValue()) != null) {
            boolean status = false;
            ps = conn.prepareStatement("insert into dys_kor (id_korepetytorzy, id_godz_dys, data, status) values (?, ?, ?, ?)");
            ps.setInt(1, id_k);
            ps.setInt(2,selectHourMap.get(cb_hour_t.getValue()));
            ps.setString(3, String.valueOf(dp_data_t.getValue()));
            ps.setBoolean(4,status);
            ps.executeUpdate();
            tableAvailabilityTFill();
        }
    }

    @FXML
    void addSubject(ActionEvent event) throws SQLException {
        if(cb_subject_t.getValue() != null) {
            ps = conn.prepareStatement("insert into przedmioty_korepetytorzy (id_korepetytorzy, id_przedmioty) values (?, ?)");
            ps.setInt(1, id_k);
            ps.setInt(2,selectSubjectsMap.get(cb_subject_t.getValue()));
            ps.executeUpdate();
            tableSubjectTFill();
        }

    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Stage userStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
        userStage.setTitle("Panel logowania");
        userStage.setScene(new Scene(root));
        userStage.show();
        Stage primary = (Stage) tbl_lessons_t.getScene().getWindow();
        primary.close();
    }

    @FXML
    void removeSubject(ActionEvent event) throws SQLException {
        ps = conn.prepareStatement("delete from przedmioty_korepetytorzy where id_przedmioty_korepetytorzy = ?");
        ps.setInt(1,tbl_subjects_t.getSelectionModel().getSelectedItem().getId_subject_tutors());
        ps.executeUpdate();
        tableSubjectTFill();
    }

    @FXML
    void deleteAvailability(ActionEvent event) throws SQLException {
        ps = conn.prepareStatement("delete from dys_kor where id_dys_kor = ?");
        ps.setInt(1,tbl_tutor_availibility_t.getSelectionModel().getSelectedItem().getId_availability_ta());
        ps.executeUpdate();
        tableAvailabilityTFill();
    }



    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
        lbl_loggedas_t.setText("zalogowano: " + LoginController.login);
        ps = conn.prepareStatement("select id_korepetytorzy from korepetytorzy where email = ?");
        ps.setString(1,LoginController.login);
        ResultSet idSet = ps.executeQuery();
        idSet.next();
        id_k = idSet.getInt(1);
        tableLessonsTFill();
        tableAvailabilityTFill();
        tableSubjectTFill();
        ps = conn.prepareStatement("select id_przedmioty, nazwa_przedmiotu from przedmioty");
        ResultSet selectSubjectsSet = ps.executeQuery();
        while (selectSubjectsSet.next()) {
            String value = selectSubjectsSet.getString(2);
            selectSubjectsList.add(value);
            selectSubjectsMap.put(value,selectSubjectsSet.getInt(1));
        }
        cb_subject_t.setItems(selectSubjectsList);
        ps = conn.prepareStatement("select id_godz_dys, godziny from godz_dys");
        ResultSet selectHourSet = ps.executeQuery();
        while (selectHourSet.next()){
            String value = selectHourSet.getString(2);
            selectHourList.add(value);
            selectHourMap.put(value,selectHourSet.getInt(1));
        }
        cb_hour_t.setItems(selectHourList);
    }

    public void tableLessonsTFill() throws SQLException {
        lessonsTList.clear();
        ps = conn.prepareStatement("select * from tbl_lessons_t where id_korepetytorzy = ?");
        ps.setInt(1,id_k);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            LessonsT lessonsT = new LessonsT(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10));
            lessonsTList.add(lessonsT);
        }
        col_data_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("data_tl"));
        col_hour_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("hour_tl"));
        col_subject_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("subject_tl"));
        col_student_name_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_name_tl"));
        col_student_lastname_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_lastname_tl"));
        col_student_adress_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_adress_tl"));
        col_student_city_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_city_tl"));
        col_student_postcode_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_postcode_tl"));
        col_student_phone_tl.setCellValueFactory(new PropertyValueFactory<LessonsT, String>("student_phone_tl"));
        tbl_lessons_t.setItems(lessonsTList);
    }
    public void tableAvailabilityTFill() throws SQLException {
    availabilityTList.clear();
    ps = conn.prepareStatement("select d.id_dys_kor, d.id_godz_dys, g.godziny, d.data, d.status, k.id_korepetytorzy from dys_kor d join godz_dys g on d.id_godz_dys = g.id_godz_dys join korepetytorzy k on d.id_korepetytorzy = k.id_korepetytorzy where k.id_korepetytorzy = ?");
    ps.setInt(1,id_k);
    ResultSet rs = ps.executeQuery();
    while (rs.next()){
        AvailabilityT availabilityT = new AvailabilityT(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4), rs.getBoolean(5));
        availabilityTList.add(availabilityT);
    }
    col_id_availibility_ta.setCellValueFactory(new PropertyValueFactory<AvailabilityT, Integer>("id_availability_ta"));
    col_id_hour_ta.setCellValueFactory(new PropertyValueFactory<AvailabilityT, Integer>("id_hour_ta"));
    col_hour_ta.setCellValueFactory(new PropertyValueFactory<AvailabilityT, String>("hour_ta"));
    col_data_ta.setCellValueFactory(new PropertyValueFactory<AvailabilityT, String>("data_ta"));
    col_status_ta.setCellValueFactory(new PropertyValueFactory<AvailabilityT, Boolean>("status_ta"));
    tbl_tutor_availibility_t.setItems(availabilityTList);
    }

    public void tableSubjectTFill() throws SQLException {
        subjectsTList.clear();
        ps = conn.prepareStatement("select pk.id_przedmioty, p.nazwa_przedmiotu, pk.id_przedmioty_korepetytorzy from przedmioty_korepetytorzy pk join przedmioty p on pk.id_przedmioty = p.id_przedmioty join korepetytorzy k on pk.id_korepetytorzy = k.id_korepetytorzy where pk.id_korepetytorzy = ?");
        ps.setInt(1,id_k);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            SubjectsT subjectsT = new SubjectsT(rs.getInt(1),rs.getString(2), rs.getInt(3));
            subjectsTList.add(subjectsT);
        }
        col_id_subject_ts.setCellValueFactory(new PropertyValueFactory<SubjectsT,Integer>("id_subject_ts"));
        col_subject_name_ts.setCellValueFactory(new PropertyValueFactory<SubjectsT, String>("subject_name_ts"));
        tbl_subjects_t.setItems(subjectsTList);
    }

}
