package modules.Functionality;

import globals.BettingOption;
import org.openqa.selenium.WebElement;
import pages.DealerTable;
import pages.GameLobby;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Component;

import java.util.List;

public class FuncTest35 extends Functionality {

    static double oldBet;

    public static void enterTheDealerTableWithHighTableLimits() {
        Component tableLimits = GameLobby.Button.TableLimits;
        List<WebElement> elements = GetHandler.getElements(tableLimits);
        EventHandler.click(tableLimits, elements.get(elements.size() - 1));
        Component dealerTables = GameLobby.Container.DealerTables;
        WebElement dealerTable = GetHandler.getElementByRandom(dealerTables);
        EventHandler.click(dealerTables, dealerTable);
        EventHandler.click(DealerTable.Button.SkipWelcome, HandleCollection.WithException);
    }

    public static void verify(boolean isCheckConfirm) {
        if (isCheckConfirm) {

            oldBet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));

            System.out.println();
            System.out.println("Module: FUNCTIONALITY");
            System.out.println("Test Case: 35");
            System.out.println("Actual Results: ");

            AssertHandler.assertEquals("Top Up Confirm", GetHandler.getText(DealerTable.Button.Confirm),
                    "** \"Top Up Confirm\" Button is Displayed",
                    "** \"Top Up Confirm\" Button is Not Displayed");

        } else {

            double newBet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
            AssertHandler.assertNotEquals(oldBet, newBet,
                    "** Placed Bet is Changed to Minimum Bet of the Betting Options: " + oldBet + " --> " + newBet,
                    "** Placed Bet is Not Changed to Minimum Bet of the Betting Options: " + oldBet + " --> " + newBet);

            System.out.println();
            WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
            WaitHandler.waitVisibility(DealerTable.Label.ShowTimer, 150);
            EventHandler.click(DealerTable.Button.Back);

        }
    }

}
