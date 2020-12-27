package bike.rusty.membershipmanager.db.dao;
import bike.rusty.membershipmanager.model.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MemberDAO extends BaseDAO {
    String GET_SQL = "SELECT * FROM member;";
    String FIND_BY_ID_SQL = "SELECT * FROM member where memberId = ?";

    public MemberDAO() throws SQLException { }

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

    public Member getById(int memberId) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(
            FIND_BY_ID_SQL,
            memberId
        );

        ResultSet rs =statement.executeQuery();

        rs.next();

        Member member = new Member(
            rs.getInt("memberId"),
            rs.getInt("clubId"),
            rs.getString("firstName"),
            rs.getString("lastName")
        );

        rs.close();

        return member;
    }
}
