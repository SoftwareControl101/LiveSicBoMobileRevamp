package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.GetHandler;

public class FuncTest5 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 5");
        String tableName = GetHandler.getElementByRandom(GameLobby.Label.TableNames).getText();
        System.out.println("Other Information: " + tableName);
        System.out.println("Actual Results: ");

        int expectedBigCounter = getSize(GameLobby.Method.getBigResults(tableName));
        int actualBigCounter = GetHandler.getInt(GameLobby.Method.getBigCounter(tableName));
        AssertHandler.assertEquals(expectedBigCounter, actualBigCounter,
                "** Big Counter is Correct: " + expectedBigCounter + " == " + actualBigCounter,
                "** Big Counter is Not Correct: " + expectedBigCounter + " != " + actualBigCounter);

        System.out.println();
    }

}
