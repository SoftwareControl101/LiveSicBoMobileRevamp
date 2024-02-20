package modules.Functionality;

import pages.DealerTable;
import pages.Menu;
import utilities.handlers.EventHandler;

public class FuncTest11 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 11");
        System.out.println("Actual Results: ");

        verifyDisplay(Menu.Label.PlayerName);
        verifyDisplay(Menu.Button.MyBets);
        verifyDisplay(Menu.Button.LimitPayouts);
        verifyDisplay(Menu.Button.Help);
        verifyDisplay(Menu.Button.Settings);

        System.out.println();
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
