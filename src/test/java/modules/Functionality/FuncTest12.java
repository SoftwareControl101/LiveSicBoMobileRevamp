package modules.Functionality;

import pages.DealerTable;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.*;

public class FuncTest12 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 12");
        System.out.println("Actual Results: ");

        if(GetHandler.getElements(MyBets.Container.HistoryCards, HandleCollection.WithException) == null) {
            double expectedTotalBetHistory = 0;
            double actualTotalBetHistory = GetHandler.getDouble(MyBets.Label.TotalBetHistory);
            AssertHandler.assertEquals(expectedTotalBetHistory, actualTotalBetHistory,
                    "** Displayed Total In No Settled Bets is Correct: " +
                            expectedTotalBetHistory + " == " + actualTotalBetHistory,
                    "** Displayed Total In No Settled Bets is Incorrect: " +
                            expectedTotalBetHistory + " != " + actualTotalBetHistory);
        }

        EventHandler.click(MyBets.Button.Back, 1);
        EventHandler.click(50, 50);

        placeABetOnAnyBettingOptions();
        EventHandler.click(DealerTable.Button.Confirm);
        WaitHandler.waitInvisibility(DealerTable.Label.BetsAccepted, 150);

        goToMyBets();
        EventHandler.click(MyBets.Button.Running, 2);

        String runningRoundId = GetHandler.getText(MyBets.Label.RunningRoundId);
        AssertHandler.assertTrue(runningRoundId.contains(roundId),
                "** Currently Running Game In Running Bets is Correct and Displayed: " + runningRoundId,
                "** Currently Running Game In Running Bets is Incorrect or Not Displayed: " + runningRoundId);

        verifyDisplay(MyBets.Label.RunningMessage);

        EventHandler.click(MyBets.Button.Back);
        EventHandler.click(50, 50);

        waitUntilRoundIsOver();

        goToMyBets();
        EventHandler.click(MyBets.Button.Settled, 2);

        verifyDisplay(MyBets.Label.TableName);
        verifyDisplay(MyBets.Label.RoundId);
        verifyDisplay(MyBets.Label.GameStatus);
        verifyDisplay(MyBets.Label.Stake);
        verifyDisplay(MyBets.Label.WinLoss);
        verifyDisplay(MyBets.Label.RefNo);
        verifyDisplay(MyBets.Label.BetDate);
        verifyDisplay(MyBets.Button.Details);

        EventHandler.scroll(MyBets.Label.SettledMessage);

        verifyDisplay(MyBets.Label.SettledMessage);
        verifyDisplay(MyBets.Label.TotalBetHistory);

        System.out.println();
        EventHandler.click(MyBets.Button.Back, HandleCollection.WithScroll);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
