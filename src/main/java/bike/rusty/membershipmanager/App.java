package bike.rusty.membershipmanager;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.db.model.Class;
import bike.rusty.membershipmanager.db.model.Club;
import bike.rusty.membershipmanager.db.model.Member;

import java.sql.SQLException;
import java.util.Vector;

/**
 * Membership Manager Example
 *
 */
public class App
{
    public static void main( String[] args )
    {

        try {
            ClubDAO clubDAO = new ClubDAO();
            MemberDAO memberDAO = new MemberDAO();
            ClassDAO classDAO = new ClassDAO();

            System.out.println("Getting club information");
            Club club = clubDAO.getClub();
            memberDAO.addMember(
                new Member(club.getClubId(), "Andrew", "Smith")
            );

            classDAO.addClass(
                new Class(
                    club.getClubId(),
                    "Club one",
                    "Test club"
                )
            );

            classDAO.addClass(
                new Class(
                    club.getClubId(),
                    "Club two",
                    "Test club"
                )
            );

            memberDAO.addMember(
                new Member(club.getClubId(), "Matt", "Smith")
            );

            Vector<Member> members = memberDAO.getMembers();

            System.out.println(club);
            System.out.println("Members:");

            for(Member member : members) {
                System.out.println(member);
            }

            System.out.println("Adding an s to each firstname");
            for(Member member : members) {
                Member updatedMember = new Member(
                    member.getMemberId(), member.getClubId(), member.getFirstName() + "s", member.getLastName()
                );

                memberDAO.updateMember(updatedMember);
            }
            Vector<Member> updatedMembers = memberDAO.getMembers();

            for(Member updatedMember : updatedMembers) {
                System.out.println(updatedMember);
            }

            System.out.println();

            Member firstMember = memberDAO.getById(1);

            System.out.println("Printing first member");
            System.out.println(firstMember);
            System.out.println();
            System.out.println();
            System.out.println("Classes:");

            for(Class clubClass : classDAO.getClasses()) {
                System.out.println(clubClass);
            }
        } catch (SQLException e) {
            System.err.printf("Error opening database:%s", e.getMessage());
        }
    }
}
