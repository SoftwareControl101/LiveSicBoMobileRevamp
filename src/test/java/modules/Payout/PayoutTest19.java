package modules.Payout;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest19 extends Payout implements PayoutCase {

    private double bet, payout;
    private final int testCase = 19, payoutOdds = 8, betOption = 6;
    private final double[] chipValueList = new double[6];
    private boolean isSpecificDoubleWin = false;

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        for (int i = 0; i < betOption; i++)
            EventHandler.click(DealerTable.BettingOption.getSpecificDouble(i + 1));
    }

    public void getBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        for (int i = 0; i < betOption; i++)
            chipValueList[i] = getChipValue(DealerTable.BettingChip.getSpecificDouble(i + 1));
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isAnyDoubleWin(roundResult)) return;

        for (int i = 0; i < betOption; i++) {
            if (RoundCondition.isSpecificDoubleWin(roundResult, (i + 1))) {
                bet = chipValueList[i];
                payout = bet + (bet * payoutOdds);
                addWin(bet, payoutOdds);
                isSpecificDoubleWin = true;
            }
        }
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isAnyDoubleWin(roundResult)) return;
        if (!isSpecificDoubleWin) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
