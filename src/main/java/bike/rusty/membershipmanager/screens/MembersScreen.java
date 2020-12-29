package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;
import bike.rusty.membershipmanager.db.model.Member;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;

public class MembersScreen implements IScreen {
    private ClubDAO clubDao;
    private MemberDAO memberDao;

    @Override
    public void init(
        ClassDAO      classDAO,
        ClubDAO       clubDAO,
        MemberDAO     memberDAO,
        ScreenManager screenManager
    ) {
        this.clubDao   = clubDAO;
        this.memberDao = memberDAO;
    }

    @Override
    public void start() throws SQLException {
        System.out.println("Members screen!");

        while(true) {
            try {

                System.out.println("Please enter a number:");
                System.out.println("1. List all members");
                System.out.println("2. Add a member");
                System.out.println("3. Delete a member");
                System.out.println("4. Return to the main menu");

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
                        break;
                    case 2:
                        Scanner nestedScanner = new Scanner(System.in);

                        System.out.println("Adding a new member:");
                        System.out.println("Please enter a first name");
                        String firstName = nestedScanner.nextLine();
                        System.out.println("Please enter a last name");
                        String lastName = nestedScanner.nextLine();

                        memberDao.addMember(new Member(clubDao.getClub().getClubId(), firstName, lastName));

                        break;
                    case 3:
                        boolean finished = false;
                        while(!finished) {
                            try {
                                System.out.println("Delete a member");
                                Scanner deleteScanner = new Scanner(System.in);
                                System.out.println("Please enter the id of the member to delete:");
                                int id = deleteScanner.nextInt();

                                Optional<Member> member = memberDao.getById(id);

                                if(member.isPresent()) {
                                    memberDao.delete(id);
                                    finished = true;

                                } else {
                                    System.out.printf("There is no user with an id of %s%n",id);
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter a valid number!");
                            }
                        }
                        break;
                    case 4:
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
