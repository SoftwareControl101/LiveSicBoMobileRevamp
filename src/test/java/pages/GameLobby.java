package pages;

import utilities.enums.Environment;
import utilities.objects.Component;
import utilities.settings.Accounts;

public class GameLobby {

    /***************************************************************************************************************
     * These are the table component on the Game Lobby Page.
     ***************************************************************************************************************/

    private static final String tablesPath = Accounts.getEnvironment() == Environment.PRODUCTION ?
            "//div[contains(@class, 'dealer_btn')]//span[not(contains(text(),'Maintenance'))]/ancestor::div[4]" :
            "//p[(contains(text(),'Sic Bo Y'))]/ancestor::div[2]";

    /***************************************************************************************************************
     * These are the container components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component DealerTables = new Component(
                "List of Dealer Tables",
                "Container",
                "Game Lobby Page",
                tablesPath
        );
        public static Component DealerPhotos = new Component(
                "List of Dealer Photos",
                "Container",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='dealer_photo']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "Game Lobby Page",
                "//button[@class='back_btn']"
        );
        public static Component ActiveTableLimit = new Component(
                "Active Table Limit",
                "Button",
                "Game Lobby Page",
                "//div[@class='tableLimit_list']//li[@class='active']"
        );
        public static Component HideShowBalance = new Component(
                "Hide/Show Balance",
                "Button",
                "Game Lobby Page",
                "//div[contains(@class, 'balance_btn')]"
        );
        public static Component TableLimits = new Component(
                "List of Table Limits",
                "Button",
                "Game Lobby Page",
                "//div[@class='tableLimit_list']//li"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component BalanceText = new Component(
                "Balance Text",
                "Label",
                "Game Lobby Page",
                "//div[contains(@class, 'balance_btn')]//p"
        );
        public static Component BalanceValue = new Component(
                "Balance Value",
                "Label",
                "Game Lobby Page",
                "//div[contains(@class, 'balance_btn')]//span[2]"
        );
        public static Component DealerNames = new Component(
                "List of Dealer Names",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//span[@class='dealer_name']"
        );
        public static Component TableNames = new Component(
                "List of Table Names",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//p[@class='table_name']"
        );
        public static Component FindATable = new Component(
                "Let's find a table and start betting.",
                "Label",
                "Game Lobby Page",
                "//p[contains(normalize-space(), 'find a table and start betting')]"
        );
        public static Component RoundResults = new Component(
                "List of Round Results",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//ul[@class='results_display last-padding']"
        );
        public static Component BigCounters = new Component(
                "List of Big Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='sicbo_line_statistics']//div[1]//span[2]"
        );
        public static Component SmallCounters = new Component(
                "List of Small Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='sicbo_line_statistics']//div[2]//span[2]"
        );
        public static Component TripleCounters = new Component(
                "List of Triple Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='sicbo_line_statistics']//div[3]//span[2]"
        );
        public static Component OddCounters = new Component(
                "List of Odd Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='sicbo_line_statistics']//div[4]//span[2]"
        );
        public static Component EvenCounters = new Component(
                "List of Even Counters",
                "Label",
                "Game Lobby Page",
                "//div[@class='dealer station']//div[@class='sicbo_line_statistics']//div[5]//span[2]"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Game Lobby Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Component getDealerTable(String dealsOrTable) {
            return new Component(
                    dealsOrTable + " Dealer Table",
                    "Container",
                    "Game Lobby Page",
                    tablesPath + "//p[(contains(text(), '" +
                            dealsOrTable + "'))]/ancestor::div[2]"
            );
        }
        public static Component getLatestRoundResult(String dealsOrTable) {
            return new Component(
                    "Latest Round Result in " + dealsOrTable + " Dealer Table",
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_result big active']//div"
            );
        }
        public static Component getResultHistory(String dealsOrTable) {
            return new Component(
                    "Result History in " + dealsOrTable + " Dealer Table",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[contains(@class, 'sicbo_line_result big')])" +
                            "[position() > last() - 12]//div[4]"
            );
        }
        public static Component getBigCounter(String dealsOrTable) {
            return new Component(
                    "Big Counter in Dealer Table of " + dealsOrTable,
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_statistics']//div[1]//span[2]");
        }
        public static Component getSmallCounter(String dealsOrTable) {
            return new Component(
                    "Small Counter in Dealer Table of " + dealsOrTable,
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_statistics']//div[2]//span[2]"
            );
        }
        public static Component getTripleCounter(String dealsOrTable) {
            return new Component(
                    "Triple Counter in Dealer Table of " + dealsOrTable,
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_statistics']//div[3]//span[2]"
            );
        }
        public static Component getOddCounter(String dealsOrTable) {
            return new Component(
                    "Odd Counter in Dealer Table of " + dealsOrTable,
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_statistics']//div[4]//span[2]"
            );
        }
        public static Component getEvenCounter(String dealsOrTable) {
            return new Component(
                    "Even Counter in Dealer Table of " + dealsOrTable,
                    "Label",
                    "Game Lobby Page",
                    "//p[contains(text(),'" + dealsOrTable + "')]/ancestor::div[2]" +
                            "//div[@class='sicbo_line_statistics']//div[5]//span[2]"
            );
        }
        public static Component getBigResults(String tableName) {
            return new Component(
                    "Big Results",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + tableName + "')]/ancestor::div[2])//li//div[contains(@class, 'text text_')][normalize-space()='B']"
            );
        }
        public static Component getSmallResults(String tableName) {
            return new Component(
                    "Small Results",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + tableName + "')]/ancestor::div[2])//li//div[contains(@class, 'text text_')][normalize-space()='S']"
            );
        }
        public static Component getTripleResults(String tableName) {
            return new Component(
                    "Triple Results",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + tableName + "')]/ancestor::div[2])//li//div[contains(@class, 'text text_')][normalize-space()='T']"
            );
        }
        public static Component getOddResults(String tableName) {
            return new Component(
                    "Odd Results",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + tableName + "')]/ancestor::div[2])//li//div[contains(@class, 'text text_')][normalize-space()='O']"
            );
        }
        public static Component getEvenResults(String tableName) {
            return new Component(
                    "Even Results",
                    "Container",
                    "Game Lobby Page",
                    "(//p[contains(text(),'" + tableName + "')]/ancestor::div[2])//li//div[contains(@class, 'text text_')][normalize-space()='E']"
            );
        }
    }

}
