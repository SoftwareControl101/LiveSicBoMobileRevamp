package modules.Gameplay;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class GameTest12 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 12");
        System.out.println("Actual Results: ");

        Component betsAccepted = DealerTable.Label.BetsAccepted;
        Component bigBettingChip = DealerTable.BettingChip.getMainBet(BettingOption.BIG);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(betsAccepted),
                "** First \"" + betsAccepted.getName() + "\" is Displayed",
                "** First \"" + betsAccepted.getName() + "\" is Not Displayed");

        WaitHandler.wait(2);
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(bigBettingChip),
                "** First Bet (" + bigBettingChip.getName() + ") is Displayed",
                "** First Bet (" + bigBettingChip.getName() + ") is Not Displayed");

        double expectedTotalBet = getChipValue(bigBettingChip);
        double actualTotalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        AssertHandler.assertEquals(expectedTotalBet, actualTotalBet,
                "** First Bet Amount is Reflected in Total Bet: " + expectedTotalBet + " == " + actualTotalBet,
                "** First Bet Amount is Not Reflected in Total Bet: " + expectedTotalBet + " != " + actualTotalBet);

        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.EVEN));
        Component evenBettingChip = DealerTable.BettingChip.getMainBet(BettingOption.EVEN);
        EventHandler.click(DealerTable.Button.Confirm);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(betsAccepted),
                "** Second \"" + betsAccepted.getName() + "\" is Displayed",
                "** Second \"" + betsAccepted.getName() + "\" is Not Displayed");

        WaitHandler.wait(2);
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(evenBettingChip),
                "** Second Bet (" + evenBettingChip.getName() + ") is Displayed",
                "** Second Bet (" + evenBettingChip.getName() + ") is Not Displayed");

        expectedTotalBet += getChipValue(evenBettingChip);
        actualTotalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        AssertHandler.assertEquals(expectedTotalBet, actualTotalBet,
                "** Second Bet Amount is Reflected in Total Bet: " + expectedTotalBet + " == " + actualTotalBet,
                "** Second Bet Amount is Not Reflected in Total Bet: " + expectedTotalBet + " != " + actualTotalBet);

        double expectedBalance = balanceBeforeBetting - expectedTotalBet;
        double actualBalance = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        AssertHandler.assertEquals(expectedBalance, actualBalance,
                "** Total Bet is Deducted From The Total Balance: " + expectedBalance + " == " + actualBalance,
                "** Total Bet is Not Deducted From The Total Balance: " + expectedBalance + " != " + actualBalance);

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
