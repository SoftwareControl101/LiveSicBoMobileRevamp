package modules.BetInformation;

import globals.BettingOption;
import globals.RoundCondition;
import pages.BetDetails;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class BetInfoTest3  extends BetInformation {

    static int singleDiceBet = 4, specificDouble = 3, specificTriple = 2, threeDiceTotal = 14;
    static String smallBet = BettingOption.SMALL, oddBet = BettingOption.ODD, tripleBet = BettingOption.ANY_TRIPLE;
    static int[] twoDiceCombo = new int[]{1, 2};

    public static void placeBet() {
        boolean isError = true;
        do {
            try {
                waitBettingPhase(30, false);
                WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
                EventHandler.click(DealerTable.BettingOption.getSingleDice(singleDiceBet));
                EventHandler.click(DealerTable.BettingOption.getSpecificDouble(specificDouble));
                EventHandler.click(DealerTable.BettingOption.getSpecificTriple(specificTriple));
                EventHandler.click(DealerTable.BettingOption.getThreeDiceTotal(threeDiceTotal));
                EventHandler.click(DealerTable.BettingOption.getTwoDiceCombo(twoDiceCombo[0], twoDiceCombo[1]));
                EventHandler.click(DealerTable.BettingOption.getMainBet(smallBet));
                EventHandler.click(DealerTable.BettingOption.getMainBet(oddBet));
                EventHandler.click(DealerTable.BettingOption.getMainBet(tripleBet));
                EventHandler.click(DealerTable.Button.Confirm);
                waitRoundResult();
                isError = false;
            } catch (Exception e) { PrintHandler.printError("Failed to place a bet"); }
        } while (isError);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: BET INFORMATION");
        System.out.println("Test Case: 3");
        System.out.println("Other Information: " + tableName + " #" + roundId + " " + DataTypeHandler.toString(roundResult));
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(BetDetails.Label.BetDetails, 150);
        verifyDisplay(BetDetails.Button.Back);

        double expectedStake = totalBet;
        double actualStake = getCurrentStake();
        AssertHandler.assertEquals(expectedStake, actualStake,
                "** Stake is Correct: " + expectedStake + " == " + actualStake,
                "** Stake is Incorrect: " + expectedStake + " != " + actualStake);

        double expectedWinLoss = getExpectedWinLoss() - totalBet;
        double actualWinLoss = GetHandler.getDouble(BetDetails.Label.WinLoss);
        AssertHandler.assertEquals(expectedWinLoss, actualWinLoss,
                "** Win/Loss is Correct: " + expectedWinLoss + " == " + actualWinLoss,
                "** Win/Loss is Incorrect: " + expectedWinLoss + " != " + actualWinLoss);

        verifyDisplay(BetDetails.Container.BettingOptions);

        int expectedBetSize = 8;
        int actualBetSize = GetHandler.getElements(BetDetails.Label.BettingChips).size();
        AssertHandler.assertEquals(expectedBetSize, actualBetSize,
                "** Betting Chips is Correct: " + expectedBetSize + " == " + actualBetSize,
                "** Betting Chips is Incorrect: " + expectedBetSize + " != " + actualBetSize);

        Component winBettingOptions = BetDetails.Container.WinBettingOptions;
        AssertHandler.assertFalse(ConditionHandler.isEmpty(winBettingOptions),
                "** Win Betting Options is Correct: " + GetHandler.getElements(winBettingOptions).size(),
                "** Win Betting Options is Incorrect: " + 0);

        System.out.println();
    }

    private static double getExpectedWinLoss() {
        double expectedWinLoss = 0.0;

        expectedWinLoss += getPayout(getSingleMultiplier(), RoundCondition.isSingleDiceWin(roundResult, singleDiceBet),
                DealerTable.BettingChip.getSingleDice(singleDiceBet));
        expectedWinLoss += getPayout(8, RoundCondition.isSpecificDoubleWin(roundResult, specificDouble),
                DealerTable.BettingChip.getSpecificDouble(specificDouble));
        expectedWinLoss += getPayout(150, RoundCondition.isSpecificTripleWin(roundResult, specificTriple),
                DealerTable.BettingChip.getSpecificTriple(specificTriple));
        expectedWinLoss += getPayout(12, RoundCondition.isThreeDiceTotalWin(roundResult, threeDiceTotal),
                DealerTable.BettingChip.getThreeDiceTotal(threeDiceTotal));
        expectedWinLoss += getPayout(5, RoundCondition.isTwoDiceComboWin(roundResult, twoDiceCombo[0], twoDiceCombo[1]),
                DealerTable.BettingChip.getTwoDiceCombo(twoDiceCombo[0], twoDiceCombo[1]));
        expectedWinLoss += getPayout(1, RoundCondition.isSmallWin(roundResult),
                DealerTable.BettingChip.getMainBet(smallBet));
        expectedWinLoss += getPayout(1, RoundCondition.isOddWin(roundResult),
                DealerTable.BettingChip.getMainBet(oddBet));
        expectedWinLoss += getPayout(24, RoundCondition.isAnyTripleWin(roundResult),
                DealerTable.BettingChip.getMainBet(tripleBet));

        return expectedWinLoss;
    }

    private static double getPayout(int multiplier, boolean condition, Component chipValue) {
        if (condition) {
            int bet = getChipValue(chipValue);
            return bet * multiplier + bet;
        }
        return 0;
    }

    private static int getSingleMultiplier() {
        int total = 0;
        for (int num : roundResult) if (num == singleDiceBet) ++total;
        return total;
    }

}
