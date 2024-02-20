package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;

public class GameTest1 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 3");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.WelcomeAndGoodLuck);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
