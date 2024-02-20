package modules.Functionality;

import pages.DealerTable;
import pages.SwitchTable;
import utilities.handlers.*;

public class FuncTest21 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 21");
        System.out.println("Actual Results: ");

        verifyDisplay(SwitchTable.Label.YouAreHere);
        verifyDisplay(SwitchTable.Method.getTableCards(true));

        String actualActiveGame = GetHandler.getText(SwitchTable.Label.ActiveGame);
        AssertHandler.assertEquals("Sic Bo", actualActiveGame,
                "** Default Product " + actualActiveGame + " is Highlighted",
                "** Default Product " + actualActiveGame + " is Not Highlighted");

        String[] inactiveGames = GetHandler.getTextArray(SwitchTable.Label.InactiveGameNames);
        AssertHandler.assertFalse(DataTypeHandler.contains("Sic Bo", inactiveGames) &&
                        ConditionHandler.isDisplayed(SwitchTable.Label.InactiveGameNames),
                "** Other Live Products are Displayed and Correct",
                "** Other Live Products are Not Displayed or Incorrect");

        System.out.println();
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
