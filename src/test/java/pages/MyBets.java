package pages;

import utilities.objects.Component;

public class MyBets {

    /***************************************************************************************************************
     * These are the container components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component HistoryCards = new Component(
                "History Cards",
                "Container",
                "My Bets Page",
                "//div[@class='history_card']"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "My Bets Page",
                "//button[@class='back_btn']"
        );
        public static Component Running = new Component(
                "Running",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Running']"
        );
        public static Component Settled = new Component(
                "Settled",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Settled']"
        );
        public static Component Details = new Component(
                "Details",
                "Button",
                "My Bets Page",
                "//button[normalize-space()='Details']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the My Bets Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component TotalBetHistory = new Component(
                "Total Bet History",
                "Label",
                "My Bets Page",
                "//div[@class='total']//p[1]"
        );
        public static Component TableName = new Component(
                "Table Name",
                "Label",
                "My Bets Page",
                "//div[@class='title']//p"
        );
        public static Component RoundId = new Component(
                "Round ID",
                "Label",
                "My Bets Page",
                "//div[@class='title']//span[not(@class='icon')]"
        );
        public static Component GameStatus = new Component(
                "Game Status",
                "Label",
                "My Bets Page",
                "//div[contains(@class, 'status')]"
        );
        public static Component Stake = new Component(
                "Stake",
                "Label",
                "My Bets Page",
                "//h3[contains(normalize-space(), 'Stake')]/ancestor::div[1]//p"
        );
        public static Component WinLoss = new Component(
                "Win/Loss",
                "Label",
                "My Bets Page",
                "//h3[contains(normalize-space(), 'Win/Loss')]/ancestor::div[1]//p"
        );
        public static Component RefNo = new Component(
                "Reference Number",
                "Label",
                "My Bets Page",
                "//div[@class='info']//p[1]"
        );
        public static Component BetDate = new Component(
                "Bet Date",
                "Label",
                "My Bets Page",
                "//div[@class='info']//p[2]"
        );
        public static Component SettledMessage = new Component(
                "All transactions are time stamped at GMT-4.",
                "Label",
                "My Bets Page",
                "//div[@id='Settled_history']//p[@class='time_stamped'][normalize-space()='All transactions are time stamped at GMT-4.']"
        );
        public static Component RunningMessage = new Component(
                "All transactions are time stamped at GMT-4.",
                "Label",
                "My Bets Page",
                "//div[@id='Running_history']//p[@class='time_stamped'][normalize-space()='All transactions are time stamped at GMT-4.']"
        );
        public static Component RunningRoundId = new Component(
                "Running Round ID",
                "Label",
                "My Bets Page",
                "//div[@id='Running_history']//div[@class='title']//span[not(@class='icon')]"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the My Bets Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Component getDetailsButton(String roundId) {
            return new Component(
                    "Round ID #" + roundId + " Details",
                    "Button",
                    "My Bets Page",
                    "//span[contains(normalize-space(), '" + roundId + "')]/ancestor::div[3]" +
                            "//button[normalize-space()='Details']"
            );
        }
    }

}
