package modules.Gameplay;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Component;

public class GameTest11 extends Gameplay {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 11");
        System.out.println("Actual Results: ");

        waitBettingPhase(40, true);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);

        for (byte i = 0; i < 5; i++) {
            verifyPlaceBet(DealerTable.BettingOption.getMainBet(BettingOption.MAIN_BET_LIST[i]),
                    DealerTable.BettingChip.getMainBet(BettingOption.MAIN_BET_LIST[i]));
        }

        for (byte i = 4; i <= 17; i++) {
            verifyPlaceBet(DealerTable.BettingOption.getThreeDiceTotal(i),
                    DealerTable.BettingChip.getThreeDiceTotal(i));
        }

        for (byte i = 1; i <= 6; i++) {
            verifyPlaceBet(DealerTable.BettingOption.getSpecificDouble(i),
                    DealerTable.BettingChip.getSpecificDouble(i));
        }

        for (byte i = 1; i <= 6; i++) {
            verifyPlaceBet(DealerTable.BettingOption.getSpecificTriple(i),
                    DealerTable.BettingChip.getSpecificTriple(i));
        }

        waitBettingPhase(40, true);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);

        for (byte i = 1; i <= 6; i++) {
            verifyPlaceBet(DealerTable.BettingOption.getSingleDice(i),
                    DealerTable.BettingChip.getSingleDice(i));
        }

        for (byte i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i < j) {
                    verifyPlaceBet(DealerTable.BettingOption.getTwoDiceCombo(i, j),
                            DealerTable.BettingChip.getTwoDiceCombo(i, j));
                }
            }
        }

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

    private static void verifyPlaceBet(Component bettingOption, Component bettingChip) {
        EventHandler.click(bettingOption);
        String bettingOptionName = bettingOption.getName();
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(bettingChip),
                "** Can Place a Bet on " + bettingOptionName,
                "** Can Not Place a Bet on " + bettingOptionName);
    }

}
