package modules.UserInterface;

import globals.TestMethod;
import pages.DealerTable;

public class UserInterface extends TestMethod {

    protected static void assertGameUI() {
        verifyDisplay(DealerTable.Button.Back);
        verifyDisplay(DealerTable.Label.TableInfo);
        verifyDisplay(DealerTable.Label.TotalBet);
        verifyDisplay(DealerTable.Button.HideShowBalance);
        verifyDisplay(DealerTable.Label.BalanceText);
        verifyDisplay(DealerTable.Button.Menu);
        verifyDisplay(DealerTable.Button.SwitchTable);
        verifyDisplay(DealerTable.Button.ExpandShrink);
        verifyDisplay(DealerTable.Button.TableLimit);
        verifyDisplay(DealerTable.Button.Statistics);
        verifyDisplay(DealerTable.Button.Undo);
        verifyDisplay(DealerTable.Button.Double);
        verifyDisplay(DealerTable.Button.Confirm);
        verifyDisplay(DealerTable.Label.NumbersInResultPanel);
        verifyDisplay(DealerTable.Button.ChipOptions);
        verifyDisplay(DealerTable.Button.EditChips);
        verifyDisplay(DealerTable.Container.BettingOptions);
    }

}
