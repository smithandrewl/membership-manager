package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * The main menu screen.
 */
public class MainScreen implements IScreen{
    private MemberDAO memberDAO;
    private ClassDAO classDAO;
    private ClubDAO clubDAO;
    private ScreenManager screenManager;


    @Override
    public void init(ClassDAO classDAO, ClubDAO clubDAO, MemberDAO memberDAO, ScreenManager screenManager) {
        this.classDAO = classDAO;
        this.clubDAO = clubDAO;
        this.memberDAO = memberDAO;
        this.screenManager = screenManager;
    }

    @Override
    public void entering() {

    }

    @Override
    public void exiting() {

    }

    @Override
    public void start() throws SQLException {
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
