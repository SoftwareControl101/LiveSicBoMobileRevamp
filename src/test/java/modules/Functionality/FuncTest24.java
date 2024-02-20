package modules.Functionality;

import org.openqa.selenium.WebElement;
import pages.DealerTable;
import pages.SwitchTable;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.objects.Component;

public class FuncTest24 {
    static String expectedTable;

    public static void goToOtherLiveProductsTable() {
        EventHandler.click(SwitchTable.Button.RouletteGame);
        WaitHandler.wait(3);
        Component tableCards = SwitchTable.Method.getTableCards(true);
        WebElement randomTable = GetHandler.getElementByRandom(tableCards);
        expectedTable = DataTypeHandler.getLastChar(randomTable.getAttribute("data-gtm"));
        EventHandler.click(tableCards, randomTable);
        WaitHandler.wait(3);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 24");
        System.out.println("Other Information: Sic Bo " + expectedTable);
        System.out.println("Actual Results: ");

        String tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        AssertHandler.assertTrue(tableInfo.contains(expectedTable),
                "** Player is Seated On The Selected Table of The Selected Product: " + tableInfo,
                "** Player is Not Seated On The Selected Table of The Selected Product " + tableInfo);

        System.out.println();
        EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
        EventHandler.click(DealerTable.Button.Back);
    }

}
