package modules.Functionality;

import globals.RoundCondition;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;

public class FuncTest47 extends Functionality {

    static int expectedTotal;
    static String expectedBettingOption;

    public static void waitUntilRoundIsFinished() {
        int[] result = getRoundResult();
        for (int num : result) expectedTotal += num;
        if (RoundCondition.isBigWin(result)) expectedBettingOption = "big";
        else if (RoundCondition.isSmallWin(result)) expectedBettingOption = "small";
        else if (RoundCondition.isAnyTripleWin(result)) expectedBettingOption = "triple";
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 47");
        System.out.println("Actual Results: ");

        int actualTotal = GetHandler.getInt(DealerTable.Label.FirstNumberInResultPanel);
        AssertHandler.assertEquals(expectedTotal, actualTotal,
                "** Recent Round Result is Displayed in the Round Result History: " + expectedTotal,
                "** Recent Round Result is Not Displayed in the Round Result History: " + expectedTotal);

        String actualColor = GetHandler.getAttribute(DealerTable.Label.FirstNumberInResultPanel, "class")
                .replace("result_", "");
        AssertHandler.assertEquals(expectedBettingOption, actualColor,
                "** Recent Round Color is Correct: " + expectedBettingOption.toUpperCase(),
                "** Recent Round Color is Incorrect: " + expectedBettingOption.toUpperCase());

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
