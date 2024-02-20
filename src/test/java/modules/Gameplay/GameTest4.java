package modules.Gameplay;

import org.openqa.selenium.WebElement;
import pages.DealerTable;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Component;

import java.util.List;

public class GameTest4 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: GAMEPLAY");
        System.out.println("Test Case: 4");
        System.out.println("Actual Results: ");

        WaitHandler.waitInvisibility(DealerTable.Container.BetResult, 150);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        WaitHandler.waitInvisibility(DealerTable.Label.NoMoreBets, 150);

        Component chipOptions = DealerTable.Button.ChipOptions;
        List<WebElement> chipOptionList = GetHandler.getElements(chipOptions);
        for (WebElement chipOption : chipOptionList) {
            EventHandler.click(chipOptions, chipOption);
            AssertHandler.assertFalse(chipOption.getAttribute("class").contains("disabled"),
                    "** " + chipOption.getText() + " Chip is Highlighted",
                    "** " + chipOption.getText() + " Chip is Not Highlighted");
            for (WebElement otherOption : chipOptionList) {
                if (otherOption != chipOption) {
                    AssertHandler.assertTrue(otherOption.getAttribute("class").contains("disabled"),
                            "** " + otherOption.getText() + " Chip is Dimmed",
                            "** " + otherOption.getText() + " Chip is Not Dimmed");
                }
            }
        }

        System.out.println();
        EventHandler.click(DealerTable.Button.Back);
    }

}
