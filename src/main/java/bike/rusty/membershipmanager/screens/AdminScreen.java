package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminScreen implements IScreen{
    private ClassDAO classDao;
    private ClubDAO clubDao;
    private MemberDAO memberDao;
    private ScreenManager screenManager;

    @Override
    public void init(ClassDAO classDAO, ClubDAO clubDAO, MemberDAO memberDAO, ScreenManager screenManager) {
        this.classDao = classDAO;
        this.clubDao = clubDAO;
        this.memberDao = memberDAO;
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
        System.out.println("Admin screen!");

        while(true) {
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