package modules.Gameplay;

import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.objects.Component;

public class GameTest9 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 9");
        System.out.println("Actual Results: ");

        waitBettingPhase(40, false);
        String targetTable = getTableName();

        EventHandler.click(DealerTable.Button.Back);
        EventHandler.click(GameLobby.Method.getDealerTable(targetTable), HandleCollection.WithException);

        verifyDisplay(DealerTable.Label.PlaceYourBetsPlease);
        verifyDisplay(DealerTable.Label.WelcomeAndGoodLuck);
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        verifyDisplay(DealerTable.Label.ShowTimer);

        Component bettingOptions = DealerTable.Container.BettingOptions;
        AssertHandler.assertTrue(GetHandler.getAttribute(bettingOptions, "class").contains("active"),
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Expanded",
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Not Expanded");

        Component expandShrink = DealerTable.Button.ExpandShrink;
        AssertHandler.assertFalse(GetHandler.getAttribute(expandShrink, "class").contains("disabled"),
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Enabled",
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Not Enabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
