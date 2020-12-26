package bike.rusty.membershipmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    public static final String CONNECTION_STRING ="jdbc:sqlite:members.db";

    Connection connection = DriverManager.getConnection(CONNECTION_STRING);

    public BaseDAO() throws SQLException {
        // create the database if it does not exist
    }
}
