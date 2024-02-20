package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class GameTest7 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 7");
        System.out.println("Actual Results: ");

        int totalResult = getTotalResult();
        int betResultTotal = GetHandler.getInt(DealerTable.Label.BetResultTotal);
        verifyDisplay(DealerTable.Label.BetResultDices);

        AssertHandler.assertEquals(betResultTotal, totalResult,
                "** Round Result Total is Displayed and Correct: " + betResultTotal + " == " + totalResult,
                "** Round Result Total is Not Displayed and Incorrect: " + betResultTotal + " != " + totalResult);

        Component winBetOptions = DealerTable.Container.WinBettingOptions;
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(winBetOptions),
                "** \"" + winBetOptions.getName() + "\" " + winBetOptions.getType() + " is Displayed and Highlighted",
                "** \"" + winBetOptions.getName() + "\" " + winBetOptions.getType() + " is Not Displayed and Not Highlighted");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
