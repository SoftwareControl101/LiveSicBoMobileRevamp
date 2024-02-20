package modules.Functionality;

import pages.DealerTable;
import pages.TableLimit;
import utilities.handlers.*;
import utilities.objects.Component;

public class FuncTest26 extends Functionality {

    static String oldTable;

    public static void goToOtherTableLimitTable() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
        oldTable = GetHandler.getText(DealerTable.Label.TableInfo);
        Component tableLimits = TableLimit.Method.getTableLimits(false);
        EventHandler.click(tableLimits, GetHandler.getElementByRandom(tableLimits));
        WaitHandler.wait(2);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 26");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.PlaceYourBetsPlease);

        String newTable = GetHandler.getText(DealerTable.Label.TableInfo);
        AssertHandler.assertNotEquals(oldTable, newTable,
                "** Table Name is Changed: " + oldTable + " --> " + newTable,
                "** Table Name is Not Changed: " + oldTable + " --> " + newTable);

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        EventHandler.click(DealerTable.Button.TableLimit);
        Component tableLimits = TableLimit.Method.getTableLimits(false);
        EventHandler.click(tableLimits, GetHandler.getElementByRandom(tableLimits));
        WaitHandler.wait(2);

        AssertHandler.assertFalse(GetHandler.getAttribute(DealerTable.Container.BettingOptions, "class").contains("active"),
                "** Betting options is Disabled",
                "** Betting options is Not Disabled");

        System.out.println();
        WaitHandler.wait(2);
        EventHandler.click(DealerTable.Button.Back);
    }

}
