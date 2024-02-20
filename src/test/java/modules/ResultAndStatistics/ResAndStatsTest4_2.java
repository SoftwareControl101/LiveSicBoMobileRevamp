package modules.ResultAndStatistics;

import globals.RoundCondition;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

public class ResAndStatsTest4_2 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 2;
    private double oldTripleSBPercentage = 0.0, expectedTriplePercentage = 0.0, actualTripleSBPercentage = 0.0;
    private double oldTripleOEPercentage = 0.0, actualTripleOEPercentage = 0.0;
    private static int size;

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        size = getSize(Statistics.Container.TripleResults);
        expectedTriplePercentage = Math.round((((double) size / 2) / totalResultHistory) * 100);
        oldTripleSBPercentage = actualTripleSBPercentage;
        actualTripleSBPercentage = getPercentage(Statistics.Label.TripleSBPercentage);
        oldTripleOEPercentage = actualTripleOEPercentage;
        actualTripleOEPercentage = getPercentage(Statistics.Label.TripleOEPercentage);
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!RoundCondition.isAnyTripleWin(roundResult)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = oldTripleSBPercentage + "-" + oldTripleOEPercentage;
        String expectedResult = Double.toString(expectedTriplePercentage);
        String actualResult = actualTripleSBPercentage + "-" + actualTripleOEPercentage;

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

        for (int i = 0; i < 2; i++) {
            String oldPercentageText = result.getOtherInfo().split("-")[i];
            String actualPercentageText = result.getActualResult().split("-")[i];
            String message = "Actual Result: " + oldPercentageText + " --> " + actualPercentageText;
            double expectedPercentage = Double.parseDouble(result.getExpectedResult());
            double actualPercentage = Double.parseDouble(actualPercentageText);
            AssertHandler.assertEquals(expectedPercentage, actualPercentage, message, message);
        }

        System.out.println();
    }

}
