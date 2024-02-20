package modules.Gameplay;

import globals.BettingOption;
import globals.TestMethod;
import pages.DealerTable;
import pages.LimitsAndPayouts;
import pages.Menu;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class Gameplay extends TestMethod {

    protected static double balanceBeforeBetting;

    public static void placeABetOnAnyBettingOptions() {
        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.BIG));
        balanceBeforeBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
    }

    public static void placeAndConfirmAnyBettingOptions() {
        placeABetOnAnyBettingOptions();
        EventHandler.click(DealerTable.Button.Confirm);
    }

    public static void placeAndConfirmAnyBettingOptions(boolean isMaximum) {
        EventHandler.click(DealerTable.Button.Menu);
        EventHandler.click(Menu.Button.LimitPayouts);

        String[] limitText = GetHandler.getText(LimitsAndPayouts.Label.SpecificTripleLimit).split(" - ");
        double limit = isMaximum ? Double.parseDouble(limitText[1]) : Double.parseDouble(limitText[0]);

        EventHandler.click(LimitsAndPayouts.Button.Back);
        EventHandler.click(50, 50);

        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);

        double bet = 0.0;
        while (bet < limit) {
            EventHandler.click(DealerTable.BettingOption.getSpecificTriple(4));
            bet = getChipValue(DealerTable.BettingChip.getSpecificTriple(4));
        }
    }

}
