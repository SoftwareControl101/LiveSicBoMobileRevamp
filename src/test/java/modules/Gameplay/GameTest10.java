package modules.Gameplay;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class GameTest10 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 10");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        int expectedStartTime = 45;
        int actualStartTime = GetHandler.getInt(DealerTable.Label.ShowTimer);
        AssertHandler.assertEquals(expectedStartTime, actualStartTime,
                "** Start Time of Betting Timer is Correct: " + expectedStartTime + " == " + actualStartTime,
                "** Start Time of Betting Timer is Incorrect: " + expectedStartTime + " != " + actualStartTime);

        verifyDisplay(DealerTable.Label.PlaceYourBetsPlease);
        verifyDisplay(DealerTable.Label.ShowTimer);

        Component bettingOptions = DealerTable.Container.BettingOptions;
        AssertHandler.assertTrue(GetHandler.getAttribute(bettingOptions, "class").contains("active"),
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Expanded",
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Not Expanded");

        Component expandShrink = DealerTable.Button.ExpandShrink;
        AssertHandler.assertFalse(GetHandler.getAttribute(expandShrink, "class").contains("disabled"),
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Enabled",
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Not Enabled");

        String bettingOption = BettingOption.EVEN;
        EventHandler.click(DealerTable.BettingOption.getMainBet(bettingOption));
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.BettingChip.getMainBet(bettingOption)),
                "** Can Place a Bet on Any Betting Option",
                "** Can Not Place a Bet on Any Betting Option");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
