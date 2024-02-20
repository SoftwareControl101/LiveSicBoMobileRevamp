package modules.Gameplay;

import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class GameTest18 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 18");
        System.out.println("Actual Results: ");

        Component doubleBtn = DealerTable.Button.Double;
        AssertHandler.assertTrue(GetHandler.getAttribute(doubleBtn, "class").contains("disabled"),
                "** \"" + doubleBtn.getName() + "\" " + doubleBtn.getType() + " is Disabled",
                "** \"" + doubleBtn.getName() + "\" " + doubleBtn.getType() + " is Not Disabled");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
