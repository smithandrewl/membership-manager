package bike.rusty.membershipmanager.db.dao;
import bike.rusty.membershipmanager.db.model.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Vector;

/**
 * Provides access to the Members database table.
 */
public class MemberDAO extends BaseDAO {
    // SQL to delete a specific club member by id.
    public static final String DELETE_SQL = "DELETE FROM member WHERE memberId = ?";

    // SQL to get all club members
    String GET_SQL        = "SELECT * FROM member;";

    // SQL to get a specific member by id.
    String FIND_BY_ID_SQL = "SELECT * FROM member where memberId = ?";

    // SQL to add a new club member.
    String ADD_SQL        = "INSERT INTO member(clubId, firstName, lastName) VALUES(?, ?, ?)";

    // SQL to update the values for a specific club member.
    String UPDATE_SQL     =
        String.join(
            "\n",
            "UPDATE",
            "    member",
            "SET",
            "    clubId    = ?,",
            "    firstName = ?,",
            "    lastName  = ?",
            "WHERE",
            "    memberId = ?"
        );

    public MemberDAO() throws SQLException { }

    /**
     * Gets all members of the club.
     * @return Returns all club members.
     * @throws SQLException Thrown in case of an error
     */
    public Vector<Member> getMembers() throws SQLException {
        Vector<Member> members = new Vector<Member>();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(GET_SQL);

        while(rs.next()) {
            members.add(new Member(
                rs.getInt("memberId"),
                rs.getInt("clubId"),
                rs.getString("firstName"),
                rs.getString("lastName")
            ));
        }
        statement.close();

        return members;
    }

    /**
     * Obtains a Member given their memberId.
     *
     * @param memberId The clients member id
     * @return The member with the matching member id.
     * @throws SQLException Thrown in case of a database error
     */
    public Optional<Member> getById(int memberId) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
            FIND_BY_ID_SQL
        );

        statement.setInt(1, memberId);

        ResultSet rs =statement.executeQuery();

        boolean exists = rs.next();

        if(exists) {
            Member member = new Member(
                rs.getInt("memberId"),
                rs.getInt("clubId"),
                rs.getString("firstName"),
                rs.getString("lastName")
            );

            rs.close();

            return Optional.of(member);
        } else {
            rs.close();
            return Optional.empty();
        }
    }

    /**
     * Adds a member to the database.
     *
     * @param member The member to add
     * @return Returns the memberId of the newly created member.
     * @throws SQLException Thrown in case of database error.
     */
    public int addMember(Member member) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(ADD_SQL);

        statement.setInt(1,    member.getClubId());
        statement.setString(2, member.getFirstName());
        statement.setString(3, member.getLastName());

        statement.execute();
        statement.close();
        return statement.getGeneratedKeys().getInt(1);
    }

    /**
     * Updates a member with new values.
     * @param member The member with updated fields.
     * @throws SQLException Thrown in case of a database error.
     */
    public void updateMember(Member member) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);

        statement.setInt(1,    member.getClubId());
        statement.setString(2, member.getFirstName());
        statement.setString(3, member.getLastName());
        statement.setInt(4,    member.getMemberId());

        statement.execute();
        statement.close();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE_SQL);

        statement.setInt(1, id);
        statement.execute();
        statement.close();
    }
}
