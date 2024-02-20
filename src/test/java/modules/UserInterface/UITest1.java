package modules.UserInterface;

import pages.LiveCasino;

public class UITest1 extends UserInterface {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 1");
        System.out.println("Actual Results: ");

        verifyDisplay(LiveCasino.Thumbnail.LiveSicBoRevamp);

        System.out.println();
    }

}
