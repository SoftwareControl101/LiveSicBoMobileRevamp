package modules.Functionality;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.*;

public class FuncTest42 extends Functionality {

    static double balanceAfterBetting, balanceAfterDealing;

    public static void waitUntilBetWins() {
        balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        while (!RoundCondition.isBigWin(getRoundResult())) {
            placeAndConfirmAnyBettingOptions();
            balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        }
        WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        balanceAfterDealing = getUpdatedBalance();
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 42");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(balanceAfterDealing > balanceAfterBetting,
                "** Total Balance is Increased",
                "** Total Balance is Not Increased");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
