package pages;

import utilities.objects.Component;

public class Menu {

    /***************************************************************************************************************
     * These are the button components on the Menu Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component MyBets = new Component(
                "My Bets",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickMyBets']"
        );
        public static Component LimitPayouts = new Component(
                "Limit Payouts",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickLimitPayouts']"
        );
        public static Component Help = new Component(
                "Help",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickHelp']"
        );
        public static Component Settings = new Component(
                "Settings",
                "Button",
                "Menu Page",
                "//div[@data-gtm='Btn_ClickSettings']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Menu Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component PlayerName = new Component(
                "Player Name",
                "Label",
                "Menu Page",
                "//div[@class='menu open']//div//span"
        );
    }

}
