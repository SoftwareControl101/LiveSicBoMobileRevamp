package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.GetHandler;

public class FuncTest6 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 6");
        String tableName = GetHandler.getElementByRandom(GameLobby.Label.TableNames).getText();
        System.out.println("Other Information: " + tableName);
        System.out.println("Actual Results: ");

        int expectedSmallCounter = getSize(GameLobby.Method.getSmallResults(tableName));
        int actualSmallCounter = GetHandler.getInt(GameLobby.Method.getSmallCounter(tableName));
        AssertHandler.assertEquals(expectedSmallCounter, actualSmallCounter,
                "** Small Counter is Correct: " + expectedSmallCounter + " == " + actualSmallCounter,
                "** Small Counter is Not Correct: " + expectedSmallCounter + " != " + actualSmallCounter);

        System.out.println();
    }

}
