package modules.Payout;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest10 extends Payout implements PayoutCase {

    private double bet, payout;
    private final int testCase = 10, payoutOdds = 12;
    private final int[] betOptionList = new int[]{7, 14};
    private final double[] chipValueList = new double[2];

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        for (int betOption : betOptionList)
            EventHandler.click(DealerTable.BettingOption.getThreeDiceTotal(betOption));
    }

    public void getBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        byte i = 0;
        for (int betOption : betOptionList)
            chipValueList[i++] = getChipValue(DealerTable.BettingChip.getThreeDiceTotal(betOption));
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isThreeDiceTotalWin(roundResult, betOptionList[0]) &&
                !RoundCondition.isThreeDiceTotalWin(roundResult, betOptionList[1])) return;

        bet = RoundCondition.isThreeDiceTotalWin(roundResult, betOptionList[0]) ? chipValueList[0] : chipValueList[1];
        payout = bet + (bet * payoutOdds);
        addWin(bet, payoutOdds);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isThreeDiceTotalWin(roundResult, betOptionList[0]) &&
                !RoundCondition.isThreeDiceTotalWin(roundResult, betOptionList[1])) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
