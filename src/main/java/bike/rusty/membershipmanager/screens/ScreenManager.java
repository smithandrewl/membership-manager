package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;
import java.util.Vector;

public class ScreenManager {
    private final MemberDAO memberDao;
    private final ClubDAO clubDao;
    private final ClassDAO classDao;

    IScreen currentScreen = null;

    public ScreenManager(
        IScreen initialScreen,
        Vector<IScreen> screens,
        ClassDAO classDao,
        ClubDAO clubDao,
        MemberDAO memberDao
    ) {
        this.currentScreen = initialScreen;
        this.classDao = classDao;
        this.clubDao = clubDao;
        this.memberDao = memberDao;
    }

    public void start() throws SQLException {
        currentScreen.init(classDao, clubDao, memberDao);
        currentScreen.entering();
        currentScreen.start();
    }
    public void changeScreen(IScreen newScreen) throws SQLException {
        currentScreen.exiting();
        currentScreen = newScreen;
        currentScreen.init(classDao, clubDao, memberDao);
        currentScreen.entering();
        currentScreen.start();
    }
}
