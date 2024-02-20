package modules.UserInterface;

import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;

public class UITest2 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 2");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isUrlContains("/dealerPage"),
                "** Live Sic Bo Revamp is Launched",
                "** Live Sic Bo Revamp is Not Launched");

        System.out.println();
    }

}
