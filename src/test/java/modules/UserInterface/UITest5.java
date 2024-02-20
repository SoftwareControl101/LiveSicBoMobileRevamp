package modules.UserInterface;

import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;

public class UITest5 extends UserInterface {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 5");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Container.Announcement);
        WaitHandler.waitVisibility(DealerTable.Label.NoMoreBets, 150);
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        verifyDisplay(DealerTable.Label.ShowDealing);
        assertGameUI();

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
