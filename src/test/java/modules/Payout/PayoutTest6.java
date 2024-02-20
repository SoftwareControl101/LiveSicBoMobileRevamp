package modules.Payout;

import globals.BettingOption;
import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.PayoutCase;

public class PayoutTest6 extends Payout implements PayoutCase {

    private double bet, payout;
    private final int testCase = 6, payoutOdds = 24;
    private final String betOption = BettingOption.ANY_TRIPLE;

    public int getTestCase() { return testCase; }

    public void setBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        EventHandler.click(DealerTable.BettingOption.getMainBet(betOption));
    }

    public void getBetOption() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;

        bet = getChipValue(DealerTable.BettingChip.getMainBet(betOption));
    }

    public void computeTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isAnyTripleWin(roundResult)) return;

        payout = bet + (bet * payoutOdds);
        addWin(bet, payoutOdds);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!RoundCondition.isAnyTripleWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String expectedResult = getExpectedResult();
        String actualResult = getActualResult();
        String otherInfo = getOtherInfo(bet, payoutOdds, payout);
        ResultHandler.setTestResult(testCase, 0, currentRoundResult, expectedResult, actualResult, tableInfo, otherInfo);
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

}
