package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class FuncTest40 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 40");
        System.out.println("Actual Results: ");

        double bet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
        double expectedBalance = oldBalance - bet;
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        double actualBalance = GetHandler.getDouble(DealerTable.Label.BalanceValue);

        AssertHandler.assertEquals(expectedBalance, actualBalance,
                "** The Placed Bet is Deducted on the Total Balance: " + oldBalance + " --> " + actualBalance,
                "** The Placed Bet is Not Deducted on the Total Balance: " + oldBalance + " --> " + actualBalance);

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
