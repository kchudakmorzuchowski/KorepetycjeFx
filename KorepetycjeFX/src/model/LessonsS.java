package model;

public class LessonsS {
    private String data_sl, hour_sl, subject_sl, tutor_name_sl, tutor_lastname_sl, tutor_phone_sl, tutor_email_sl;
    private int id_l;

    public LessonsS(String data_sl, String hour_sl, String subject_sl, String tutor_name_sl, String tutor_lastname_sl, String tutor_phone_sl, String tutor_email_sl, int id_l) {
        this.data_sl = data_sl;
        this.hour_sl = hour_sl;
        this.subject_sl = subject_sl;
        this.tutor_name_sl = tutor_name_sl;
        this.tutor_lastname_sl = tutor_lastname_sl;
        this.tutor_phone_sl = tutor_phone_sl;
        this.tutor_email_sl = tutor_email_sl;
        this.id_l = id_l;
    }

    public int getId_l() {
        return id_l;
    }

    public void setId_l(int id_l) {
        this.id_l = id_l;
    }

    public String getData_sl() {
        return data_sl;
    }

    public void setData_sl(String data_sl) {
        this.data_sl = data_sl;
    }

    public String getHour_sl() {
        return hour_sl;
    }

    public void setHour_sl(String hour_sl) {
        this.hour_sl = hour_sl;
    }

    public String getSubject_sl() {
        return subject_sl;
    }

    public void setSubject_sl(String subject_sl) {
        this.subject_sl = subject_sl;
    }

    public String getTutor_name_sl() {
        return tutor_name_sl;
    }

    public void setTutor_name_sl(String tutor_name_sl) {
        this.tutor_name_sl = tutor_name_sl;
    }

    public String getTutor_lastname_sl() {
        return tutor_lastname_sl;
    }

    public void setTutor_lastname_sl(String tutor_lastname_sl) {
        this.tutor_lastname_sl = tutor_lastname_sl;
    }

    public String getTutor_phone_sl() {
        return tutor_phone_sl;
    }

    public void setTutor_phone_sl(String tutor_phone_sl) {
        this.tutor_phone_sl = tutor_phone_sl;
    }

    public String getTutor_email_sl() {
        return tutor_email_sl;
    }

    public void setTutor_email_sl(String tutor_email_sl) {
        this.tutor_email_sl = tutor_email_sl;
    }
}