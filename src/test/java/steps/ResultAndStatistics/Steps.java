package steps.ResultAndStatistics;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import modules.ResultAndStatistics.*;
import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.FileHandler;
import utilities.interfaces.ResAndStatsCase;
import utilities.settings.Constants;
import utilities.settings.Variables;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    @And("I Enter The Dealer Table With 300 Rounds")
    public void iEnterTheDealerTableWithRounds() {
        EventHandler.click(GameLobby.Method.getDealerTable("Deals 300"));
        EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
    }

    @And("I Place A Bet Until There Is A Round Result For All Results And Statistics")
    public void iPlaceABetUntilThereIsARoundResultForAllResultsAndStatistics(DataTable dataTable) {
        ResAndStatsWait.waitUntilWins(50, getBatch(dataTable.asList(String.class)));
        FileHandler.TxtFile.write(Variables.getTestResultList(), Constants.Directory.RESULT_AND_STATS_PATH);
        EventHandler.click(DealerTable.Button.Back);
    }

    private List<ResAndStatsCase> getBatch(List<String> betOptions) {
        List<ResAndStatsCase> resAndStatsCases = new ArrayList<>();
        for (String betOption : betOptions) {
            switch (betOption) {
                case "Big Result" -> resAndStatsCases.add(new ResAndStatsTest1());
                case "Small Result" -> resAndStatsCases.add(new ResAndStatsTest2());
                case "Any Triple Result" -> resAndStatsCases.add(new ResAndStatsTest3());
                case "Big Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_1());
                case "Any Triple Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_2());
                case "Small Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_3());
                case "Odd Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_4());
                case "Even Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_5());
                case "Dice 1 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_6());
                case "Dice 2 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_7());
                case "Dice 3 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_8());
                case "Dice 4 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_9());
                case "Dice 5 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_10());
                case "Dice 6 Percentage" -> resAndStatsCases.add(new ResAndStatsTest4_11());
                case "Hot Numbers Win" -> resAndStatsCases.add(new ResAndStatsTest4_12());
                case "Cold Numbers Lose" -> resAndStatsCases.add(new ResAndStatsTest4_13());
                case "Cold Numbers Win" -> resAndStatsCases.add(new ResAndStatsTest4_14());
            }
        }
        return resAndStatsCases;
    }

    @Then("I Verify The Result Panel When {string} Wins")
    public void iVerifyTheResultPanelWhenWins(String betOption) {
        switch (betOption) {
            case "Big" -> ResAndStatsTest1.verify();
            case "Small" -> ResAndStatsTest2.verify();
            case "Any Triple" -> ResAndStatsTest3.verify();
        }
    }

    @Then("I Verify The {string} Percentage Displayed")
    public void iVerifyThePercentageDisplayed(String betOption) {
        switch (betOption) {
            case "Big" -> ResAndStatsTest4_1.verify();
            case "Any Triple" -> ResAndStatsTest4_2.verify();
            case "Small" -> ResAndStatsTest4_3.verify();
            case "Odd" -> ResAndStatsTest4_4.verify();
            case "Even" -> ResAndStatsTest4_5.verify();
            case "Dice 1" -> ResAndStatsTest4_6.verify();
            case "Dice 2" -> ResAndStatsTest4_7.verify();
            case "Dice 3" -> ResAndStatsTest4_8.verify();
            case "Dice 4" -> ResAndStatsTest4_9.verify();
            case "Dice 5" -> ResAndStatsTest4_10.verify();
            case "Dice 6" -> ResAndStatsTest4_11.verify();
        }
    }

    @Then("I Verify The {string} Numbers Displayed If They {string}")
    public void iVerifyTheNumbersDisplayedIfThey(String numbers, String result) {
        switch (result) {
            case "Win" -> {
                switch (numbers) {
                    case "Hot" -> ResAndStatsTest4_12.verify();
                    case "Cold" -> ResAndStatsTest4_14.verify();
                }
            }
            case "Lose" -> {
                switch (numbers) {
                    case "Hot" -> System.out.println();
                    case "Cold" -> ResAndStatsTest4_13.verify();
                }
            }
        }
    }

}
