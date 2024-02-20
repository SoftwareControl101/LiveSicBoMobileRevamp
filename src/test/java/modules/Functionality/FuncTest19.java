package modules.Functionality;

import pages.DealerTable;
import pages.Settings;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.objects.Component;

public class FuncTest19 extends Functionality {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 19");
        System.out.println("Actual Results: ");

        verifyDisplay(Settings.Label.Music);

        Component music = Settings.RadioButton.Music;
        AssertHandler.assertFalse(ConditionHandler.isSelected(music),
                "** " + music.getName() + " Default is Off",
                "** " + music.getName() + " Default is Off");

        verifyDisplay(Settings.Label.Voice);

        Component voice = Settings.RadioButton.Voice;
        AssertHandler.assertFalse(ConditionHandler.isSelected(voice),
                "** " + voice.getName() + " Default is Off",
                "** " + voice.getName() + " Default is Off");

        System.out.println();
        EventHandler.click(Settings.Button.Back);
        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);
    }

}
