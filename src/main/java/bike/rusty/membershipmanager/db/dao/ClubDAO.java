package bike.rusty.membershipmanager.db.dao;

import bike.rusty.membershipmanager.model.Club;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClubDAO extends BaseDAO{

    String GET_SQL = "SELECT * FROM club;";

    public ClubDAO() throws SQLException {
    }

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
