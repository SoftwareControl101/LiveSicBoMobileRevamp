package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.GetHandler;

public class FuncTest8 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 8");
        String tableName = GetHandler.getElementByRandom(GameLobby.Label.TableNames).getText();
        System.out.println("Other Information: " + tableName);
        System.out.println("Actual Results: ");

        int expectedOddCounter = getSize(GameLobby.Method.getOddResults(tableName));
        int actualOddCounter = GetHandler.getInt(GameLobby.Method.getOddCounter(tableName));
        AssertHandler.assertEquals(expectedOddCounter, actualOddCounter,
                "** Odd Counter is Correct: " + expectedOddCounter + " == " + actualOddCounter,
                "** Odd Counter is Not Correct: " + expectedOddCounter + " != " + actualOddCounter);

        System.out.println();
    }

}
