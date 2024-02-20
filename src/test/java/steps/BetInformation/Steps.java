package steps.BetInformation;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.BetInformation.BetInformation;
import modules.BetInformation.BetInfoTest1;
import modules.BetInformation.BetInfoTest2;
import modules.BetInformation.BetInfoTest3;
import pages.BetDetails;
import pages.DealerTable;
import pages.Menu;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;

public class Steps {

    @When("I Place Bet On Any Betting Option Until {string}")
    public void iPlaceBetOnAnyBettingOptionUntil(String step) {
        switch (step) {
            case "Win" -> BetInfoTest1.placeBetUntilWin();
            case "Lose" -> BetInfoTest2.placeBetUntilLose();
            case "Round Complete" -> BetInfoTest3.placeBet();
        }
    }

    @And("I Go To My Bets On The Menu")
    public void iGoToMyBetsOnTheMenu() {
        EventHandler.click(DealerTable.Button.Menu);
        EventHandler.click(Menu.Button.MyBets);
    }

    @And("I Click Bet Details")
    public void iClickBetDetails() {
        BetInformation.clickBetDetails();
    }

    @Then("I Verify The Bet Details Information With {string}")
    public void iVerifyTheBetDetailsInformationWith(String step) {
        switch (step) {
            case "Win Result" -> BetInfoTest1.verify();
            case "Lose Result" -> BetInfoTest2.verify();
            case "Multiple Bets" -> BetInfoTest3.verify();
        }

        EventHandler.click(BetDetails.Button.Back);
        EventHandler.click(MyBets.Button.Back, HandleCollection.WithScroll);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
