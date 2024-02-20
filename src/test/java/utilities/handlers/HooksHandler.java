package utilities.handlers;

import io.cucumber.java.Scenario;
import utilities.settings.Variables;

import java.util.Objects;

public class HooksHandler extends Variables {

    /***************************************************************************************************************
     * The 'beforeScenario' method runs before the scenario begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void beforeScenario() { init(); }

    /***************************************************************************************************************
     * The 'afterScenario' method runs after the scenario begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void afterScenario() { }

    /***************************************************************************************************************
     * The 'beforeStep' method runs before each step begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void beforeStep(Scenario scenario) {
        setScenario(scenario);
    }

    /***************************************************************************************************************
     * The 'afterStep' method runs after each step begins.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            if (!Objects.equals(featureName, "ResultAndStatistics") &&
                    !Objects.equals(featureName, "Payout")) {
                FileHandler.Image.capture(scenarioName, "errors", true);
            }
        }
    }

}
