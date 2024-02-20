package modules.Functionality;

import pages.DealerTable;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;

public class FuncTest15 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 15");
        System.out.println("Actual Results: ");

        String runningRoundId = GetHandler.getText(MyBets.Label.RunningRoundId);
        AssertHandler.assertTrue(runningRoundId.contains(roundId),
                "** Currently Running Game is Correct and Displayed: " + runningRoundId,
                "** Currently Running Game is Incorrect and Not Displayed: " + runningRoundId);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(MyBets.Label.RunningMessage),
                "** \"All transactions are time stamped at GMT-4.\" is Displayed",
                "** \"All transactions are time stamped at GMT-4.\" is Not Displayed");

        System.out.println();
        EventHandler.click(MyBets.Button.Back, HandleCollection.WithScroll);
        EventHandler.click(50, 50);
        waitUntilRoundIsOver();
        EventHandler.click(DealerTable.Button.Back);
    }

}
