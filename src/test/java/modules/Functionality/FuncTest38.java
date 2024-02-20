package modules.Functionality;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;

public class FuncTest38 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 38");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Label.ShowDealing),
                "** Betting Timer Changed to \"Dealing\" After The Timer Ended",
                "** Betting Timer Did Not Changed to \"Dealing\" After The Timer Ended");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
