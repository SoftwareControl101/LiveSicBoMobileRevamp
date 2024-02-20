package modules.Functionality;

import org.openqa.selenium.WebElement;
import pages.DealerTable;
import pages.SwitchTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class FuncTest22 {

    static String expectedTable;

    public static void goToOtherSicBoTable() {
        Component tableCards = SwitchTable.Method.getTableCards(false);
        WebElement randomTable = GetHandler.getElementByRandom(tableCards);
        expectedTable = DataTypeHandler.getLastChar(randomTable.getAttribute("data-gtm"));
        EventHandler.click(tableCards, randomTable);
        WaitHandler.wait(3);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 22");
        System.out.println("Other Information: Sic Bo " + expectedTable);
        System.out.println("Actual Results: ");

        String tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        AssertHandler.assertTrue(tableInfo.contains(expectedTable),
                "** Player is Seated On The Selected Table: " + tableInfo,
                "** Player is Not Seated On The Selected Table: " + tableInfo);

        AssertHandler.assertFalse(ConditionHandler.isDisplayed(SwitchTable.Container.JumpTable),
                "** Switch Table is Closed",
                "** Switch Table is Not Closed");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
