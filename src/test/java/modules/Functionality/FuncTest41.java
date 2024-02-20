package modules.Functionality;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class FuncTest41 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 41");
        System.out.println("Actual Results: ");

        double expectedBalance = oldBalance - (oldBet * 2);
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        double actualBalance = GetHandler.getDouble(DealerTable.Label.BalanceValue);

        AssertHandler.assertEquals(expectedBalance, actualBalance,
                "** The Doubled Bet is Deducted on the Total Balance: " + oldBalance + " --> " + actualBalance,
                "** The Doubled Bet is Not Deducted on the Total Balance: " + oldBalance + " --> " + actualBalance);

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
