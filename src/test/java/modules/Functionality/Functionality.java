package modules.Functionality;

import globals.BettingOption;
import globals.TestMethod;
import pages.DealerTable;
import pages.Menu;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

public class Functionality extends TestMethod {

    protected static String roundId;
    protected static double oldBalance, oldBet;

    private static void goToMenu() {
        EventHandler.click(DealerTable.Button.Menu, 1);
    }

    public static void goToMyBets() {
        goToMenu();
        EventHandler.click(Menu.Button.MyBets, 3);
    }

    public static void goToTheBetDetails() {
        EventHandler.click(MyBets.Method.getDetailsButton(roundId), HandleCollection.WithScroll);
    }

    public static void goToLimitsAndPayouts() {
        goToMenu();
        EventHandler.click(Menu.Button.LimitPayouts, 3);
    }

    public static void goToHelp() {
        goToMenu();
        EventHandler.click(Menu.Button.Help, 3);
    }

    public static void goToSettings() {
        goToMenu();
        EventHandler.click(Menu.Button.Settings, 3);
    }

    public static void placeABetOnAnyBettingOptions() {
        waitBettingPhase(40, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        roundId = getRoundId();
        oldBalance = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.BIG));
    }

    public static void placeAndConfirmAnyBettingOptions() {
        placeABetOnAnyBettingOptions();
        EventHandler.click(DealerTable.Button.Confirm);
    }

    public static void waitUntilRoundIsOver() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        waitBettingPhase(0, false);
    }

    public static void checkThePlacedBet() {
        oldBet = getChipValue(DealerTable.BettingChip.getMainBet(BettingOption.BIG));
    }

}
