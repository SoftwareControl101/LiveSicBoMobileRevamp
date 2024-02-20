package steps;

import engine.Driver;
import io.cucumber.java.*;
import utilities.handlers.HooksHandler;

public class Hooks {

    private final Driver driver;

    public Hooks(Driver driver) {
        this.driver = driver;
    }

    @Before()
    public void before() {
        driver.start();
        HooksHandler.beforeScenario();
    }

    @After()
    public void after() {
        driver.close();
        HooksHandler.afterScenario();
    }

    @SuppressWarnings("unused")
    @BeforeStep
    public void beforeStep(Scenario scenario) {
        HooksHandler.beforeStep(scenario);
    }

    @SuppressWarnings("unused")
    @AfterStep
    public void afterStep(Scenario scenario) {
        HooksHandler.afterStep(scenario);
    }

}
