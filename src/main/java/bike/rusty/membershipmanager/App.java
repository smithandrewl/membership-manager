package bike.rusty.membershipmanager;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.screens.MainScreen;
import bike.rusty.membershipmanager.screens.ScreenManager;

import java.sql.SQLException;

/**
 * Membership Manager Example.
 *
 * The DAO classes provide an interface to the database.
 * The screen manager and screen classes provide clean support for multiple screens (menus).
 *
 * This class creates the DAO classes for each database table
 * Initializes the screen manager with the first screen to show (the main screen).
 *
 * Note: the DAO classes are passed around as parameters throughout the application
 *       to avoid creating more than one instance of each.
 *
 */
public class App
{
    public static void main( String[] args )
    {

        try {
            // Initialize the DAO classes.
            //
            // NOTE: The first time a DAO class is initialized, it will create the database on disk with empty tables
            //
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

            // Pass control of the application over to the screenManager, which will display
            // the main menu.
            // The main menu will use the screenmanager and user input to change to additional screens (menus)
            screenManager.start();
        } catch (SQLException e) {
            System.err.printf("Error opening database:%s", e.getMessage());
        }
    }
}
