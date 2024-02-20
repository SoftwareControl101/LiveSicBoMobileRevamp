package modules.Functionality;

import org.openqa.selenium.WebElement;
import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.GetHandler;

import java.util.List;
import java.util.Objects;

public class FuncTest1 extends Functionality {

    static String targetTable;
    static int[] expectedNumbersInResultPanel;
    static String[] expectedLatestRoundResult;

    public static void checkTheRoundResultHistory() {
        waitBettingPhase(40, false);
        expectedNumbersInResultPanel = GetHandler.getIntArray(DealerTable.Label.NumbersInResultPanel);
        targetTable = getTableName();
        expectedLatestRoundResult = getExpectedLatestRoundResult();
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 1");
        System.out.println("Other Information: " + targetTable);
        System.out.println("Actual Results: ");

        int[] actualNumbersInResultPanel = GetHandler.getIntArray(GameLobby.Method.getResultHistory(targetTable),
                HandleCollection.WithScroll);
        String expectedNumbers = DataTypeHandler.toString(expectedNumbersInResultPanel);
        String actualNumbers = DataTypeHandler.toString(DataTypeHandler.reverseArray(Objects.requireNonNull(actualNumbersInResultPanel)));

        AssertHandler.assertEquals(expectedNumbers, actualNumbers,
                "Round Result History Displayed in Game is Same: " + expectedNumbers + " == " + actualNumbers,
                "Round Result History Displayed in Game is Not Same: " + expectedNumbers + " != " + actualNumbers);

        String expectedLatest = DataTypeHandler.toString(expectedLatestRoundResult);
        String actualLatest = DataTypeHandler.toString(getActualLatestRoundResult());

        AssertHandler.assertEquals(expectedLatest, actualLatest,
                "The Latest Round Result, Small or Big, and Even or Odd is Correct: " + expectedLatest + " == " + actualLatest,
                "The Latest Round Result, Small or Big, and Even or Odd is Incorrect: " + expectedLatest + " != " + actualLatest);

        System.out.println();
    }

    private static String[] getExpectedLatestRoundResult() {
        List<WebElement> elementsInResultPanel = GetHandler.getElements(DealerTable.Label.NumbersInResultPanel);
        WebElement firstElement = elementsInResultPanel.get(0);
        String smallOrBig = DataTypeHandler.getFirstChar(firstElement.getAttribute("class").replace("result_", "").toUpperCase());
        String oddOrEven = smallOrBig.equals("T") ? smallOrBig : Integer.parseInt(firstElement.getText()) % 2 == 0 ? "E" : "O";
        return new String[]{firstElement.getText(), smallOrBig, oddOrEven};
    }

    private static String[] getActualLatestRoundResult() {
        List<WebElement> elementsInResultPanel = GetHandler.getElements(GameLobby.Method.getLatestRoundResult(targetTable));
        String roundResult = elementsInResultPanel.get(3).getText();
        String smallOrBig = elementsInResultPanel.get(4).getText();
        String oddOrEven = elementsInResultPanel.get(5).getText();
        return new String[]{roundResult, smallOrBig, oddOrEven};
    }

}
