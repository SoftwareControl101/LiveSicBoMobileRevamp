package modules.Gameplay;

import globals.BettingOption;
import org.openqa.selenium.WebElement;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;

public class GameTest5 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 5");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.BettingChip.getMainBet(BettingOption.BIG)),
                "** Can Place a Bet on Any Betting Option",
                "** Can Not Place a Bet on Any Betting Option");

        for (WebElement actionButton : GetHandler.getElements(DealerTable.Button.ActionButtons)) {
            AssertHandler.assertFalse(actionButton.getAttribute("class").contains("disabled"),
                    "** " + actionButton.getText() + " Button is Enabled",
                    "** " + actionButton.getText() + " Button is Not Enabled");
        }

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
