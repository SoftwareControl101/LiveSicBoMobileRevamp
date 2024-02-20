package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;

public class FuncTest39 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 39");
        System.out.println("Actual Results: ");

        double expectedBet = oldBet * 2;
        double actualBet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
        AssertHandler.assertEquals(expectedBet, actualBet,
                "** The Placed Bet is Doubled: " + oldBet + " --> " + actualBet,
                "** The Placed Bet is Not Doubled: " + oldBet + " --> " + actualBet);

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
