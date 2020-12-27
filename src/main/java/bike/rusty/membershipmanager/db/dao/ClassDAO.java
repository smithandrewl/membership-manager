package bike.rusty.membershipmanager.db.dao;

import bike.rusty.membershipmanager.model.Class;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Vector;

/**
 * Provides an interface to the Class database table.
 */
public class ClassDAO extends BaseDAO {
    String GET_SQL =
        String.join(
            "\n",
            "SELECT",
            "    *",
            "FROM class"
        );

    String GET_BY_ID_SQL =
        String.join(
            "\n",
            "SELECT",
            "    *",
            "FROM",
            "    class",
            "WHERE",
            "    classId = ?"
        );

    String ADD_SQL =
        String.join(
            "\n",
            "INSERT INTO CLASS(",
            "    clubId,",
            "    name,",
            "    description",
            ") VALUES (?, ?, ?);"
        );

    public ClassDAO() throws SQLException {
    }

    /**
     * Returns all of the classes.
     * @return All of the classes.
     * @throws SQLException Thrown in case of a database error.
     */
    public Vector<Class> getClasses() throws SQLException {
        Vector<Class> classes = new Vector<>();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(GET_SQL);

        while(rs.next()) {
            classes.add(
                new Class(
                    rs.getInt("classId"),
                    rs.getInt("clubId"),
                    rs.getString("name"),
                    rs.getString("description")
                )
            );
        }

        rs.close();
        statement.close();

        return classes;
    }

    /**
     * Gets a class by Id
     * @param classId the id of the class
     * @return The class if it exists, or Optional.empty() otherwise.
     * @throws SQLException An exception if one is thrown.
     */
    public Optional<Class> getClassById(int classId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_BY_ID_SQL);

        statement.setInt(1, classId);

        ResultSet rs = statement.executeQuery();

        Optional<Class> result = Optional.empty();

        if(rs.next()) {
            Class clubClass = new Class(
                rs.getInt("classId"),
                rs.getInt("clubId"),
                rs.getString("name"),
                rs.getString("description")
            );

            result = Optional.of(clubClass);

        }

        rs.close();
        statement.close();

        return result;
    }

    /**
     * Adds a new class to the database.
     *
     * @param clubClass The Class object to save to the database.
     * @return Returns the classId of the newly created Class record.
     * @throws SQLException Thrown in case of a database error.
     */
    public int addClass(Class clubClass) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(ADD_SQL);

        statement.setInt(1, clubClass.getClubId());
        statement.setString(2, clubClass.getName());
        statement.setString(3, clubClass.getDescription());

        statement.execute();

        int key = statement.getGeneratedKeys().getInt(1);

        statement.close();

        return key;
    }
}
