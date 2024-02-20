package modules.Gameplay;

import globals.BettingOption;
import org.openqa.selenium.WebElement;
import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.*;
import utilities.objects.Component;

import java.util.List;
import java.util.Objects;

public class GameTest29 extends Gameplay {

    public static void enterTheDealerTableWithHighMinimumLimit() {
        Component tableLimits = GameLobby.Button.TableLimits;
        List<WebElement> tables = GetHandler.getElements(tableLimits);
        EventHandler.click(tableLimits, tables.get(tables.size() - 1));
        Component dealerTable = GameLobby.Container.DealerTables;
        EventHandler.click(dealerTable, GetHandler.getElementByRandom(dealerTable, HandleCollection.WithException));
        EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 29");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Label.ConfirmNow) &&
                        Objects.equals(GetHandler.getText(DealerTable.Label.ConfirmNow), "Confirm with min amount now?"),
                "** \"Confirm with min amount now?\" is Displayed",
                "** \"Confirm with min amount now?\" is Not Displayed");

        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        WaitHandler.wait(2);

        AssertHandler.assertFalse(ConditionHandler.isDisplayed(DealerTable.BettingChip.getMainBet(BettingOption.BIG)),
                "** Placed Chip is Removed",
                "** Placed Chip is Not Removed");

        AssertHandler.assertEquals(balanceBeforeBetting, GetHandler.getDouble(DealerTable.Label.BalanceValue),
                "** Bet is Not Accepted",
                "** Bet is Accepted");

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
