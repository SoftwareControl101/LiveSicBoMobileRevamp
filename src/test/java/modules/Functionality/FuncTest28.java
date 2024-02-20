package modules.Functionality;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;

public class FuncTest28 {

    public static void verify(boolean isClick) {
        if (isClick) {

            System.out.println();
            System.out.println("Module: FUNCTIONALITY");
            System.out.println("Test Case: 28");
            System.out.println("Actual Results: ");

            AssertHandler.assertFalse(GetHandler.getAttribute(DealerTable.Container.BettingOptions, "class").contains("active"),
                    "** The Betting Options Did Shrink",
                    "** The Betting Options Did Not Shrink");

        } else {

            AssertHandler.assertTrue(GetHandler.getAttribute(DealerTable.Container.BettingOptions, "class").contains("active"),
                    "** The Betting Options Did Expand",
                    "** The Betting Options Did Not Expand");

            System.out.println();
            EventHandler.click(DealerTable.Button.Back);

        }
    }

}
