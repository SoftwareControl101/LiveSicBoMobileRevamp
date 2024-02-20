package modules.Functionality;

import pages.DealerTable;
import pages.Help;
import utilities.enums.HandleCollection;
import utilities.handlers.AssertHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class FuncTest18 extends Functionality {

    public static void verify(boolean isClick) {
        if(isClick) {

            System.out.println();
            System.out.println("Module: FUNCTIONALITY");
            System.out.println("Test Case: 18");
            System.out.println("Actual Results: ");

            verifyHelpDisplay(Help.Button.Basics, Help.Container.Basics);
            verifyHelpDisplay(Help.Button.BetOptions, Help.Container.BetOptions);
            verifyHelpDisplay(Help.Button.GameControls, Help.Container.GameControls);
            verifyHelpDisplay(Help.Button.Likelihood, Help.Container.Likelihood);

        } else {

            verifyHelpHidden(Help.Button.Basics, Help.Container.Basics);
            verifyHelpHidden(Help.Button.BetOptions, Help.Container.BetOptions);
            verifyHelpHidden(Help.Button.GameControls, Help.Container.GameControls);
            verifyHelpHidden(Help.Button.Likelihood, Help.Container.Likelihood);

            System.out.println();
            EventHandler.click(Help.Button.Back);
            EventHandler.click(50, 50);
            EventHandler.click(DealerTable.Button.Back);

        }
    }

    private static void verifyHelpDisplay(Component button, Component container) {
        EventHandler.click(button, HandleCollection.WithScroll);
        String name = container.getName();
        String type = container.getType();
        String page = container.getPage();
        AssertHandler.assertTrue(GetHandler.getAttribute(container, "data-gtm").contains("Off"),
                "** \"" + name + "\" " + type + " on " + page + " is Displayed",
                "** \"" + name + "\" " + type + " on " + page + " is Not Displayed");
    }

    private static void verifyHelpHidden(Component button, Component container) {
        EventHandler.click(button, HandleCollection.WithScroll);
        String name = container.getName();
        String type = container.getType();
        String page = container.getPage();
        AssertHandler.assertFalse(GetHandler.getAttribute(container, "data-gtm").contains("Off"),
                "** \"" + name + "\" " + type + " on " + page + " is Hidden",
                "** \"" + name + "\" " + type + " on " + page + " is Not Hidden");
    }

}
