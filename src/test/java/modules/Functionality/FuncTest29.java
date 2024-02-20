package modules.Functionality;

import pages.ChipSettings;
import pages.DealerTable;
import utilities.enums.HandleCollection;
import utilities.handlers.*;

public class FuncTest29 extends Functionality {

    static String[] defaultChips;

    public static void checkTheDefaultChips() {
        defaultChips = GetHandler.getTextArray(DealerTable.Button.ChipOptions);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 29");
        System.out.println("Actual Results: ");

        verifyDisplay(ChipSettings.Label.MyChips);
        verifyDisplay(ChipSettings.Label.ChipSelections);
        verifyDisplay(ChipSettings.Button.Save);

        String[] myChips = GetHandler.getTextArray(ChipSettings.Container.MyChips);
        AssertHandler.assertEquals(DataTypeHandler.toString(defaultChips), DataTypeHandler.toString(myChips),
                "** Default Betting Chips is Displayed on My Chips",
                "** Default Betting Chips is Not Displayed on My Chips");

        String[] selectionChips = GetHandler.getTextArray(ChipSettings.Container.ChipSelections, HandleCollection.WithScroll);
        AssertHandler.assertFalse(ConditionHandler.isEmpty(ChipSettings.Container.ChipSelections),
                "** Other Chips is Displayed on Chips Selections",
                "** Other Chips is Not Displayed on Chips Selections");

        for (String chip : defaultChips) {
            AssertHandler.assertFalse(DataTypeHandler.find(chip, selectionChips),
                    "** " + chip + " Chip is Not Displayed The Other Chips",
                    "** " + chip + " Chip is Displayed The Other Chips");
        }

        System.out.println();
        EventHandler.click(ChipSettings.Button.Cancel);
        EventHandler.click(DealerTable.Button.Back);
    }

}
