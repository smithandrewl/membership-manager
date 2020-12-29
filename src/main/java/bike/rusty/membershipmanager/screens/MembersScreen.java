package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.db.model.Member;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class MembersScreen implements IScreen {
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
        System.out.println("Members screen!");

        while(true) {
            try {

                System.out.println("Please enter a number:");
                System.out.println("1. List all members");
                System.out.println("2. Return to the main menu");

                Scanner scanner = new Scanner(System.in);

                int choice = scanner.nextInt();

                switch(choice) {
                    case 1:
                        Vector<Member> members = memberDao.getMembers();

                        if(members.isEmpty()) {
                            System.out.println("There are currently no members!");
                        } else {
                            System.out.println("Members:");
                            for(Member member : members) {
                                System.out.println("\t" + member);
                            }
                            System.out.println();
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
