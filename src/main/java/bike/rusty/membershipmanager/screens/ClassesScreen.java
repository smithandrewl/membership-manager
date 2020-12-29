package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.db.model.Class;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class ClassesScreen implements IScreen {
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

        System.out.println("Classes screen!");

        while(true) {
            try {

                System.out.println("Please enter a number:");

                System.out.println("1. List classes");
                System.out.println("2. Add a class");
                System.out.println("3. Return to the main menu");
                Scanner scanner = new Scanner(System.in);

                int choice = scanner.nextInt();

                switch(choice) {
                    case 1:
                        Vector<Class> classes = classDao.getClasses();

                        if(classes.isEmpty()) {
                            System.out.println("There are currently no classes!");
                            System.out.println();
                        } else {
                            System.out.println("Classes:");
                            for(Class clubClass : classes) {
                                System.out.println("\t" + clubClass);
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println("Adding a class:");
                        while(true) {
                            Scanner addScanner = new Scanner(System.in);
                            System.out.println("Please enter a class name");
                            String name = addScanner.nextLine();
                            System.out.println("Please enter a class description");
                            String description = addScanner.nextLine();

                            classDao.addClass(new Class(
                                clubDao.getClub().getClubId(),
                                name,
                                description
                            ));

                            System.out.println();
                            break;
                        }

                        break;
                    case 3:
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
