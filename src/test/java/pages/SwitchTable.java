package pages;

import utilities.objects.Component;

public class SwitchTable {

    /***************************************************************************************************************
     * These are the container components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component JumpTable = new Component(
                "Jump Table",
                "Container",
                "Switch Table Page",
                "div[class='jump_table'] div[class='wrapper']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component RouletteGame = new Component(
                "Roulette Game",
                "Button",
                "Switch Table Page",
                "//p[normalize-space()='Roulette']/ancestor::button"
        );
        public static Component InactiveGames = new Component(
                "List of Inactive Games",
                "Button",
                "Switch Table Page",
                "//button[@class='game_icon icon']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component YouAreHere = new Component(
                "You Are Here",
                "Label",
                "Switch Table Page",
                "//div[@class='table_card active']//p[contains(text(),'You are here')]"
        );
        public static Component ActiveGame = new Component(
                "Active Game",
                "Label",
                "Switch Table Page",
                "//button[@class='game_icon active icon']//p"
        );
        public static Component InactiveGameNames = new Component(
                "List of Inactive Game Names",
                "Label",
                "Switch Table Page",
                "//button[@class='game_icon icon']//p"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Switch Table Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Component getTableCards(boolean isActiveInclude) {
            return new Component(
                    "List of " + (isActiveInclude ? "Table Cards" : "Table Cards (Active Not Included)"),
                    "Container",
                    "Switch Table Page",
                    isActiveInclude ? "//div[contains(@class, 'table_card')]" : "//div[@class='table_card']"
            );
        }
    }

}
