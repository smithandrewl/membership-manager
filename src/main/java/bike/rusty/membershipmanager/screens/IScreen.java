package bike.rusty.membershipmanager.screens;

import bike.rusty.membershipmanager.db.dao.ClassDAO;
import bike.rusty.membershipmanager.db.dao.ClubDAO;
import bike.rusty.membershipmanager.db.dao.MemberDAO;

public interface IScreen {
    void init(
        ClassDAO classDAO,
        ClubDAO clubDAO,
        MemberDAO memberDAO
    );

    void entering();
    void exiting();
    void start();
}
