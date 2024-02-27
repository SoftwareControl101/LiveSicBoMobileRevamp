package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest4_3 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 3;
    private double oldSmallPercentage = 0.0, expectedSmallPercentage = 0.0, actualSmallPercentage = 0.0;
    private static int bigSize, smallSize, tripleSize;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        smallSize = getSize(Statistics.Container.SmallResults);
        tripleSize = getSize(Statistics.Container.TripleResults) / 2;
        bigSize = getSize(Statistics.Container.BigResults);
        expectedSmallPercentage = Math.round((smallSize / totalResultHistory) * 100);
        oldSmallPercentage = actualSmallPercentage;
        actualSmallPercentage = getPercentage(Statistics.Label.SmallPercentage);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!RoundCondition.isSmallWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = Double.toString(oldSmallPercentage);
        String expectedResult = Double.toString(expectedSmallPercentage);
        String actualResult = Double.toString(actualSmallPercentage);

        String info = (tableInfo + " B: " + bigSize + " S: " + smallSize + " T: " + tripleSize);
        ResultHandler.setTestResult(testCase, division, currentRoundResult, expectedResult, actualResult, info, oldResult);
        divisionList = DataTypeHandler.removeFromArray(division, divisionList);
        if (divisionList.length != 0) return;
        testCaseList = DataTypeHandler.removeFromArray(testCase, testCaseList);
    }

    public static void verify() {
        TestResult result = ResultHandler.getTestResult(testCase, division, Constants.Directory.RESULT_AND_STATS_PATH);

        System.out.println();
        System.out.println("Module: RESULT AND STATISTICS");
        System.out.println("Division: " + result.getDivision());
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Expected Result: " + result.getExpectedResult());

        String message = "Actual Result: " + result.getOtherInfo() + " --> " + result.getActualResult();
        double expectedPercentage = Double.parseDouble(result.getExpectedResult());
        double actualPercentage = Double.parseDouble(result.getActualResult());
        AssertHandler.assertEquals(expectedPercentage, actualPercentage, message, message);

        System.out.println();
    }

}
