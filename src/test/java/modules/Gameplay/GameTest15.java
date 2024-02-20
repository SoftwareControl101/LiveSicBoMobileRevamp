package modules.Gameplay;

import pages.DealerTable;
import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.WaitHandler;

public class GameTest15 extends Gameplay {

    public static void verify() {
        System.out.println();

        byte count = 0;
        do {
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            System.out.println("Round Result: " + DataTypeHandler.toString(getRoundResult()));
            System.out.println("Count: " + (++count));
            if (count < 9) WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        } while (count < 9);

        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 15");
        System.out.println("Actual Results: ");

        verifyDisplay(GameLobby.Label.FindATable);

        AssertHandler.assertTrue(ConditionHandler.isUrlContains("/dealerPage"),
                "** Player is on the Lobby",
                "** Player is Not on the Lobby");

        System.out.println();
    }

}
