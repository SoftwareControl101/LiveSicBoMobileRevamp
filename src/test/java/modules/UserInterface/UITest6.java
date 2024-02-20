package modules.UserInterface;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.EventHandler;

public class UITest6 extends UserInterface {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 6");
        System.out.println("Actual Results: ");

        for (byte i = 1; i <= 6; i++)
            verifyDisplay(DealerTable.BettingOption.getSingleDice(i));

        for (byte i = 1; i <= 6; i++)
            for (int j = 1; j <= 6; j++)
                if (i < j) verifyDisplay(DealerTable.BettingOption.getTwoDiceCombo(i, j));

        for (byte i = 1; i <= 6; i++)
            verifyDisplay(DealerTable.BettingOption.getSpecificTriple(i));

        for (byte i = 1; i <= 6; i++)
            verifyDisplay(DealerTable.BettingOption.getSpecificDouble(i));

        for (byte i = 4; i <= 17; i++)
            verifyDisplay(DealerTable.BettingOption.getThreeDiceTotal(i));

        for (String bettingOption : BettingOption.MAIN_BET_LIST)
            verifyDisplay(DealerTable.BettingOption.getMainBet(bettingOption));

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
