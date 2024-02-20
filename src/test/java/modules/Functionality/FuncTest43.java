package modules.Functionality;

import pages.DealerTable;
import utilities.handlers.*;

import java.util.Objects;

public class FuncTest43 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 43");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Label.ConfirmNow) &&
                        Objects.equals(GetHandler.getText(DealerTable.Label.ConfirmNow), "Confirm now?"),
                "** \"Confirm now?\" is Displayed",
                "** \"Confirm now?\" is Not Displayed");

        verifyDisplay(DealerTable.Label.BettingIsClosing);
        verifyDisplay(DealerTable.Button.PopUpConfirm);
        verifyDisplay(DealerTable.Button.PopUpNotNow);

        System.out.println();
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        EventHandler.click(DealerTable.Button.Back);
    }

}
