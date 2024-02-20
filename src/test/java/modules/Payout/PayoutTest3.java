package modules.Payout;

import globals.BettingOption;
import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest3 extends Payout implements PayoutCase {

    private double bet, payout;
    private final int testCase = 3, payoutOdds = 1;
    private final String betOption = BettingOption.EVEN;

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList) &&
                !DataTypeHandler.find(6, testCaseList)) return;

        EventHandler.click(DealerTable.BettingOption.getMainBet(betOption));
    }

    public void getBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList) &&
                !DataTypeHandler.find(6, testCaseList)) return;

        bet = getChipValue(DealerTable.BettingChip.getMainBet(betOption));
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList) &&
                !DataTypeHandler.find(6, testCaseList)) return;
        if (!RoundCondition.isEvenWin(roundResult)) return;

        payout = bet + (bet * payoutOdds);
        addWin(bet, payoutOdds);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isEvenWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
