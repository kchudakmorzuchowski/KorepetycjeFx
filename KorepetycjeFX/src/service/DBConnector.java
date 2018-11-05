package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnector {
    private String user, password, db_name;

    public DBConnector() {
        this.user = "gui_user";
        this.password = "user123";
        this.db_name = "korepetytor++";

    }

    public Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/" + db_name, user, password);
    }
}
