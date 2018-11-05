package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.LessonsA;
import model.StudentsA;
import model.TutorsA;
import model.UsersA;
import service.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {

    private ObservableList<LessonsA> lessonsAList = FXCollections.observableArrayList();
    private ObservableList<StudentsA> studentsAList = FXCollections.observableArrayList();
    private ObservableList<TutorsA> tutorsAList = FXCollections.observableArrayList();
    private ObservableList<UsersA> usersAList = FXCollections.observableArrayList();
    private PreparedStatement ps;
    private DBConnector db;
    private Connection conn;


    @FXML
    private TableView<LessonsA> tbl_lessons_a;

    @FXML
    private TableColumn<LessonsA, String> col_data_la;

    @FXML
    private TableColumn<LessonsA, String> col_hour_la;

    @FXML
    private TableColumn<LessonsA, String> col_subject_la;

    @FXML
    private TableColumn<LessonsA, String> col_tutor_name_la;

    @FXML
    private TableColumn<LessonsA, String> col_tutor_lastname_la;

    @FXML
    private TableColumn<LessonsA, String> col_tutor_phone_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_name_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_lastname_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_phone_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_adress_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_city_la;

    @FXML
    private TableColumn<LessonsA, String> col_student_postcode_la;

    @FXML
    private TableView<StudentsA> tbl_students_a;

    @FXML
    private TableColumn<StudentsA, String> col_student_name_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_lastname_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_adress_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_city_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_postcode_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_phone_sa;

    @FXML
    private TableColumn<StudentsA, String> col_student_email_sa;

    @FXML
    private TableColumn<StudentsA, String> col_parent_name_sa;

    @FXML
    private TableColumn<StudentsA, String> col_parent_lastname_sa;

    @FXML
    private TableColumn<StudentsA, String> col_parent_phone_sa;

    @FXML
    private TableColumn<StudentsA, String> col_parent_email_sa;

    @FXML
    private TableView<TutorsA> tbl_tutors_a;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_name_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_lastname_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_phone_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_email_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_adress_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_city_ta;

    @FXML
    private TableColumn<TutorsA, String> col_tutor_postcode_ta;

    @FXML
    private TableView<UsersA> tbl_users_a;

    @FXML
    private TableColumn<UsersA, String> col_users_login_aa;

    @FXML
    private TableColumn<UsersA, String> col_users_password_aa;

    @FXML
    private TableColumn<UsersA, String> col_users_permission_aa;

    @FXML
    private TableColumn<UsersA, Boolean> col_users_active_aa;

    @FXML
    private Label lbl_loggedas;

    @FXML
    void addLesson(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/addLessonA.fxml"));
        adminStage.setTitle("Dodaj lekcje");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tbl_lessons_a.getScene().getWindow();
        primary.close();
    }

    @FXML
    void addStudent(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/registerStudentView.fxml"));
        adminStage.setTitle("Dodaj lekcje");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tbl_students_a.getScene().getWindow();
        primary.close();
    }

    @FXML
    void addTutor(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/registerTutorView.fxml"));
        adminStage.setTitle("Dodaj korepetytora");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tbl_tutors_a.getScene().getWindow();
        primary.close();
    }

    @FXML
    void addUser(ActionEvent event) throws IOException {
        Stage adminStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/registerUserView.fxml"));
        adminStage.setTitle("Dodaj ucznia");
        adminStage.setScene(new Scene(root));
        adminStage.show();
        Stage primary = (Stage) tbl_lessons_a.getScene().getWindow();
        primary.close();
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
        Stage primary = (Stage) tbl_lessons_a.getScene().getWindow();
        primary.close();
    }

    @FXML
    void removeLesson(ActionEvent event) throws SQLException {
        ps = conn.prepareStatement("select id_korepetytorzy from korepetytorzy where nr_tel = ?");
        ps.setString(1,tbl_lessons_a.getSelectionModel().getSelectedItem().getTutor_phone_la());
        ResultSet rs = ps.executeQuery();
        rs.next();
        int id = rs.getInt(1);
        System.out.println(id);
        ps = conn.prepareStatement("delete from lekcje where id_lekcje = ?");
        ps.setInt(1,tbl_lessons_a.getSelectionModel().getSelectedItem().getId_l());
        ps.executeUpdate();
        ps = conn.prepareStatement("update dys_kor set status = false where id_korepetytorzy = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        tableLessonsAFill();
    }

    @FXML
    void removeStudent(ActionEvent event) throws SQLException {
        ps = conn.prepareStatement("delete from lekcje where id_uczniowie = ?");
        ps.setInt(1,tbl_students_a.getSelectionModel().getSelectedItem().getId_s());
        ps.executeUpdate();
        ps = conn.prepareStatement("delete from uczniowie where email = ?");
        ps.setString(1,tbl_students_a.getSelectionModel().getSelectedItem().getStudent_email_sa());
        ps.executeUpdate();
        ps = conn.prepareStatement("delete from users where login = ?");
        ps.setString(1,tbl_students_a.getSelectionModel().getSelectedItem().getStudent_email_sa());
        ps.executeUpdate();
        tableStudentsFill();
    }

    @FXML
    void removeTutor(ActionEvent event) throws SQLException {
        ps = conn.prepareStatement("delete from przedmioty_korepetytorzy where id_korepetytorzy = ?");
        ps.setInt(1,tbl_tutors_a.getSelectionModel().getSelectedItem().getId_t());
        ps.executeUpdate();
        ps = conn.prepareStatement("delete from korepetytorzy where id_korepetytorzy = ?");
        ps.setInt(1,tbl_tutors_a.getSelectionModel().getSelectedItem().getId_t());
        ps.executeUpdate();
        ps = conn.prepareStatement("delete from users where login = ?");
        ps.setString(1,tbl_tutors_a.getSelectionModel().getSelectedItem().getTutor_email_ta());
        ps.executeUpdate();
        tableTutorsFill();
    }

    @FXML
    void removeUser(ActionEvent event) throws SQLException {
        if(!tbl_users_a.getSelectionModel().getSelectedItem().getUser_login_aa().equals(LoginController.login)){
            ps = conn.prepareStatement("delete from users where id_u = ?");
            ps.setInt(1,tbl_users_a.getSelectionModel().getSelectedItem().getId_u());
            ps.executeUpdate();
            tableUsersFill();
        }
    }

    public void initialize() throws SQLException {
        db = new DBConnector();
        conn = db.getConn();
        lbl_loggedas.setText("zalogowano: " + LoginController.login);
        tableLessonsAFill();
        tableTutorsFill();
        tableStudentsFill();
        tableUsersFill();
    }

    public void tableLessonsAFill() throws SQLException {
        lessonsAList.clear();
        ps = conn.prepareStatement("select * from tbl_lessons_a");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
        LessonsA lessonsa = new LessonsA(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
        lessonsAList.add(lessonsa);
            System.out.println();
        }
        col_data_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("data_la"));
        col_hour_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("hour_la"));
        col_subject_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("subject_la"));
        col_tutor_name_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("tutor_name_la"));
        col_tutor_lastname_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("tutor_lastname_la"));
        col_tutor_phone_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("tutor_phone_la"));
        col_student_name_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_name_la"));
        col_student_lastname_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_lastname_la"));
        col_student_phone_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_phone_la"));
        col_student_adress_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_adress_la"));
        col_student_city_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_city_la"));
        col_student_postcode_la.setCellValueFactory(new PropertyValueFactory<LessonsA, String>("student_postcode_la"));
        tbl_lessons_a.setItems(lessonsAList);
    }

    public void tableTutorsFill() throws SQLException {
        tutorsAList.clear();
        ps = conn.prepareStatement("select * from tbl_tutors_a");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            TutorsA tutorsA = new TutorsA(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            tutorsAList.add(tutorsA);
        }
        col_tutor_name_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_name_ta"));
        col_tutor_lastname_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_lastname_ta"));
        col_tutor_adress_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_adress_ta"));
        col_tutor_city_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_city_ta"));
        col_tutor_postcode_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_postcode_ta"));
        col_tutor_phone_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_phone_ta"));
        col_tutor_email_ta.setCellValueFactory(new PropertyValueFactory<TutorsA, String>("tutor_email_ta"));
        tbl_tutors_a.setItems(tutorsAList);
    }

    public void tableStudentsFill() throws SQLException {
        studentsAList.clear();
        ps = conn.prepareStatement("select * from tbl_students_a");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
           StudentsA studentsA = new StudentsA(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12)) ;
            studentsAList.add(studentsA);
        }
        col_student_name_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_name_sa"));
        col_student_lastname_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_lastname_sa"));
        col_student_adress_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_adress_sa"));
        col_student_city_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_city_sa"));
        col_student_postcode_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_postcode_sa"));
        col_student_phone_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_phone_sa"));
        col_student_email_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("student_email_sa"));
        col_parent_name_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("parent_name_sa"));
        col_parent_lastname_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("parent_lastname_sa"));
        col_parent_phone_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("parent_phone_sa"));
        col_parent_email_sa.setCellValueFactory(new PropertyValueFactory<StudentsA, String>("parent_email_sa"));
        tbl_students_a.setItems(studentsAList);
    }

    public void tableUsersFill() throws SQLException {
        usersAList.clear();
        ps = conn.prepareStatement("select * from tbl_users_a");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            UsersA usersA = new UsersA(rs.getString(1),rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
            usersAList.add(usersA);
        }
        col_users_login_aa.setCellValueFactory(new PropertyValueFactory<UsersA, String>("user_login_aa"));
        col_users_password_aa.setCellValueFactory(new PropertyValueFactory<UsersA, String>("user_password_aa"));
        col_users_permission_aa.setCellValueFactory(new PropertyValueFactory<UsersA, String>("user_permission_aa"));
        col_users_active_aa.setCellValueFactory(new PropertyValueFactory<UsersA, Boolean>("user_active_aa"));
        tbl_users_a.setItems(usersAList);
    }


}
