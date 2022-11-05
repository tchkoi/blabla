package ge.ufc.webservices.db;

import ge.ufc.webservices.exception.DatabaseException;
import ge.ufc.webservices.exception.UserNotFoundException;
import ge.ufc.webservices.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceADaoImpl implements ServiceADao{

    private static final String DUPLICATE_KEY_ERROR = "23505";

    private Connection connection;

    public ServiceADaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUser(int userId) throws UserNotFoundException, DatabaseException {
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"), rs.getString("first_name"),
                            rs.getString("last_name"), rs.getString("id_number"),
                            rs.getDouble("balance"));
                } else {
                    throw new UserNotFoundException("User not found in the database");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Unable to get user from the database", e);
        }
    }
}
