package bike.rusty.membershipmanager.db.dao;

import bike.rusty.membershipmanager.db.model.Club;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides an interface to the Club database table.
 */
public class ClubDAO extends BaseDAO{

    String GET_SQL = "SELECT * FROM club;";

    public ClubDAO() throws SQLException {
    }

    /**
     * Returns the one club record from the database.
     * @return The club database record.
     * @throws SQLException Thrown in case of a database error.
     */
    public Club getClub() throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(GET_SQL);
        rs.next();

        Club club = new Club(
            rs.getInt("clubId"),
            rs.getString("name"),
            rs.getString("description")
        );

        statement.close();

        return club;
    }
}
