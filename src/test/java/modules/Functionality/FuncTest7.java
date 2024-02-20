package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.GetHandler;

public class FuncTest7 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 7");
        String tableName = GetHandler.getElementByRandom(GameLobby.Label.TableNames).getText();
        System.out.println("Other Information: " + tableName);
        System.out.println("Actual Results: ");

        int expectedTripleCounter = getSize(GameLobby.Method.getTripleResults(tableName)) / 2;
        int actualTripleCounter = GetHandler.getInt(GameLobby.Method.getTripleCounter(tableName));
        AssertHandler.assertEquals(expectedTripleCounter, actualTripleCounter,
                "** Triple Counter is Correct: " + expectedTripleCounter + " == " + actualTripleCounter,
                "** Triple Counter is Not Correct: " + expectedTripleCounter + " != " + actualTripleCounter);

        System.out.println();
    }

}
