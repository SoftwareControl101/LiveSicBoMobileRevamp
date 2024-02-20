package modules.Functionality;

import pages.DealerTable;
import pages.Statistics;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.WaitHandler;

public class FuncTest27 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 27");
        System.out.println("Actual Results: ");

        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);

        verifyDisplay(Statistics.Label.ShowTimer);

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);

        verifyDisplay(Statistics.Label.ShowDealing);
        verifyDisplay(Statistics.Container.Statistics);
        verifyDisplay(Statistics.Label.NumbersInResultHistory);
        verifyDisplay(Statistics.Label.Dice1Percentage);
        verifyDisplay(Statistics.Label.Dice2Percentage);
        verifyDisplay(Statistics.Label.Dice3Percentage);
        verifyDisplay(Statistics.Label.Dice4Percentage);
        verifyDisplay(Statistics.Label.Dice5Percentage);
        verifyDisplay(Statistics.Label.Dice6Percentage);
        verifyDisplay(Statistics.Label.SmallPercentage);
        verifyDisplay(Statistics.Label.BigPercentage);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(Statistics.Label.TripleSBPercentage) &&
                        ConditionHandler.isDisplayed(Statistics.Label.TripleOEPercentage),
                "** Triple Percentage is Displayed",
                "** Triple Percentage is Not Displayed");

        verifyDisplay(Statistics.Label.OddPercentage);
        verifyDisplay(Statistics.Label.EvenPercentage);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(Statistics.Label.HotNumbers) &&
                        ConditionHandler.isDisplayed(Statistics.Label.HotCounters),
                "** Hot Numbers and Counters is Displayed",
                "** Hot Numbers and Counters is Not Displayed");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(Statistics.Label.ColdNumbers) &&
                        ConditionHandler.isDisplayed(Statistics.Label.ColdCounters),
                "** Cold Numbers and Counters is Displayed",
                "** Cold Numbers and Counters is Not Displayed");

        System.out.println();
        EventHandler.click(Statistics.Button.CloseStatistics);
        EventHandler.click(DealerTable.Button.Back);
    }

}
