package bike.rusty.membershipmanager;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.screens.MainScreen;
import bike.rusty.membershipmanager.screens.ScreenManager;

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
            ClubDAO   clubDAO   = new ClubDAO();
            MemberDAO memberDAO = new MemberDAO();
            ClassDAO  classDAO  = new ClassDAO();

            MainScreen mainScreen = new MainScreen();

            ScreenManager screenManager = new ScreenManager(
                mainScreen,
                classDAO,
                clubDAO,
                memberDAO
            );

            screenManager.start();
        } catch (SQLException e) {
            System.err.printf("Error opening database:%s", e.getMessage());
        }
    }
}
