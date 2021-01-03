package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Implements the Admin menu screen.
 */
public class AdminScreen implements IScreen{
    private ClubDAO clubDao;

    @Override
    public void init(
        ClassDAO classDAO,
        ClubDAO clubDAO,
        MemberDAO memberDAO,
        ScreenManager screenManager
    ) {
        this.clubDao = clubDAO;
    }

    @Override
    public void start() throws SQLException {
        System.out.println("Admin screen!");

        while(true) {
            // Try catch statements are used for error handling.
            // Any part of the 'try' block can 'throw' an Exception, which holds data about an error.
            // The 'catch' block below is responsible for handling the error.
            //
            // If a method knows an exception may be thrown, but does not want to directly handle it,
            // then it can add 'throws ExceptionName' to the end of the method definition.
            // In this case, it would be a SQLException, so we add 'throws SQLException' to the method definition.
            //
            // An Exception 'bubbles' up this way until it is handled somewhere else, or an application crash will
            // occur and the Exception will be displayed.
            try {

                System.out.println("Please enter a number:");
                System.out.println("1. Change the club name");
                System.out.println("2. Return to the main menu");

                Scanner scanner = new Scanner(System.in);

                int choice = scanner.nextInt();

                switch(choice) {
                    case 1:
                        while(true) {
                            Scanner innerScanner = new Scanner(System.in);
                            try {
                                System.out.println("Please enter the new name: ");
                                String newName = innerScanner.nextLine();

                                // Use the Club DAO to update the name of the club.
                                clubDao.updateName(newName);
                                return;
                            } catch (Exception e) {
                                System.out.println("Error: Please enter a valid name!" + e.getMessage());
                            }
                        }
                    case 2:
                        return;
                    default:
                        System.out.println("Error: Please enter a valid option!");
                }
            } catch(Exception e) {
                System.out.println("Please enter a valid numeric value");
            }

        }

    }
}
