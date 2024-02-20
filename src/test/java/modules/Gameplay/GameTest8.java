package modules.Gameplay;

import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.objects.Component;

public class GameTest8 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 8");
        System.out.println("Actual Results: ");

        waitBettingPhase(0, false);
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        String targetTable = getTableName();

        EventHandler.click(DealerTable.Button.Back);
        EventHandler.click(GameLobby.Method.getDealerTable(targetTable), HandleCollection.WithException);

        verifyDisplay(DealerTable.Label.NoMoreBets);
        verifyDisplay(DealerTable.Label.WelcomeAndGoodLuck);
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        verifyDisplay(DealerTable.Label.ShowDealing);

        Component bettingOptions = DealerTable.Container.BettingOptions;
        AssertHandler.assertFalse(GetHandler.getAttribute(bettingOptions, "class").contains("active"),
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Not Expanded",
                "** \"" + bettingOptions.getName() + "\" " + bettingOptions.getType() + " is Expanded");

        Component expandShrink = DealerTable.Button.ExpandShrink;
        AssertHandler.assertTrue(GetHandler.getAttribute(expandShrink, "class").contains("disabled"),
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Disabled",
                "** \"" + expandShrink.getName() + "\" " + expandShrink.getType() + " is Not Disabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
