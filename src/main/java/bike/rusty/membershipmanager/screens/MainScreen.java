package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

public class MainScreen implements IScreen{
    private MemberDAO memberDAO;
    private ClassDAO classDAO;
    private ClubDAO clubDAO;

    @Override
    public void init(ClassDAO classDAO, ClubDAO clubDAO, MemberDAO memberDAO) {
        this.classDAO = classDAO;
        this.clubDAO = clubDAO;
        this.memberDAO = memberDAO;
    }

    @Override
    public void entering() {

    }

    @Override
    public void exiting() {

    }

    @Override
    public void start() {
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
                "       /\\/\\   __ _ _ __   __ _  __ _  ___ _ __                     ",
                "      /    \\ / _` | '_ \\ / _` |/ _` |/ _ \\ '__|                   ",
                "     / /\\/\\ \\ (_| | | | | (_| | (_| |  __/ |                      ",
                "     \\/    \\/\\__,_|_| |_|\\__,_|\\__, |\\___|_|                   ",
                "                           |___/                                 ",
                "               1. Administration",
                "               2. Classes",
                "               3. Members"
            )
        );
    }
}
