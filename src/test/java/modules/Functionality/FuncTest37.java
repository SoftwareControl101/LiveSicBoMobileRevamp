package modules.Functionality;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class FuncTest37 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 37");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        int startTime = GetHandler.getInt(DealerTable.Label.ShowTimer);
        AssertHandler.assertEquals(45, startTime,
                "** Start Time of Betting Timer is Correct: " + startTime,
                "** Start Time of Betting Timer is Incorrect: " + startTime);

        AssertHandler.assertFalse(GetHandler.getAttribute(DealerTable.Container.Timer, "class").contains("red"),
                "** Betting Timer is Green Color",
                "** Betting Timer is Not Green Color");

        waitBettingPhase(10, true);
        AssertHandler.assertTrue(GetHandler.getAttribute(DealerTable.Container.Timer, "class").contains("red"),
                "** Betting Timer is Red Color After Reaching Last 10 Seconds",
                "** Betting Timer is Not Red Color After Reaching Last 10 Seconds");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
