package utilities.settings;

import engine.Driver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.objects.TestResult;

import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Variables extends Driver {

    /***************************************************************************************************************
     * These variables set up all global variables used for all test steps.
     ***************************************************************************************************************/

    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsExecutor;
    protected static Actions actions;
    protected static Scenario scenario;
    protected static String scenarioName;
    protected static String featureName;
    protected static List<TestResult> testResultList;

    /***************************************************************************************************************
     * The 'init' method initialize all global variables but not the scenario and its name.
     ***************************************************************************************************************/

    public static void init() {
        driver.switchTo().window(driver.getWindowHandle());
        wait = new WebDriverWait(driver, 15);
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        testResultList = new ArrayList<>();
    }

    /***************************************************************************************************************
     * The 'setScenario' method sets up the scenario and its name.
     ***************************************************************************************************************/

    public static void setScenario(Scenario scenario) {
        Variables.scenario = scenario;
        scenarioName = scenario.getName().replace(":", "");
        featureName = Paths.get(URI.create(String.valueOf(scenario.getUri()))).getFileName().toString().replace(".feature", "");
    }

    /***************************************************************************************************************
     * The 'getTestResultList' method is used to fetch the list of test result.
     ***************************************************************************************************************/

    public static List<TestResult> getTestResultList() {
        return testResultList;
    }

}
