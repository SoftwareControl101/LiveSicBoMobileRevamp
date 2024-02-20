package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class FuncTest2 {

    public static void verify(boolean isClick) {
        Component balanceText = GameLobby.Label.BalanceText;
        String currentBalance = GetHandler.getText(balanceText);

        if(isClick) {

            System.out.println();
            System.out.println("Module: FUNCTIONALITY");
            System.out.println("Test Case: 2");
            System.out.println("Actual Results: ");

            AssertHandler.assertTrue(ConditionHandler.isDisplayed(balanceText) && currentBalance.length() == 3,
                    "** Currency is Displayed: " + currentBalance,
                    "** Currency is Not Displayed: " + currentBalance);

            AssertHandler.assertFalse(ConditionHandler.isDisplayed(GameLobby.Label.BalanceValue),
                    "** Balance is Hidden When Click: " + currentBalance,
                    "** Balance is Not Hidden When Click: " + currentBalance);

        } else {

            AssertHandler.assertTrue(ConditionHandler.isDisplayed(GameLobby.Label.BalanceValue),
                    "** Balance is Displayed When Re-click: " + currentBalance,
                    "** Balance is Not Displayed When Re-click: " + currentBalance);

            System.out.println();

        }
    }

}
