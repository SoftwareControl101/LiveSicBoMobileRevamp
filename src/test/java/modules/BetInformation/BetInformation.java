package modules.BetInformation;

import globals.TestMethod;
import org.openqa.selenium.WebElement;
import pages.BetDetails;
import pages.DealerTable;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;

import java.util.List;

public class BetInformation extends TestMethod {

    protected static int[] roundResult;
    protected static double totalBet;
    protected static String roundId, tableName;

    protected static void placeBet(String betOption) {
        waitBettingPhase(15, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        EventHandler.click(DealerTable.BettingOption.getMainBet(betOption));
        EventHandler.click(DealerTable.Button.Confirm);
    }

    protected static void waitRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        tableName = getTableName();
        roundId = getRoundId();
        roundResult = getRoundResult();
    }

    protected static double getCurrentStake() {
        WaitHandler.wait(2);
        return GetHandler.getDouble(BetDetails.Label.Stake);
    }

    public static void clickBetDetails() {
        EventHandler.click(MyBets.Method.getDetailsButton(roundId), HandleCollection.WithScroll);
    }

    public static boolean isWins(List<WebElement> winBettingOptions, String betOption) {
        for (WebElement winBettingOption : winBettingOptions) {
            if (winBettingOption.getAttribute("class").contains(betOption)) return true;
        }
        return false;
    }

}
