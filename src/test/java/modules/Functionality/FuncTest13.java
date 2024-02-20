package modules.Functionality;

import pages.DealerTable;
import pages.MyBets;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;

public class FuncTest13 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 13");
        System.out.println("Actual Results: ");

        String[] roundIds = GetHandler.getTextArray(MyBets.Label.RoundId, HandleCollection.WithScroll);
        AssertHandler.assertTrue(DataTypeHandler.contains(roundId, roundIds),
                "** Settled Round is Displayed: #" + roundId,
                "** Settled Round is Not Displayed: #" + roundId);

        System.out.println();
        EventHandler.click(MyBets.Button.Back, HandleCollection.WithScroll);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
