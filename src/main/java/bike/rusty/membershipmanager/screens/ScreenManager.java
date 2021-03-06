package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;

/**
 * This class manages the screens that can be accessed and displays
 * the current screen.
 */
public class ScreenManager {
    private final MemberDAO memberDao;
    private final ClubDAO clubDao;
    private final ClassDAO classDao;

    IScreen currentScreen = null;

    /**
     * Creates a new screen manager.
     *
     * @param initialScreen The screen to start at.
     * @param classDao      The classDAO to interact with the class table.
     * @param clubDao       The clubDAO to interact with the club table.
     * @param memberDao     The memberDAO to interact with the member table.
     */
    public ScreenManager(
        IScreen initialScreen,
        ClassDAO classDao,
        ClubDAO clubDao,
        MemberDAO memberDao
    ) {
        this.currentScreen = initialScreen;
        this.classDao = classDao;
        this.clubDao = clubDao;
        this.memberDao = memberDao;
    }

    /**
     * Displays the first screen.
     *
     * @throws SQLException
     */
    public void start() throws SQLException {
        currentScreen.init(classDao, clubDao, memberDao, this);
        currentScreen.start();
    }

    /**
     * Used by the screens to switch to another screen.
     *
     * The screenmanager is only directly used at the beginning when the main screen is
     * shown. From that point, each screen is responsible for switching to the next screen
     * itself, by calling the changeScreen method.
     *
     * @param newScreen The screen to switch to
     * @throws SQLException
     */
    public void changeScreen(IScreen newScreen) throws SQLException {
        currentScreen = newScreen;
        currentScreen.init(classDao, clubDao, memberDao, this);
        currentScreen.start();
    }
}
