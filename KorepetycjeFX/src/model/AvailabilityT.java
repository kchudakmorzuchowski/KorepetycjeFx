package model;

public class AvailabilityT {

    private int id_availability_ta, id_hour_ta;
    private String hour_ta, data_ta;
    private boolean status_ta;

    public AvailabilityT(int id_availability_ta, int id_hour_ta, String hour_ta, String data_ta, boolean status_ta) {
        this.id_availability_ta = id_availability_ta;
        this.id_hour_ta = id_hour_ta;
        this.hour_ta = hour_ta;
        this.data_ta = data_ta;
        this.status_ta = status_ta;
    }


    public String getHour_ta() {
        return hour_ta;
    }

    public void setHour_ta(String hour_ta) {
        this.hour_ta = hour_ta;
    }

    public String getData_ta() {
        return data_ta;
    }

    public void setData_ta(String data_ta) {
        this.data_ta = data_ta;
    }

    public boolean isStatus_ta() {
        return status_ta;
    }

    public void setStatus_ta(boolean status_ta) {
        this.status_ta = status_ta;
    }

    public int getId_availability_ta() {
        return id_availability_ta;
    }

    public void setId_availability_ta(int id_availability_ta) {
        this.id_availability_ta = id_availability_ta;
    }

    public int getId_hour_ta() {
        return id_hour_ta;
    }

    public void setId_hour_ta(int id_hour_ta) {
        this.id_hour_ta = id_hour_ta;
    }
}
