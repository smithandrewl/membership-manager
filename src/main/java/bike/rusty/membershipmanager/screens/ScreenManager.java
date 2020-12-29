package bike.rusty.membershipmanager.screens;

import java.util.Vector;

public class ScreenManager {
    IScreen currentScreen = null;

    public ScreenManager(IScreen initialScreen, Vector<IScreen> screens) {
        this.currentScreen = initialScreen;
    }

    public void start() {
        currentScreen.entering();
        currentScreen.start();
    }
    public void changeScreen(IScreen newScreen) {
        currentScreen.exiting();
        currentScreen = newScreen;
        currentScreen.entering();
        currentScreen.start();
    }
}
