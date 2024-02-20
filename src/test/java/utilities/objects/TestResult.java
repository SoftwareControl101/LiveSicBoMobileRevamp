package utilities.objects;

public class TestResult {

    /***************************************************************************************************************
     * These are the variables for each test result to generate a data file.
     ***************************************************************************************************************/

    private int testCase, division;
    private String roundResult, expectedResult, actualResult, tableInfo, otherInfo;

    /***************************************************************************************************************
     * These methods are meant for getting and setting the variables for each test result to generate a data file.
     ***************************************************************************************************************/

    public int getTestCase() { return testCase; }

    public void setTestCase(int testCase) { this.testCase = testCase; }

    public int getDivision() { return division; }

    public void setDivision(int division) { this.division = division; }

    public String getRoundResult() { return roundResult; }

    public void setRoundResult(String roundResult) { this.roundResult = roundResult; }

    public String getExpectedResult() { return expectedResult; }

    public void setExpectedResult(String expectedResult) { this.expectedResult = expectedResult; }

    public String getActualResult() { return actualResult; }

    public void setActualResult(String actualResult) { this.actualResult = actualResult; }

    public String getTableInfo() { return tableInfo; }

    public void setTableInfo(String tableInfo) { this.tableInfo = tableInfo; }

    public String getOtherInfo() { return otherInfo; }

    public void setOtherInfo(String otherInfo) { this.otherInfo = otherInfo; }

}
