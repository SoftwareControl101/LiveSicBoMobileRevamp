package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Component;

public class FuncTest33 extends Functionality {

    public static void placeABetOnFourOrMoreBettingOptions() {
        waitBettingPhase(45, true);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.BIG));
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.SMALL));
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.ODD));
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.EVEN));
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 33");
        System.out.println("Actual Results: ");

        verifyUndone(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
        verifyUndone(DealerTable.BettingChip.getMainBet(BettingOption.SMALL));
        verifyUndone(DealerTable.BettingChip.getMainBet(BettingOption.ODD));
        verifyUndone(DealerTable.BettingChip.getMainBet(BettingOption.EVEN));

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

    private static void verifyUndone(Component bettingChip) {
        AssertHandler.assertFalse(ConditionHandler.isDisplayed(bettingChip),
                "** " + bettingChip.getName() + " is Removed and Undone",
                "** " + bettingChip.getName() + " is Not Removed and Not Undone");
    }

}
