package steps.Functionality;

import globals.TestMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.Functionality.*;
import pages.ChipSettings;
import pages.DealerTable;
import pages.GameLobby;
import pages.MyBets;
import utilities.handlers.EventHandler;
import utilities.handlers.PrintHandler;
import utilities.handlers.WaitHandler;

public class Steps {

    @And("I Check {string}")
    public void iCheck(String step) {
        switch (step) {
            case "The Round Result History" -> FuncTest1.checkTheRoundResultHistory();
            case "The Default Chips" -> FuncTest29.checkTheDefaultChips();
            case "The Betting Chip" -> FuncTest34.checkTheBettingChip();
            case "The Placed Bet" -> Functionality.checkThePlacedBet();
        }
    }

    @And("I Go {string}")
    public void iGo(String step) {
        switch (step) {
            case "Back To The Game Lobby" -> EventHandler.click(DealerTable.Button.Back, 3);
            case "To My Bets" -> Functionality.goToMyBets();
            case "To The Bet Details" -> Functionality.goToTheBetDetails();
            case "To Limits And Payouts" -> Functionality.goToLimitsAndPayouts();
            case "To Help" -> Functionality.goToHelp();
            case "To Settings" -> Functionality.goToSettings();
            case "To Other Sic Bo Table" -> FuncTest22.goToOtherSicBoTable();
            case "To Other Live Products" -> FuncTest23.goToOtherLiveProducts();
            case "To Other Live Products Table" -> FuncTest24.goToOtherLiveProductsTable();
            case "To Other Table Limit Table" -> FuncTest26.goToOtherTableLimitTable();
        }
    }

    @When("I Click {string}")
    public void iClick(String step) {
        switch (step) {
            case "The Show/Hide Balance Button" -> EventHandler.click(GameLobby.Button.HideShowBalance, 2);
            case "On Each Table Limit" -> PrintHandler.printInfo("Test Case 3 - Click Step Is Included In Verify Step");
            case "The Back Button On Lobby" -> EventHandler.click(GameLobby.Button.Back, 2);
            case "The Menu Button" -> EventHandler.click(DealerTable.Button.Menu, 2);
            case "The Confirm Button" -> EventHandler.click(DealerTable.Button.Confirm, 2);
            case "The Running Tab" -> EventHandler.click(MyBets.Button.Running, 2);
            case "On Each Category in Help" -> PrintHandler.printInfo("Test Case 15 - Click Step Is Included In Verify Step");
            case "The Switch Table Button" -> EventHandler.click(DealerTable.Button.SwitchTable, 2);
            case "The Table Limit Button" -> EventHandler.click(DealerTable.Button.TableLimit, 2);
            case "The Statistics Button" -> EventHandler.click(DealerTable.Button.Statistics, 2);
            case "The Expand Shrink Button" -> EventHandler.click(DealerTable.Button.ExpandShrink, 2);
            case "The Edit Chips Button" -> EventHandler.click(DealerTable.Button.EditChips, 2);
            case "The Save Button" -> EventHandler.click(ChipSettings.Button.Save, 2);
            case "The Undo Button" -> EventHandler.click(DealerTable.Button.Undo, 2);
            case "The Double Button" -> EventHandler.click(DealerTable.Button.Double, 2);
            case "The Popup Confirm Button" -> EventHandler.click(DealerTable.Button.PopUpConfirm, 2);
            case "The Popup Not Now Button" -> PrintHandler.printInfo("Test Case 42 - Click Step Is Included In Verify Step");
            case "The Back Button On Game" -> EventHandler.click(DealerTable.Button.Back, 2);
        }
    }

    @And("I Wait {string}")
    public void iWait(String step) {
        switch (step) {
            case "Until Round Is Over" -> Functionality.waitUntilRoundIsOver();
            case "Until Betting Phase" -> TestMethod.waitBettingPhase(10, false);
            case "Until Betting Timer Starts" -> WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            case "Until Betting Timer Ends" -> TestMethod.waitBettingPhase(1, true);
            case "Until Bet Wins" -> FuncTest42.waitUntilBetWins();
            case "Until Betting Timer Reaches Last 10 Seconds" -> TestMethod.waitBettingPhase(10, true);
            case "Until Round Is Finished" -> FuncTest47.waitUntilRoundIsFinished();
        }
    }

    @And("I Place {string}")
    public void iPlace(String step) {
        switch (step) {
            case "A Bet On Any Betting Options" -> Functionality.placeABetOnAnyBettingOptions();
            case "And Undo Any Betting Options" -> FuncTest32.placeAndUndoAnyBettingOptions();
            case "A Bet On Two Or More Betting Options" -> FuncTest32.placeABetOnTwoOrMoreBettingOptions();
            case "A Bet On Four Or More Betting Options" -> FuncTest33.placeABetOnFourOrMoreBettingOptions();
            case "And Confirm Any Betting Options" -> Functionality.placeAndConfirmAnyBettingOptions();
            case "A Bet On Same Betting Options" -> FuncTest48.placeABetOnSameBettingOptions();
        }
    }

    @And("I Do {string}")
    public void iDo(String step) {
        switch (step) {
            case "Remove Any Chips On My Chips" -> FuncTest30.removeAnyChipsOnMyChips();
            case "Select Any Chips On Chips Selections" -> FuncTest30.selectAnyChipsOnChipsSelections();
            case "Replace Any Chip On My Chips" -> FuncTest31.replaceAnyChipOnMyChips();
            case "Press And Hold The Undo Button" -> EventHandler.pressAndHold(DealerTable.Button.Undo, 3);
            case "Switch And Join Another Table" -> FuncTest36.switchAndJoinAnotherTable();
        }
    }

    @When("I Enter {string}")
    public void iEnter(String step) {
        switch (step) {
            case "The Dealer Table With High Table Limits" -> FuncTest35.enterTheDealerTableWithHighTableLimits();
            case "" -> System.out.println();
        }
    }

    @Then("I Verify {string}")
    public void iVerify(String step) {
        switch (step) {
            case "The Previous Results Displayed On The Game Lobby" -> FuncTest1.verify();
            case "The Functionality After Clicking The Show/Hide Balance Button" -> FuncTest2.verify(true);
            case "The Functionality After Re-clicking The Show/Hide Balance Button" -> FuncTest2.verify(false);
            case "The Functionality After Clicking Each Table Limit Button" -> FuncTest3.verify();
            case "The Functionality After Clicking The Back Button On The Game Lobby" -> FuncTest4.verify();
            case "The Functionality Of The Big Counter" -> FuncTest5.verify();
            case "The Functionality Of The Small Counter" -> FuncTest6.verify();
            case "The Functionality Of The Triple Counter" -> FuncTest7.verify();
            case "The Functionality Of The Odd Counter" -> FuncTest8.verify();
            case "The Functionality Of The Even Counter" -> FuncTest9.verify();
            case "The Functionality After Clicking The Menu Button" -> FuncTest11.verify();
            case "The Functionality After Clicking The My Bets In The Menu" -> FuncTest12.verify();
            case "The Functionality Of Settled Round In My Bets In The Menu" -> FuncTest13.verify();
            case "The Functionality After Clicking The Details Button In Settled Rounds" -> FuncTest14.verify();
            case "The Functionality Of Running Round In My Bets In The Menu" -> FuncTest15.verify();
            case "The Functionality After Clicking The Limits And Payouts In The Menu" -> FuncTest16.verify();
            case "The Functionality After Clicking The Help In The Menu" -> FuncTest17.verify();
            case "The Functionality After Clicking Each Category In The Menu" -> FuncTest18.verify(true);
            case "The Functionality After Re-clicking Each Category In The Menu" -> FuncTest18.verify(false);
            case "The Functionality After Clicking The Settings In The Menu" -> FuncTest19.verify();
            case "The Functionality After Clicking The Switch Table Button" -> FuncTest21.verify();
            case "The Functionality After Selecting Other Table In The Switch Table" -> FuncTest22.verify();
            case "The Functionality After Selecting Other Product In The Switch Table" -> FuncTest23.verify();
            case "The Functionality After Seating On Other Live Products Table" -> FuncTest24.verify();
            case "The Functionality After Clicking The Table Limit Button" -> FuncTest25.verify();
            case "The Functionality After Selecting Other Table Limit" -> FuncTest26.verify();
            case "The Functionality After Clicking The Statistics Button" -> FuncTest27.verify();
            case "The Functionality After Clicking Expand Shrink Button" -> FuncTest28.verify(true);
            case "The Functionality After Re-clicking Expand Shrink Button" -> FuncTest28.verify(false);
            case "The Functionality After Clicking The Edit Chips Button" -> FuncTest29.verify();
            case "The Functionality After Removing Betting Chips" -> FuncTest30.verify(true);
            case "The Functionality After Adding Betting Chips" -> FuncTest30.verify(false);
            case "The Functionality After Clicking The Save Button In Chip Settings" -> FuncTest31.verify();
            case "The Functionality After Clicking The Undo Button" -> FuncTest32.verify(false);
            case "The Functionality After Pressing And Holding The Undo Button" -> FuncTest33.verify();
            case "The Functionality After Clicking The Confirm Button" -> FuncTest34.verify();
            case "The Functionality Of The Confirm Button" -> FuncTest35.verify(true);
            case "The Functionality After Clicking The Top Up And Confirm Button" -> FuncTest35.verify(false);
            case "The Functionality Of The Switch Table When Betting In Multiple Tables" -> FuncTest36.verify(false);
            case "The Functionality Of The Betting Timer Once It Starts" -> FuncTest37.verify();
            case "The Functionality Of The Betting Timer Once It Ends" -> FuncTest38.verify();
            case "The Functionality After Clicking The Double Button" -> FuncTest39.verify();
            case "The Functionality Of Total Balance After Confirming Any Bets" -> FuncTest40.verify();
            case "The Functionality Of Total Balance After Confirming And Doubling Bets" -> FuncTest41.verify();
            case "The Functionality Of Total Balance After Winning Round" -> FuncTest42.verify();
            case "The Functionality After Betting Timer Reaches Last 10 Seconds And Not Confirming" -> FuncTest43.verify();
            case "The Functionality After Clicking The Confirm Button On Popup Message" -> FuncTest44.verify();
            case "The Functionality After Clicking The Not Now Button On Popup Message" -> FuncTest45.verify();
            case "The Functionality After Clicking The Back Button On Game" -> FuncTest46.verify();
            case "The Functionality Of The Round Result History" -> FuncTest47.verify();
            case "The Functionality After Increasing A Placed Bet" -> FuncTest48.verify();
        }
    }

}
