package model;

public class UsersA {
    private String user_login_aa, user_password_aa, user_permission_aa;
    private boolean user_active_aa;
    private int id_u;

    public UsersA(String user_login_aa, String user_password_aa, String user_permission_aa, boolean user_active_aa, int id_u) {
        this.user_login_aa = user_login_aa;
        this.user_password_aa = user_password_aa;
        this.user_permission_aa = user_permission_aa;
        this.user_active_aa = user_active_aa;
        this.id_u = id_u;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getUser_login_aa() {
        return user_login_aa;
    }

    public void setUser_login_aa(String user_login_aa) {
        this.user_login_aa = user_login_aa;
    }

    public String getUser_password_aa() {
        return user_password_aa;
    }

    public void setUser_password_aa(String user_password_aa) {
        this.user_password_aa = user_password_aa;
    }

    public String getUser_permission_aa() {
        return user_permission_aa;
    }

    public void setUser_permission_aa(String user_permission_aa) {
        this.user_permission_aa = user_permission_aa;
    }

    public boolean isUser_active_aa() {
        return user_active_aa;
    }

    public void setUser_active_aa(boolean user_active_aa) {
        this.user_active_aa = user_active_aa;
    }
}
