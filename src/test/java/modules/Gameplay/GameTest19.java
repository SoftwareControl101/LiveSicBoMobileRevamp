package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;

public class GameTest19 extends Gameplay {

    public static void clickBackButton() {
        WaitHandler.wait(2);
        EventHandler.click(DealerTable.Button.Back);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 19");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.YourBetsAreBeingSettled);

        AssertHandler.assertTrue(ConditionHandler.isUrlContains("/sicbo"),
                "** Player is Seated on the Current Table",
                "** Player is Not Seated on the Current Table");

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
