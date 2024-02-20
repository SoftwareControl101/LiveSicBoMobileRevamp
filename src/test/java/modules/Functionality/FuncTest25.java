package modules.Functionality;

import pages.DealerTable;
import pages.GameLobby;
import pages.TableLimit;
import utilities.handlers.AssertHandler;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

public class FuncTest25 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: FUNCTIONALITY");
        System.out.println("Test Case: 25");
        System.out.println("Actual Results: ");

        AssertHandler.assertTrue(ConditionHandler.isDisplayed(TableLimit.Method.getTableLimits(true)),
                "** Available Table Limits are Displayed",
                "** Available Table Limits are Not Displayed");

        String actualTableLimit = GetHandler.getText(TableLimit.Button.ActiveTableLimit)
                .replace("\n", "").replace("\r", "");
        int[] actualLimit = getTableLimitValue(TableLimit.Button.ActiveTableLimit);

        EventHandler.click(50, 50);
        EventHandler.click(DealerTable.Button.Back);

        String expectedTableLimit = GetHandler.getText(GameLobby.Button.ActiveTableLimit).replace(" ", "");
        int[] expectedLimit = getTableLimitValue(GameLobby.Button.ActiveTableLimit);

        AssertHandler.assertTrue(actualLimit[0] == expectedLimit[0] && expectedLimit[1] >= actualLimit[1],
                "** Current Table Limit is Highlighted: " + actualTableLimit + " --> " + expectedTableLimit,
                "** Current Table Limit is Not Highlighted: " + actualTableLimit + " --> " + expectedTableLimit);

        System.out.println();
    }

    private static int[] getTableLimitValue(Component component) {
        String[] array = GetHandler.getText(component)
                .replaceAll("\\n", "")
                .replaceAll(" ", "")
                .split("/");
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            String text = array[i].replace("+", "");
            if (text.endsWith("K")) { result[i] = (int) Double.parseDouble(text.substring(0, text.length() - 1)) * 1000; }
            else { result[i] = Integer.parseInt(text); }
        }
        return result;
    }

}
