package model;

public class LessonsT {
    private String data_tl;
    private String hour_tl;
    private String subject_tl;
    private String student_name_tl;
    private String student_lastname_tl;
    private String student_adress_tl;
    private String student_city_tl;
    private String student_postcode_tl;
    private int id_lekcje;

    public String getStudent_phone_tl() {
        return student_phone_tl;
    }

    public void setStudent_phone_tl(String student_phone_tl) {
        this.student_phone_tl = student_phone_tl;
    }

    private String student_phone_tl;

    public LessonsT(String data_tl, String hour_tl, String subject_tl, String student_name_tl, String student_lastname_tl, String student_adress_tl, String student_city_tl, String student_postcode_tl, String student_phone_tl, int id_lekcje) {
        this.data_tl = data_tl;
        this.hour_tl = hour_tl;
        this.subject_tl = subject_tl;
        this.student_name_tl = student_name_tl;
        this.student_lastname_tl = student_lastname_tl;
        this.student_adress_tl = student_adress_tl;
        this.student_city_tl = student_city_tl;
        this.student_postcode_tl = student_postcode_tl;
        this.student_phone_tl = student_phone_tl;
        this.id_lekcje = id_lekcje;
    }

    public int getId_lekcje() {
        return id_lekcje;
    }

    public void setId_lekcje(int id_lekcje) {
        this.id_lekcje = id_lekcje;
    }

    public String getData_tl() {
        return data_tl;
    }

    public void setData_tl(String data_tl) {
        this.data_tl = data_tl;
    }

    public String getHour_tl() {
        return hour_tl;
    }

    public void setHour_tl(String hour_tl) {
        this.hour_tl = hour_tl;
    }

    public String getSubject_tl() {
        return subject_tl;
    }

    public void setSubject_tl(String subject_tl) {
        this.subject_tl = subject_tl;
    }

    public String getStudent_name_tl() {
        return student_name_tl;
    }

    public void setStudent_name_tl(String student_name_tl) {
        this.student_name_tl = student_name_tl;
    }

    public String getStudent_lastname_tl() {
        return student_lastname_tl;
    }

    public void setStudent_lastname_tl(String student_lastname_tl) {
        this.student_lastname_tl = student_lastname_tl;
    }

    public String getStudent_adress_tl() {
        return student_adress_tl;
    }

    public void setStudent_adress_tl(String student_adress_tl) {
        this.student_adress_tl = student_adress_tl;
    }

    public String getStudent_city_tl() {
        return student_city_tl;
    }

    public void setStudent_city_tl(String student_city_tl) {
        this.student_city_tl = student_city_tl;
    }

    public String getStudent_postcode_tl() {
        return student_postcode_tl;
    }

    public void setStudent_postcode_tl(String student_postcode_tl) {
        this.student_postcode_tl = student_postcode_tl;
    }



}
