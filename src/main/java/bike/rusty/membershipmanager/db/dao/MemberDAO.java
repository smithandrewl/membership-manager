package bike.rusty.membershipmanager.db.dao;
import bike.rusty.membershipmanager.model.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MemberDAO extends BaseDAO {
    String GET_SQL = "SELECT * FROM member;";

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
}
