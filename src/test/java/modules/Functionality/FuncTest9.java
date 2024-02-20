package modules.Functionality;

import pages.GameLobby;
import utilities.handlers.AssertHandler;
import utilities.handlers.GetHandler;

public class FuncTest9 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 9");
        String tableName = GetHandler.getElementByRandom(GameLobby.Label.TableNames).getText();
        System.out.println("Other Information: " + tableName);
        System.out.println("Actual Results: ");

        int expectedEvenCounter = getSize(GameLobby.Method.getEvenResults(tableName));
        int actualEvenCounter = GetHandler.getInt(GameLobby.Method.getEvenCounter(tableName));
        AssertHandler.assertEquals(expectedEvenCounter, actualEvenCounter,
                "** Even Counter is Correct: " + expectedEvenCounter + " == " + actualEvenCounter,
                "** Even Counter is Not Correct: " + expectedEvenCounter + " != " + actualEvenCounter);

        System.out.println();
    }

}
