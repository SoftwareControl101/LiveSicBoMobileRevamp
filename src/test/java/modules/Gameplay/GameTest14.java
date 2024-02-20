package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.*;

public class GameTest14 extends Gameplay {

    public static void verify() {
        System.out.println();

        byte count = 0;
        do {
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            System.out.println("Round Result: " + DataTypeHandler.toString(getRoundResult()));
            System.out.println("Count: " + (++count));
            WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        } while (count < 8);

        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 14");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.GiveItATry);

        AssertHandler.assertTrue(ConditionHandler.isUrlContains("/sicbo"),
                "** Player is Seated on the Current Table",
                "** Player is Not Seated on the Current Table");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
