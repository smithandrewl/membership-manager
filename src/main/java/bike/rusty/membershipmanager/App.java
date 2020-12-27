package bike.rusty.membershipmanager;

import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.model.Club;

import java.sql.SQLException;

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

            System.out.println("Getting club information");
            Club club = clubDAO.getClub();

            System.out.println(club);


        } catch (SQLException e) {
            System.err.printf("Error opening database:%s", e.getMessage());
        }
    }
}
