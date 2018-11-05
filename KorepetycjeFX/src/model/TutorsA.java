package model;

public class TutorsA {
    private int id_t;
    private String tutor_name_ta, tutor_lastname_ta, tutor_adress_ta, tutor_city_ta, tutor_postcode_ta, tutor_phone_ta, tutor_email_ta;

    public TutorsA(String tutor_name_ta, String tutor_lastname_ta, String tutor_adress_ta, String tutor_city_ta, String tutor_postcode_ta, String tutor_phone_ta, String tutor_email_ta, int id_t) {
        this.tutor_name_ta = tutor_name_ta;
        this.tutor_lastname_ta = tutor_lastname_ta;
        this.tutor_adress_ta = tutor_adress_ta;
        this.tutor_city_ta = tutor_city_ta;
        this.tutor_postcode_ta = tutor_postcode_ta;
        this.tutor_phone_ta = tutor_phone_ta;
        this.tutor_email_ta = tutor_email_ta;
        this.id_t = id_t;
    }

    public int getId_t() {
        return id_t;
    }

    public void setId_t(int id_t) {
        this.id_t = id_t;
    }

    public String getTutor_name_ta() {
        return tutor_name_ta;
    }

    public void setTutor_name_ta(String tutor_name_ta) {
        this.tutor_name_ta = tutor_name_ta;
    }

    public String getTutor_lastname_ta() {
        return tutor_lastname_ta;
    }

    public void setTutor_lastname_ta(String tutor_lastname_ta) {
        this.tutor_lastname_ta = tutor_lastname_ta;
    }

    public String getTutor_adress_ta() {
        return tutor_adress_ta;
    }

    public void setTutor_adress_ta(String tutor_adress_ta) {
        this.tutor_adress_ta = tutor_adress_ta;
    }

    public String getTutor_city_ta() {
        return tutor_city_ta;
    }

    public void setTutor_city_ta(String tutor_city_ta) {
        this.tutor_city_ta = tutor_city_ta;
    }

    public String getTutor_postcode_ta() {
        return tutor_postcode_ta;
    }

    public void setTutor_postcode_ta(String tutor_postcode_ta) {
        this.tutor_postcode_ta = tutor_postcode_ta;
    }

    public String getTutor_phone_ta() {
        return tutor_phone_ta;
    }

    public void setTutor_phone_ta(String tutor_phone_ta) {
        this.tutor_phone_ta = tutor_phone_ta;
    }

    public String getTutor_email_ta() {
        return tutor_email_ta;
    }

    public void setTutor_email_ta(String tutor_email_ta) {
        this.tutor_email_ta = tutor_email_ta;
    }
}
