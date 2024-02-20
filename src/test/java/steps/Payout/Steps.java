package steps.Payout;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import modules.Payout.*;
import pages.DealerTable;
import utilities.handlers.EventHandler;
import utilities.handlers.FileHandler;
import utilities.interfaces.PayoutCase;
import utilities.settings.Constants;
import utilities.settings.Variables;

import java.util.ArrayList;
import java.util.List;

public class Steps {

    @Then("I Place A Bet Until There Is A Round Result For All Payouts")
    public void iPlaceABetUntilThereIsARoundResultForAllPayouts(DataTable dataTable) {
        List<String> betOptions = dataTable.asList(String.class);
        PayoutWait.waitUntilWins(50, getFirstBatch(betOptions));
        FileHandler.TxtFile.write(Variables.getTestResultList(), Constants.Directory.PAYOUT_PATH);
        EventHandler.click(DealerTable.Button.Back);
    }

    private List<PayoutCase> getFirstBatch(List<String> betOptions) {
        List<PayoutCase> payoutCases = new ArrayList<>();
        for (String betOption : betOptions) {
            switch (betOption) {
                case "Small" -> payoutCases.add(new PayoutTest1());
                case "Big" -> payoutCases.add(new PayoutTest2());
                case "Even" -> payoutCases.add(new PayoutTest3());
                case "Odd" -> payoutCases.add(new PayoutTest4());
                case "Any Triple" -> payoutCases.add(new PayoutTest6());
                case "Three Dice Total 4 & 17" -> payoutCases.add(new PayoutTest7());
                case "Three Dice Total 5 & 16" -> payoutCases.add(new PayoutTest8());
                case "Three Dice Total 6 & 15" -> payoutCases.add(new PayoutTest9());
                case "Three Dice Total 7 & 14" -> payoutCases.add(new PayoutTest10());
                case "Three Dice Total 8 & 13" -> payoutCases.add(new PayoutTest11());
                case "Three Dice Total 9 & 12" -> payoutCases.add(new PayoutTest12());
                case "Three Dice Total 10 & 11" -> payoutCases.add(new PayoutTest13());
                case "1 To 1 On One Dice" -> payoutCases.add(new PayoutTest14());
                case "2 To 1 On One Dice" -> payoutCases.add(new PayoutTest15());
                case "3 To 1 On One Dice" -> payoutCases.add(new PayoutTest16());
                case "Specific Triple" -> payoutCases.add(new PayoutTest17());
                case "Two Dice Combo" -> payoutCases.add(new PayoutTest18());
                case "Specific Double" -> payoutCases.add(new PayoutTest19());
            }
        }
        return payoutCases;
    }

    @Then("I Verify The Payout Calculation Of {string} Betting Option")
    public void iVerifyThePayoutCalculationOfBettingOption(String betOption) {
        switch (betOption) {
            case "Small" -> PayoutWait.verify(1);
            case "Big" -> PayoutWait.verify(2);
            case "Even" -> PayoutWait.verify(3);
            case "Odd" -> PayoutWait.verify(4);
            case "Any Triple" -> PayoutWait.verify(6);
            case "Three Dice Total 4 & 17" -> PayoutWait.verify(7);
            case "Three Dice Total 5 & 16" -> PayoutWait.verify(8);
            case "Three Dice Total 6 & 15" -> PayoutWait.verify(9);
            case "Three Dice Total 7 & 14" -> PayoutWait.verify(10);
            case "Three Dice Total 8 & 13" -> PayoutWait.verify(11);
            case "Three Dice Total 9 & 12" -> PayoutWait.verify(12);
            case "Three Dice Total 10 & 11" -> PayoutWait.verify(13);
            case "1 To 1 On One Dice" -> PayoutWait.verify(14);
            case "2 To 1 On One Dice" -> PayoutWait.verify(15);
            case "3 To 1 On One Dice" -> PayoutWait.verify(16);
            case "Specific Triple" -> PayoutWait.verify(17);
            case "Two Dice Combo" -> PayoutWait.verify(18);
            case "Specific Double" -> PayoutWait.verify(19);
        }
    }

}
