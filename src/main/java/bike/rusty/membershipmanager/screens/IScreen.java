package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

import java.sql.SQLException;

/**
 * This interface specifies all methods that menu screens must
 * implement.
 */
public interface IScreen {
    /**
     * Initializes a screen with the DAO classes it will be using.
     *
     * @param classDAO      The class DAO so it can load/update/save/delete classes
     * @param clubDAO       The club DAO so it can load/update the club
     * @param memberDAO     The member DAO so it can load/update/save/delete members
     * @param screenManager A reference to the screen manager, so that this screen can switch to other screens.
     */
    void init(
        ClassDAO classDAO,
        ClubDAO clubDAO,
        MemberDAO memberDAO,
        ScreenManager screenManager
    );

    void start() throws SQLException;
}
