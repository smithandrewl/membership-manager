package bike.rusty.membershipmanager.db.dao;

import bike.rusty.membershipmanager.db.model.Club;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides an interface to the Club database table.
 */
public class ClubDAO extends BaseDAO{

    // SQL for getting all of the clubs from the database.
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

    /**
     * Updates the name of the club.
     * @param newName The new name of the club.
     * @throws SQLException
     */
    public void updateName(String newName) throws SQLException {
        // This call contains a SQL statement which updates a specific club to have a new name.
        PreparedStatement statement = connection.prepareStatement("UPDATE club SET name = ? WHERE clubId = ?");
        statement.setString(1, newName);
        statement.setInt(2, getClub().getClubId());

        statement.execute();
        statement.close();
    }
}
