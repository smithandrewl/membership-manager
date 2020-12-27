package bike.rusty.membershipmanager.db.dao;

import bike.rusty.membershipmanager.model.Class;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClassDAO extends BaseDAO {
    String GET_SQL =
        String.join(
            "\n",
            "SELECT",
            "    *,",
            "FROM",
            "    class;"
        );

    String GET_BY_ID_SQL =
        String.join(
            "\n",
            "SELECT",
            "    *,",
            "FROM",
            "    class",
            "WHERE",
            "    classId = ?"
        );

    public ClassDAO() throws SQLException {
    }

    public Class getClasses() throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(GET_SQL);
        rs.next();

        Class clubClass = new Class(
            rs.getInt("classId"),
            rs.getInt("clubId"),
            rs.getString("name"),
            rs.getString("description")
        );

        rs.close();
        statement.close();

        return clubClass;
    }

    public Class getClassById(int classId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_BY_ID_SQL);

        statement.setInt(1, classId);

        ResultSet rs = statement.executeQuery();

        rs.next();

        Class clubClass = new Class(
            rs.getInt("classId"),
            rs.getInt("clubId"),
            rs.getString("name"),
            rs.getString("description")
        );

        rs.close();
        statement.close();

        return clubClass;
    }
}
