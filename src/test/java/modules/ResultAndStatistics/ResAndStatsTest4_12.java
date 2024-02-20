package modules.ResultAndStatistics;

import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.ResultHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

import java.util.Arrays;

public class ResAndStatsTest4_12 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 12;
    private int[] oldHotNumberList = new int[4], oldHotCounterList = new int[4], hotNumberList = new int[4], actualHotCounterList = new int[4];
    private final int[] expectedHotCounterList = new int[4];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        oldHotNumberList = Arrays.copyOf(hotNumberList, hotNumberList.length);
        oldHotCounterList = Arrays.copyOf(actualHotCounterList, actualHotCounterList.length);
        hotNumberList = GetHandler.getIntArray(Statistics.Label.HotNumbers);
        actualHotCounterList = GetHandler.getIntArray(Statistics.Label.HotCounters);
        for (int i = 0; i < hotNumberList.length; i++)
            expectedHotCounterList[i] = getSize(Statistics.Method.getHotResults(hotNumberList[i]));
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!DataTypeHandler.find(DataTypeHandler.sum(roundResult), oldHotNumberList)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = getResultFromArray(oldHotNumberList, oldHotCounterList);
        String expectedResult = getResultFromArray(hotNumberList, expectedHotCounterList);
        String actualResult = getResultFromArray(hotNumberList, actualHotCounterList);

        ResultHandler.setTestResult(testCase, division, currentRoundResult, expectedResult, actualResult, tableInfo, oldResult);
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

        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        int[] actualCounterResultList = actualResult[1];

        int[][] expectedResult = Arrays.copyOf(getArrayFromResult(result.getExpectedResult()), getArrayFromResult(result.getExpectedResult()).length);
        int[] expectedNumberResultList = expectedResult[0];
        int[] expectedCounterResultList = expectedResult[1];

        int totalResult = DataTypeHandler.sum(DataTypeHandler.toIntegerArray(result.getRoundResult(), " "));
        int actualIndex = DataTypeHandler.getIndex(totalResult, actualNumberResultList);
        int expectedIndex = DataTypeHandler.getIndex(totalResult, expectedNumberResultList);

        AssertHandler.assertEquals(expectedCounterResultList[expectedIndex], actualCounterResultList[actualIndex], message, message);

        System.out.println();
    }

}