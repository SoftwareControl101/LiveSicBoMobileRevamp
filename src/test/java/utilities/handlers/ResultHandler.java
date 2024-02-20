package utilities.handlers;

import org.testng.SkipException;
import utilities.objects.TestResult;
import utilities.settings.Variables;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ResultHandler extends Variables {

    /***************************************************************************************************************
     * The 'setTestResult' method is used to add test results to the list.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void setTestResult(int testCase, int division, String roundResult, String expectedResult,
                                     String actualResult, String tableInfo, String otherInfo) {
        try {
            TestResult result = new TestResult();
            result.setTestCase(testCase);
            result.setDivision(division);
            result.setRoundResult(roundResult);
            result.setExpectedResult(expectedResult);
            result.setActualResult(actualResult);
            result.setTableInfo(tableInfo);
            result.setOtherInfo(otherInfo);
            testResultList.add(result);
            System.out.println("    Test Case " + testCase +
                    (division == 0 ? "" : " in Division " + division) + " is Completed.");
        } catch (Exception e) {
            PrintHandler.printError("Failed to set test result for test case " + testCase +
                    (division == 0 ? "" : " division " + division));
            throw e;
        }
    }

    /***************************************************************************************************************
     * The 'getTestResult' method is used to fetch test results from the list.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static TestResult getTestResult(int testCase, int division, String path) {
        try {
            testResultList = FileHandler.TxtFile.read(path);

            Optional<TestResult> resultOptional = testResultList
                    .stream()
                    .filter(result -> result.getTestCase() == testCase)
                    .filter(result -> result.getDivision() == division)
                    .findFirst();

            return resultOptional.orElseThrow();
        } catch (NoSuchElementException e) {
            PrintHandler.printError("No round result found for test case " + testCase +
                    (division == 0 ? "" : " division " + division));
            throw new SkipException(e.getMessage(), e);
        } catch (Exception e) {
            PrintHandler.printError("Failed to get test result for test case " + testCase +
                    (division == 0 ? "" : " division " + division));
            throw e;
        }
    }

    /***************************************************************************************************************
     * The 'sortTestResults' method is used for organizing result data.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void sortTestResults(List<TestResult> results) {
        int length = results.size();
        for (byte i = 0; i < length - 1; i++) {
            for (byte j = 0; j < length - i - 1; j++) {
                TestResult result1 = results.get(j);
                TestResult result2 = results.get(j + 1);
                if (result1.getTestCase() > result2.getTestCase()) {
                    results.set(j, result2);
                    results.set(j + 1, result1);
                } else if (result1.getTestCase() == result2.getTestCase() &&
                        result1.getDivision() > result2.getDivision()) {
                    results.set(j, result2);
                    results.set(j + 1, result1);
                }
            }
        }
    }

    /***************************************************************************************************************
     * The 'getTestResults' method is used for converting read data into a list of test results from the data file.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static TestResult getTestResults(String[] parts) {
        int testCase = Integer.parseInt(parts[0].replace("Test Case: ", ""));
        int division = Integer.parseInt(parts[1].replace("Division: ", ""));
        String roundResult = parts[2].replace("Round Result: ", "");
        String expectedResult = parts[3].replace("Expected Result: ", "");
        String actualResult = parts[4].replace("Actual Result: ", "");
        String tableInfo = parts[5].replace("Table Information: ", "");
        String otherInfo = parts[6].replace("Other Information: ", "");

        TestResult result = new TestResult();
        result.setTestCase(testCase);
        result.setDivision(division);
        result.setRoundResult(roundResult);
        result.setExpectedResult(expectedResult);
        result.setActualResult(actualResult);
        result.setTableInfo(tableInfo);
        result.setOtherInfo(otherInfo);

        return result;
    }

}
