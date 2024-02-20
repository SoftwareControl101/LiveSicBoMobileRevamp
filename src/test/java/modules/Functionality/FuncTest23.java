package modules.Functionality;

import pages.DealerTable;
import pages.SwitchTable;
import utilities.handlers.*;

public class FuncTest23 {

    public static void goToOtherLiveProducts() {
        EventHandler.click(SwitchTable.Button.InactiveGames,
                GetHandler.getElementByRandom(SwitchTable.Button.InactiveGames));
        WaitHandler.wait(3);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 23");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(SwitchTable.Method.getTableCards(true)),
                "** Available Tables of The Selected Product are Displayed",
                "** Available Tables of The Selected Product are Displayed");

        System.out.println();
        EventHandler.click(50, 50);
        WaitHandler.waitInvisibility(SwitchTable.Container.JumpTable, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
