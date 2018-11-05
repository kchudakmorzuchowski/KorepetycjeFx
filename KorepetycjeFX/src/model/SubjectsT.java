package model;

public class SubjectsT {
    private int id_subject_ts, id_subject_tutors;
    private String subject_name_ts;

    public SubjectsT(int id_subject_ts, String subject_name_ts, int id_subject_tutors) {
        this.id_subject_ts = id_subject_ts;
        this.subject_name_ts = subject_name_ts;
        this.id_subject_tutors = id_subject_tutors;
    }

    public int getId_subject_tutors() {
        return id_subject_tutors;
    }

    public void setId_subject_tutors(int id_subject_tutors) {
        this.id_subject_tutors = id_subject_tutors;
    }

    public int getId_subject_ts() {
        return id_subject_ts;
    }

    public void setId_subject_ts(int id_subject_ts) {
        this.id_subject_ts = id_subject_ts;
    }

    public String getSubject_name_ts() {
        return subject_name_ts;
    }

    public void setSubject_name_ts(String subject_name_ts) {
        this.subject_name_ts = subject_name_ts;
    }

}
