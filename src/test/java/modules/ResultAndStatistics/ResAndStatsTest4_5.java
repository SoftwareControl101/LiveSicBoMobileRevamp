package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest4_5 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 5;
    private double oldEvenPercentage = 0.0, expectedEvenPercentage = 0.0, actualEvenPercentage = 0.0;
    private static int oddSize, evenSize, tripleSize;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        evenSize = getSize(Statistics.Container.EvenResults);
        oddSize = getSize(Statistics.Container.OddResults);
        tripleSize = getSize(Statistics.Container.TripleResults) / 2;
        expectedEvenPercentage = Math.round((evenSize / totalResultHistory) * 100);
        oldEvenPercentage = actualEvenPercentage;
        actualEvenPercentage = getPercentage(Statistics.Label.EvenPercentage);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!RoundCondition.isEvenWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = Double.toString(oldEvenPercentage);
        String expectedResult = Double.toString(expectedEvenPercentage);
        String actualResult = Double.toString(actualEvenPercentage);

        String info = (tableInfo + " O: " + oddSize + " E: " + evenSize + " T: " + tripleSize);
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
