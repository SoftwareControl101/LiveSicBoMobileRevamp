package modules.Functionality;

import globals.BettingOption;
import pages.DealerTable;
import utilities.handlers.*;

public class FuncTest45 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 45");
        System.out.println("Actual Results: ");

        EventHandler.click(DealerTable.Button.PopUpNotNow);
        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.BettingChip.getMainBet(BettingOption.BIG)),
                "** The Placed Bet is Still Placed",
                "** The Placed Bet is Not Still Placed");

        AssertHandler.assertFalse(ConditionHandler.isDisplayed(DealerTable.Label.ConfirmNow),
                "** The Popup Message is Closed",
                "** The Popup Message is Not Closed");

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        AssertHandler.assertEquals(0, GetHandler.getDouble(DealerTable.Label.TotalBet),
                "** The Placed Bet is Not Accepted",
                "** The Placed Bet is Accepted");

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
