package utilities.handlers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.objects.TestResult;
import utilities.settings.Constants;
import utilities.settings.Variables;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileHandler extends Variables {

    /***************************************************************************************************************
     * The 'getFeaturePath' is utilized to retrieve directories for each module.
     * ***************************************************************************************************************/

    @SuppressWarnings("unused")
    private static String getFeaturePath() {
        return switch (featureName) {
            case "UserInterface" -> Constants.Directory.USER_INTERFACE_PATH;
            case "BetInformation" -> Constants.Directory.BET_INFORMATION_PATH;
            case "Gameplay" -> Constants.Directory.GAMEPLAY_PATH;
            case "Functionality" -> Constants.Directory.FUNCTIONALITY_PATH;
            case "Payout" -> Constants.Directory.PAYOUT_PATH;
            case "ResultAndStatistics" -> Constants.Directory.RESULT_AND_STATS_PATH;
            default -> "";
        };
    }

    /***************************************************************************************************************
     * The 'createDirectory' method is used to generate a specific folder within the test directory.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    private static void createDirectory(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            boolean success = folder.mkdirs();
            if (success) System.out.println();
            else System.err.println();
        }
    }

    @SuppressWarnings("unused")
    public static class TxtFile {
        /***************************************************************************************************************
         * The 'write' method is used for both writing data and creating a file within the test directory.
         ***************************************************************************************************************/

        @SuppressWarnings("unused")
        public static void write(List<TestResult> results, String path) {
            ResultHandler.sortTestResults(results);
            createDirectory(path);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + Constants.Directory.DATA_FILE))) {
                for (TestResult result : results) {
                    writer.write(
                            "Test Case: " + result.getTestCase() + " , " +
                                    "Division: " + result.getDivision() + " , " +
                                    "Round Result: " + result.getRoundResult() + " , " +
                                    "Expected Result: " + result.getExpectedResult() + " , " +
                                    "Actual Result: " + result.getActualResult() + " , " +
                                    "Table Information: " + result.getTableInfo() + " , " +
                                    "Other Information: " + result.getOtherInfo());
                    writer.newLine();
                }
            } catch (IOException e) { e.printStackTrace(); }
        }

        /***************************************************************************************************************
         * The 'read' method is used for both reading data and returning a list of test results from the data file.
         ***************************************************************************************************************/

        @SuppressWarnings("unused")
        public static List<TestResult> read(String path) {
            List<TestResult> resultList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(path + Constants.Directory.DATA_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" , ");
                    if (parts.length == 7) {
                        TestResult result = ResultHandler.getTestResults(parts);
                        resultList.add(result);
                    }
                }
            } catch (IOException e) { e.printStackTrace(); }
            return resultList;
        }
    }

    @SuppressWarnings("unused")
    public static class Image {
        /***************************************************************************************************************
         * The 'capture' method is used to capture a screenshot in case of failure in every test scenario.
         ***************************************************************************************************************/

        @SuppressWarnings("unused")
        public static void capture(String fileName, String folderName, boolean isError) {
            try {

                String folderPath = getFeaturePath() + Constants.Directory.SCREENSHOTS_FOLDER + File.separator + folderName;
                createDirectory(folderPath);
                File folder = new File(folderPath);
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
                String path = folder.getAbsolutePath() + File.separator + currentTime + " " + fileName + ".png";

                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                FileUtils.writeByteArrayToFile(new File(path), screenshot);
                if(isError) scenario.attach(screenshot, "image/png", "image");

            } catch (IOException e) { e.printStackTrace(); }
        }
    }

}
