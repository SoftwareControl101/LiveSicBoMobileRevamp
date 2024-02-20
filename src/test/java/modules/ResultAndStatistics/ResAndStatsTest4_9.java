package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest4_9 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 9;
    private double oldDice4Percentage = 0.0, expectedDice4Percentage = 0.0, actualDice4Percentage = 0.0;
    private static int size;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        size = getSize(Statistics.Container.Dice4Results);
        expectedDice4Percentage = Math.round((size / (totalResultHistory * 3)) * 100);
        oldDice4Percentage = actualDice4Percentage;
        actualDice4Percentage = getPercentage(Statistics.Label.Dice4Percentage);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!RoundCondition.isSingleDiceWin(roundResult, 4)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = Double.toString(oldDice4Percentage);
        String expectedResult = Double.toString(expectedDice4Percentage);
        String actualResult = Double.toString(actualDice4Percentage);

        ResultHandler.setTestResult(testCase, division, currentRoundResult, expectedResult, actualResult, (tableInfo + " " + totalResultHistory + " " + size), oldResult);
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
