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

public class ResAndStatsTest4_14 extends ResAndStats implements ResAndStatsCase {

    private static final int testCase = 4, division = 14;
    private int[] oldColdNumberList = new int[4], oldColdCounterList = new int[4], coldNumberList = new int[4], actualColdCounterList = new int[4];
    private final int[] expectedColdCounterList = new int[4];

    public int getTestCase() { return testCase; }

    public int getDivision() { return division; }

    public void setStatistics() {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;

        oldColdNumberList = Arrays.copyOf(coldNumberList, coldNumberList.length);
        oldColdCounterList = Arrays.copyOf(actualColdCounterList, actualColdCounterList.length);
        coldNumberList = GetHandler.getIntArray(Statistics.Label.ColdNumbers);
        actualColdCounterList = GetHandler.getIntArray(Statistics.Label.ColdCounters);
        for (int i = 0; i < coldNumberList.length; i++)
            expectedColdCounterList[i] = getSize(Statistics.Method.getColdResults(coldNumberList[i]));
    }

    public void saveTestCase(int[] roundResult) {
        if (!DataTypeHandler.find(testCase, testCaseList)) return;
        if (!DataTypeHandler.find(division, divisionList)) return;
        if (!DataTypeHandler.find(DataTypeHandler.sum(roundResult), oldColdNumberList)) return;

        String currentRoundResult = DataTypeHandler.toString(roundResult);
        String oldResult = getResultFromArray(oldColdNumberList, oldColdCounterList);
        String expectedResult = getResultFromArray(coldNumberList, expectedColdCounterList);
        String actualResult = getResultFromArray(coldNumberList, actualColdCounterList);

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
        AssertHandler.assertTrue(isPassed(result), message, message);

        System.out.println();
    }

    private static boolean isPassed(TestResult result) {
        int[][] actualResult = Arrays.copyOf(getArrayFromResult(result.getActualResult()), getArrayFromResult(result.getActualResult()).length);
        int[] actualNumberResultList = actualResult[0];
        int[] actualCounterResultList = actualResult[1];
        int[][] expectedResult = Arrays.copyOf(getArrayFromResult(result.getExpectedResult()), getArrayFromResult(result.getExpectedResult()).length);
        int[] expectedNumberResultList = expectedResult[0];
        int[] expectedCounterResultList = expectedResult[1];

        int[] resultArray = DataTypeHandler.toIntegerArray(result.getRoundResult(), " ");
        int totalResult = DataTypeHandler.sum(resultArray);

        if (DataTypeHandler.find(totalResult, actualNumberResultList)) return false;
        for (int i = 0; i < actualNumberResultList.length; i++) {
            if (actualNumberResultList[i] != expectedNumberResultList[i]) return false;
            if (expectedCounterResultList[i] != 0 && actualCounterResultList[i] != expectedCounterResultList[i]) return false;
        }

        return true;
    }

}