package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class GameTest17 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 17");
        System.out.println("Actual Results: ");

        Component doubleBtn = DealerTable.Button.Double;
        AssertHandler.assertFalse(GetHandler.getAttribute(doubleBtn, "class").contains("disabled"),
                "** \"" + doubleBtn.getName() + "\" " + doubleBtn.getType() + " is Enabled",
                "** \"" + doubleBtn.getName() + "\" " + doubleBtn.getType() + " is Not Enabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
