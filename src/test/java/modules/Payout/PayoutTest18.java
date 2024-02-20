package modules.Payout;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest18 extends Payout implements PayoutCase {

    private double bet, payout;
    private final int testCase = 18, payoutOdds = 5, betOption = 6;
    private final double[] chipValueList = new double[15];
    private boolean isTwoDiceComboWin = false;

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        for (int i = 1; i <= betOption; i++) {
            for (int j = 1; j <= betOption; j++) {
                if (i < j) EventHandler.click(DealerTable.BettingOption.getTwoDiceCombo(i, j));
            }
        }
    }

    public void getBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        int index = 0;
        for (int i = 1; i <= betOption; i++) {
            for (int j = 1; j <= betOption; j++) {
                if (i < j) chipValueList[index++] = getChipValue(DealerTable.BettingChip.getTwoDiceCombo(i, j));
            }
        }
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        int index = 0;
        for (int i = 1; i <= betOption; i++) {
            for (int j = 1; j <= betOption; j++) {
                if (i < j) {
                    if (RoundCondition.isTwoDiceComboWin(roundResult, i, j)) {
                        double winBet = chipValueList[index++];
                        bet += winBet;
                        payout += winBet + (winBet * payoutOdds);
                        addWin(winBet, payoutOdds);
                        isTwoDiceComboWin = true;
                    }
                }
            }
        }
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!isTwoDiceComboWin) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
