package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class FuncTest44 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 44");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        AssertHandler.assertTrue(GetHandler.getAttribute(DealerTable.Container.BigBettingChip, "class").contains("confirm"),
                "** The Placed Bet is Accepted",
                "** The Placed Bet is Not Accepted");

        double bet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
        double totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        AssertHandler.assertEquals(bet, totalBet,
                "** Total Bet is Displayed According to Player's Bet",
                "** Total Bet is Not Displayed According to Player's Bet");

        double expectedBalance = oldBalance - totalBet;
        double actualBalance = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        AssertHandler.assertEquals(expectedBalance, actualBalance,
                "** Placed Bet Amount is Deducted on the Available Balance: " + oldBalance + " --> " + actualBalance,
                "** Placed Bet Amount is Not Deducted on the Available Balance: " + oldBalance + " --> " + actualBalance);

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
