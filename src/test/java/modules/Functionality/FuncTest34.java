package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.*;

public class FuncTest34 extends Functionality {

    static String oldChip;

    public static void checkTheBettingChip() {
        WaitHandler.wait(2);
        oldChip = GetHandler.getAttribute(DealerTable.Container.BigBettingChip, "class");
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 34");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.BetsAccepted);

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);

        double bet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
        double totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        AssertHandler.assertEquals(bet, totalBet,
                "** Total Bet is Displayed According to Player's Bet: " + bet + " == " + totalBet,
                "** Total Bet is Not Displayed According to Player's Bet: " + bet + " != " + totalBet);

        double balance = oldBalance - totalBet;
        AssertHandler.assertEquals(balance, GetHandler.getDouble(DealerTable.Label.BalanceValue),
                "** Placed Bet Amount is Deducted on the Available Balance",
                "** Placed Bet Amount is Not Deducted on the Available Balance");

        String chip = GetHandler.getAttribute(DealerTable.Container.BigBettingChip, "class");
        AssertHandler.assertNotEquals(oldChip, chip,
                "** The Design of Chip is Different Compare to the Unconfirmed Bet",
                "** The Design of Chip is Not Different Compare to the Unconfirmed Bet");

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
