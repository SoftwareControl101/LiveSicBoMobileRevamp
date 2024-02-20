package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class GameTest6 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 6");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.BettingIsClosing);
        verifyDisplay(DealerTable.Button.PopUpConfirm);
        verifyDisplay(DealerTable.Button.PopUpNotNow);

        Component timer = DealerTable.Container.Timer;
        AssertHandler.assertTrue(GetHandler.getAttribute(timer, "class").contains("red"),
                "** \"" + timer.getName() + "\" " + timer.getType() + " is Red Color",
                "** \"" + timer.getName() + "\" " + timer.getType() + " is Not Red Color");

        System.out.println();
        EventHandler.click(DealerTable.Button.PopUpNotNow);
        EventHandler.click(DealerTable.Button.Back);
    }

}
