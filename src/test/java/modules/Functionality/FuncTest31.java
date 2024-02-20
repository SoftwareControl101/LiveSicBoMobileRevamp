package modules.Functionality;

import pages.ChipSettings;
import pages.DealerTable;
import utilities.handlers.*;
import utilities.objects.Component;

public class FuncTest31 extends Functionality {

    static String[] expectedChips;

    public static void replaceAnyChipOnMyChips() {
        Component myChips = ChipSettings.Container.MyChips;
        EventHandler.click(myChips, GetHandler.getElementByRandom(myChips));
        Component chipSelections = ChipSettings.Container.ChipSelections;
        EventHandler.click(chipSelections, GetHandler.getElementByRandom(chipSelections));
        expectedChips = GetHandler.getTextArray(myChips);
    }

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 31");
        System.out.println("Actual Results: ");

        verifyDisplay(DealerTable.Label.RememberedYourChipSettings);

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(DealerTable.Container.BettingOptions),
                "** Betting Chips Setting is Closed",
                "** Betting Chips Setting is Closed");

        String[] actualChips = GetHandler.getTextArray(DealerTable.Button.ChipOptions);
        String expectedDefaultChips = DataTypeHandler.toString(expectedChips);
        String actualDefaultChips = DataTypeHandler.toString(actualChips);
        AssertHandler.assertTrue(DataTypeHandler.isEqual(expectedChips, actualChips),
                "** Selected Chips is Correct and Displayed: " + expectedDefaultChips + " == " + actualDefaultChips,
                "** Selected Chips is Incorrect or Not Displayed: " + expectedDefaultChips + " != " + actualDefaultChips);

        System.out.println();
        setDefaultChips();
        EventHandler.click(DealerTable.Button.Back);
    }

}
