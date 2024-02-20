package steps.Gameplay;

import globals.TestMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.Gameplay.*;
import pages.DealerTable;
import utilities.handlers.PrintHandler;
import utilities.handlers.WaitHandler;

public class Steps {

    @And("Click {string}")
    public void iClick(String step) {
        switch (step) {
            case "On Each Chip" -> PrintHandler.printInfo("Test Case 4 - Click Step Is Included In Verify Step");
            case "The Back Button" -> GameTest19.clickBackButton();
        }
    }

    @And("Place {string}")
    public void iPlace(String step) {
        switch (step) {
            case "A Bet On Each Betting Option" -> PrintHandler.printInfo("Test Case 11 - Place Step Is Included In Verify Step");
            case "A Bet On Any Betting Options" -> Gameplay.placeABetOnAnyBettingOptions();
            case "And Confirm Any Betting Options" -> Gameplay.placeAndConfirmAnyBettingOptions();
            case "And Confirm Bet Again" -> PrintHandler.printInfo("Test Case 12 - Place Step Is Included In Verify Step");
            case "A Bet That Exceeds Maximum Bet", "A Maximum Bet On Any Betting Options" -> Gameplay.placeAndConfirmAnyBettingOptions(true);
            case "A Minimum Bet On Any Betting Options" -> Gameplay.placeAndConfirmAnyBettingOptions(false);
        }
    }

    @And("Wait {string}")
    public void iWait(String step) {
        switch (step) {
            case "Until New Round Starts", "Until Bet Wins" -> WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            case "Until Timer Less Than Ten Seconds" -> TestMethod.waitBettingPhase(10, true);
        }
    }

    @When("Do {string}")
    public void iDo(String step) {
        switch (step) {
            case "Not Bet For 8 Consecutive Rounds" -> PrintHandler.printInfo("Test Case 14 - Do Step Is Included In Verify Step");
            case "Not Bet For 9 Consecutive Rounds" -> PrintHandler.printInfo("Test Case 15 - Do Step Is Included In Verify Step");
        }
    }

    @When("Enter {string}")
    public void iEnter(String step) {
        switch (step) {
            case "The Dealer Table With High Minimum Limit" -> GameTest29.enterTheDealerTableWithHighMinimumLimit();
            case "" -> System.out.println();
        }
    }

    @Then("Verify {string}")
    public void iVerify(String step) {
        switch (step) {
            case "The Behavior Of The Game After Joining Table" -> GameTest1.verify();
            case "The Behavior Of Chips After Clicking On Each Chips" -> GameTest4.verify();
            case "The Behavior Of The Game When Placed Bet On Any Betting Option" -> GameTest5.verify();
            case "The Behavior Of The Game When Placed Bet And Did Not Confirm Until Less Than 10 Seconds" -> GameTest6.verify();
            case "The Behavior Of The Game After A Round" -> GameTest7.verify();
            case "The Behavior Of The Game After Joining Table With Betting Phase Close" -> GameTest8.verify();
            case "The Behavior Of The Game After Joining Table With Betting Phase Open" -> GameTest9.verify();
            case "The Behavior Of The Game When New Round Is Started" -> GameTest10.verify();
            case "The Behavior Of The Game When Placed Bet On Each Betting Options" -> GameTest11.verify();
            case "The Behavior Of The Game When Confirmed Bet Then Place And Confirm Bet Again" -> GameTest12.verify();
            case "The Behavior Of The Game When Wins Round" -> GameTest13.verify();
            case "The Behavior Of The Game When Did Not Bet For 8 Rounds" -> GameTest14.verify();
            case "The Behavior Of The Game When Did Not Bet For 9 Rounds" -> GameTest15.verify();
            case "The Behavior Of The Game When Placed Bet That Exceed Maximum Limit" -> GameTest16.verify();
            case "The Behavior Of Double Button When Placed Minimum Bet On Any Betting Options" -> GameTest17.verify();
            case "The Behavior Of Double Button When Placed Maximum Bet On Any Betting Options" -> GameTest18.verify();
            case "The Behavior Of The Game When Click Back Button While Confirmed Bet" -> GameTest19.verify();
            case "The Behavior Of The Game When Placed Minimum Bet On Any Betting Options" -> GameTest29.verify();
        }
    }

}
