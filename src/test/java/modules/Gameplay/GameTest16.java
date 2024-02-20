package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;

public class GameTest16 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 16");
        System.out.println("Actual Results: ");

        EventHandler.click(DealerTable.BettingOption.getSpecificTriple(4));
        WaitHandler.waitVisibility(DealerTable.Container.Notification, 150);
        verifyDisplay(DealerTable.Label.ExceededTheMaxBet);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
