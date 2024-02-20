package modules.Functionality;

import pages.DealerTable;
import pages.LimitsAndPayouts;
import utilities.handlers.EventHandler;
import utilities.objects.Component;

public class FuncTest16 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 16");
        System.out.println("Actual Results: ");

        verifyDisplay(LimitsAndPayouts.Label.TableName);
        verifyDisplay(LimitsAndPayouts.Label.TableLimit);

        Component[] limitList = {
                LimitsAndPayouts.Label.SmallLimit,
                LimitsAndPayouts.Label.BigLimit,
                LimitsAndPayouts.Label.EvenLimit,
                LimitsAndPayouts.Label.OddLimit,
                LimitsAndPayouts.Label.SingleNumberLimit,
                LimitsAndPayouts.Label.TwoDiceComboLimit,
                LimitsAndPayouts.Label.TotalOf4Or17Limit,
                LimitsAndPayouts.Label.TotalOf5Or16Limit,
                LimitsAndPayouts.Label.TotalOf6Or15Limit,
                LimitsAndPayouts.Label.TotalOf7Or14Limit,
                LimitsAndPayouts.Label.TotalOf8Or13Limit,
                LimitsAndPayouts.Label.TotalOf9Or12Limit,
                LimitsAndPayouts.Label.TotalOf10Or11Limit,
                LimitsAndPayouts.Label.SpecificDoubleLimit,
                LimitsAndPayouts.Label.AnyTripleLimit,
                LimitsAndPayouts.Label.SpecificTripleLimit
        };

        for (Component limit : limitList) verifyDisplay(limit);

        Component[] payoutList = {
                LimitsAndPayouts.Label.SmallPayout,
                LimitsAndPayouts.Label.BigPayout,
                LimitsAndPayouts.Label.EvenPayout,
                LimitsAndPayouts.Label.OddPayout,
                LimitsAndPayouts.Label.OneOnSinglePayout,
                LimitsAndPayouts.Label.TwoOnSinglePayout,
                LimitsAndPayouts.Label.ThreeOnSinglePayout,
                LimitsAndPayouts.Label.TwoDiceComboPayout,
                LimitsAndPayouts.Label.TotalOf4Or17Payout,
                LimitsAndPayouts.Label.TotalOf5Or16Payout,
                LimitsAndPayouts.Label.TotalOf6Or15Payout,
                LimitsAndPayouts.Label.TotalOf7Or14Payout,
                LimitsAndPayouts.Label.TotalOf8Or13Payout,
                LimitsAndPayouts.Label.TotalOf9Or12Payout,
                LimitsAndPayouts.Label.TotalOf10Or11Payout,
                LimitsAndPayouts.Label.SpecificDoublePayout,
                LimitsAndPayouts.Label.AnyTriplePayout,
                LimitsAndPayouts.Label.SpecificTriplePayout
        };

        for (Component payout : payoutList) verifyDisplay(payout);

        System.out.println();
        EventHandler.click(LimitsAndPayouts.Button.Back);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
