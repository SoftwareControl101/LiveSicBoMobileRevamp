package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;

public class FuncTest48 extends Functionality {

    static String bettingOption = BettingOption.BIG;
    static double oldBet;

    public static void placeABetOnSameBettingOptions() {
        oldBet = getChipValue(DealerTable.BettingChip.getMainBet(bettingOption));
        EventHandler.click(DealerTable.BettingOption.getMainBet(bettingOption));
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 48");
        System.out.println("Actual Results: ");

        double newBet = getChipValue(DealerTable.BettingChip.getMainBet(bettingOption));
        AssertHandler.assertTrue(newBet > oldBet,
                "** Placed Bet has Increased: " + oldBet + " --> " + newBet,
                "** Placed Bet has Increased: " + oldBet + " --> " + newBet);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
