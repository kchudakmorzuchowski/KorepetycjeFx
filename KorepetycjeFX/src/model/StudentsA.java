package model;

public class StudentsA {
    private int id_s;
    private String student_name_sa, student_lastname_sa, student_adress_sa, student_city_sa, student_postcode_sa, student_phone_sa, student_email_sa, parent_name_sa, parent_lastname_sa, parent_phone_sa, parent_email_sa;

    public StudentsA(String student_name_sa, String student_lastname_sa, String student_adress_sa, String student_city_sa, String student_postcode_sa, String student_phone_sa, String student_email_sa, String parent_name_sa, String parent_lastname_sa, String parent_phone_sa, String parent_email_sa, int id_s) {
        this.id_s = id_s;
        this.student_name_sa = student_name_sa;
        this.student_lastname_sa = student_lastname_sa;
        this.student_adress_sa = student_adress_sa;
        this.student_city_sa = student_city_sa;
        this.student_postcode_sa = student_postcode_sa;
        this.student_phone_sa = student_phone_sa;
        this.student_email_sa = student_email_sa;
        this.parent_name_sa = parent_name_sa;
        this.parent_lastname_sa = parent_lastname_sa;
        this.parent_phone_sa = parent_phone_sa;
        this.parent_email_sa = parent_email_sa;
    }

    public int getId_s() {
        return id_s;
    }

    public void setId_s(int id_s) {
        this.id_s = id_s;
    }

    public String getStudent_name_sa() {
        return student_name_sa;
    }

    public void setStudent_name_sa(String student_name_sa) {
        this.student_name_sa = student_name_sa;
    }

    public String getStudent_lastname_sa() {
        return student_lastname_sa;
    }

    public void setStudent_lastname_sa(String student_lastname_sa) {
        this.student_lastname_sa = student_lastname_sa;
    }

    public String getStudent_adress_sa() {
        return student_adress_sa;
    }

    public void setStudent_adress_sa(String student_adress_sa) {
        this.student_adress_sa = student_adress_sa;
    }

    public String getStudent_city_sa() {
        return student_city_sa;
    }

    public void setStudent_city_sa(String student_city_sa) {
        this.student_city_sa = student_city_sa;
    }

    public String getStudent_postcode_sa() {
        return student_postcode_sa;
    }

    public void setStudent_postcode_sa(String student_postcode_sa) {
        this.student_postcode_sa = student_postcode_sa;
    }

    public String getStudent_phone_sa() {
        return student_phone_sa;
    }

    public void setStudent_phone_sa(String student_phone_sa) {
        this.student_phone_sa = student_phone_sa;
    }

    public String getStudent_email_sa() {
        return student_email_sa;
    }

    public void setStudent_email_sa(String student_email_sa) {
        this.student_email_sa = student_email_sa;
    }

    public String getParent_name_sa() {
        return parent_name_sa;
    }

    public void setParent_name_sa(String parent_name_sa) {
        this.parent_name_sa = parent_name_sa;
    }

    public String getParent_lastname_sa() {
        return parent_lastname_sa;
    }

    public void setParent_lastname_sa(String parent_lastname_sa) {
        this.parent_lastname_sa = parent_lastname_sa;
    }

    public String getParent_phone_sa() {
        return parent_phone_sa;
    }

    public void setParent_phone_sa(String parent_phone_sa) {
        this.parent_phone_sa = parent_phone_sa;
    }

    public String getParent_email_sa() {
        return parent_email_sa;
    }

    public void setParent_email_sa(String parent_email_sa) {
        this.parent_email_sa = parent_email_sa;
    }
}
