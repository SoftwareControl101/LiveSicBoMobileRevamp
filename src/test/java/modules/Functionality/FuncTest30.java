package modules.Functionality;

import org.openqa.selenium.WebElement;
import pages.ChipSettings;
import pages.DealerTable;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class FuncTest30 {

    static String removedChip, addedChip;
    static String[] removedChips, addedChips, selectionChips;

    public static void removeAnyChipsOnMyChips() {
        Component myChips = ChipSettings.Container.MyChips;
        WebElement chip = GetHandler.getElementByRandom(myChips);
        removedChip = chip.getText();
        EventHandler.click(myChips, chip);
        removedChips = GetHandler.getTextArray(myChips);
        selectionChips = GetHandler.getTextArray(ChipSettings.Container.ChipSelections, HandleCollection.WithScroll);
    }

    public static void selectAnyChipsOnChipsSelections() {
        Component chipSelections = ChipSettings.Container.ChipSelections;
        WebElement chip = GetHandler.getElementByRandom(chipSelections);
        addedChip = chip.getText();
        EventHandler.click(chipSelections, chip);
        addedChips = GetHandler.getTextArray(ChipSettings.Container.MyChips);
    }

    public static void verify(boolean isRemove) {
        if (isRemove) {

            System.out.println();
            System.out.println("Module: FUNCTIONALITY");
            System.out.println("Test Case: 30");
            System.out.println("Actual Results: ");

            AssertHandler.assertFalse(DataTypeHandler.find(removedChip, removedChips),
                    "** Selected Chips is Removed: " + removedChip,
                    "** Selected Chips is Not Removed: " + removedChip);

        } else {

            AssertHandler.assertTrue(DataTypeHandler.find(removedChip, selectionChips),
                    "** Removed Chips is Transferred to Chip Selections",
                    "** Removed Chips is Not Transferred to Chip Selections");

            AssertHandler.assertTrue(DataTypeHandler.find(addedChip, addedChips),
                    "** Selected Chip is Added to My Chips: " + addedChip,
                    "** Selected Chip is Not Added to My Chips: " + addedChip);

            System.out.println();
            EventHandler.click(ChipSettings.Button.Cancel);
            EventHandler.click(DealerTable.Button.Back);

        }
    }

}
