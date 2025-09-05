package iuh.fit.Dao;

import iuh.fit.Models.User;
import iuh.fit.Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String INSERT_USER_SQL =
            "INSERT INTO users (first_name, last_name, email, password, birthday, gender) VALUES (?, ?, ?, ?, ?, ?)";

    // Chỉ cần Insert
    public void insertUser(User user) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getBirthday());
            ps.setString(6, user.getGender());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
