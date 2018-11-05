package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDeactivator {
    public UserDeactivator(Connection conn, int id_u) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("UPDATE users SET active = 0 WHERE id_u = ?");
        ps.setInt(1, id_u);
        ps.executeUpdate();
    }
}
