package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * The main menu screen.
 *
 * The main menu screen displays a menu. Each selection from the main menu
 * hands control to a different screen.  Selecting 1. for Admin, would
 * hand control to the AdminScreen class.
 */
public class MainScreen implements IScreen{
    private ClubDAO clubDAO;
    private ScreenManager screenManager;


    @Override
    public void init(
        ClassDAO      classDAO,
        ClubDAO       clubDAO,
        MemberDAO     memberDAO,
        ScreenManager screenManager
    ) {
        this.clubDAO       = clubDAO;
        this.screenManager = screenManager;
    }

    @Override
    public void start() throws SQLException {
        // You can make neat text like this using this online ASCII art generator:
        // http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
        //
        // NOTE: String.join is used to neatly format a multiline string.
        //       The first parameter is a string that will be used to separate the parameters
        //       passed to String.join.  In this case, we want the art to be displayed on multiple
        //       lines, so we use "\n" as the delimiter.
        //
        //       \n in a string is a special character which causes a newline to be displayed.
        //       System.out.println("Bob") is more or less the same as typing System.out.print("Bob\n")
        System.out.println(
            String.join(
                "\n",
                "                       _                   _     _               ",
                "  /\\/\\   ___ _ __ ___ | |__   ___ _ __ ___| |__ (_)_ __        ",
                " /    \\ / _ \\ '_ ` _ \\| '_ \\ / _ \\ '__/ __| '_ \\| | '_ \\  ",
                "/ /\\/\\ \\  __/ | | | | | |_) |  __/ |  \\__ \\ | | | | |_) |   ",
                "\\/    \\/\\___|_| |_| |_|_.__/ \\___|_|  |___/_| |_|_| .__/     ",
                "                                                  |_|            ",
                "                                                                 ",
                "       /\\/\\   __ _ _ __   __ _  __ _  ___ _ __                 ",
                "      /    \\ / _` | '_ \\ / _` |/ _` |/ _ \\ '__|               ",
                "     / /\\/\\ \\ (_| | | | | (_| | (_| |  __/ |                  ",
                "     \\/    \\/\\__,_|_| |_|\\__,_|\\__, |\\___|_|               ",
                "                           |___/                                 "));



        while(true) {
            try {
                displayMenuPrompt();
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();

                System.out.println(choice);

                switch(choice) {
                    case 1:
                        switchToAdminScreen();
                        break;
                    case 2:
                        switchToMembersScreen();
                        break;
                    case 3:
                        switchToClassesScreen();
                        break;
                    case 4:
                        exitApplication();
                    default:
                        System.out.println("Error: Please enter a valid option!");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid numeric choice.");
            }
        }
    }

    /**
     * Shows the input prompt.
     * @throws SQLException
     */
    private void displayMenuPrompt() throws SQLException {
        System.out.println(
            String.join(
                "\n",
                "    Welcome to club '" + clubDAO.getClub().getName() + "' Please enter a number:",
                "               1. Administration",
                "               2. Members",
                "               3. Classes",
                "               4. Exit"
            )
        );
    }

    /**
     * Switches from the main screen to the admin screen.
     */
    public void switchToAdminScreen() throws SQLException {
        this.screenManager.changeScreen(
            new AdminScreen()
        );
    }


    /**
     * Switches from the main screen to the classes screen.
     */
    public void switchToClassesScreen() throws SQLException {
        this.screenManager.changeScreen(
            new ClassesScreen()
        );
    }

    /**
     * Switches from the main screen to the membersScreen.
     */
    public void switchToMembersScreen() throws SQLException {
        this.screenManager.changeScreen(
            new MembersScreen()
        );
    }

    /**
     * Exits the application.
     */
    public void exitApplication() {
        System.exit(0);
    }
}
