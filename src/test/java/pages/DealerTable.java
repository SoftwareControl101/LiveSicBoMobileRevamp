package pages;

import utilities.objects.Component;

public class DealerTable {

    /***************************************************************************************************************
     * These are the container components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component Announcement = new Component(
                "Announcement",
                "Container",
                "Dealer Table Page",
                "//div[@class='news_ticker']"
        );
        public static Component Timer = new Component(
                "Timer",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class, 'timer_small')]"
        );
        public static Component BettingOptions = new Component(
                "Betting Options",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class,'sic_bo_betting_options')]"
        );
        public static Component BetResult = new Component(
                "Bet Result",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class, 'bet_result_content')]"
        );
        public static Component Notification = new Component(
                "Notification",
                "Container",
                "Dealer Table Page",
                "//div[@class='snack_bar']"
        );
        public static Component BigBettingChip = new Component(
                "Big Betting Chip",
                "Container",
                "Dealer Table Page",
                "//div[contains(@class, 'main_bet_big')]//div[contains(@class, 'chip chip')]"
        );
        public static Component WinBettingOptions = new Component(
                "List of Win Betting Options",
                "Container",
                "Dealer Table Page",
                "//div[not(contains(@class, 'win_border'))" +
                        " and contains(@class, 'bet_option') and contains(@class, 'win')]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "Dealer Table Page",
                "//button[@class='back_btn']"
        );
        public static Component SkipWelcome = new Component(
                "Skip Welcome",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class,'welcome_skip_button')]"
        );
        public static Component HideShowBalance = new Component(
                "Hide/Show Balance",
                "Button",
                "Dealer Table Page",
                "//div[contains(@class, 'balance_btn')]"
        );
        public static Component Menu = new Component(
                "Menu",
                "Button",
                "Dealer Table Page",
                "//button[@class='menu']"
        );
        public static Component SwitchTable = new Component(
                "Switch Table",
                "Button",
                "Dealer Table Page",
                "//button[@class='tool_btn jump_table']"
        );
        public static Component ExpandShrink = new Component(
                "Expand/Shrink",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[1]"
        );
        public static Component TableLimit = new Component(
                "Table Limit",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[2]"
        );
        public static Component Statistics = new Component(
                "Statistics",
                "Button",
                "Dealer Table Page",
                "//div[@class='side_section_bottom']//button[3]"
        );
        public static Component Undo = new Component(
                "Undo",
                "Button",
                "Dealer Table Page",
                "//div[@class='pattern']//button[contains(@class, 'btn_cancel')]"
        );
        public static Component Double = new Component(
                "Double",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class, 'btn_double')]"
        );
        public static Component Confirm = new Component(
                "Confirm",
                "Button",
                "Dealer Table Page",
                "//button[contains(@class, 'btn_') and contains(@class, 'confirm')]"
        );
        public static Component EditChips = new Component(
                "Edit Chips",
                "Button",
                "Dealer Table Page",
                "//div[@class='chip_set']//li[contains(@data-gtm, 'Btn_ClickChipCustomize')]"
        );
        public static Component ChipOptions = new Component(
                "List of Chip Options",
                "Button",
                "Dealer Table Page",
                "//div[@class='chip_set']//li[not(contains(@data-gtm, 'Btn_ClickChipCustomize'))]"
        );
        public static Component ActionButtons = new Component(
                "List of Action Buttons",
                "Button",
                "Dealer Table Page",
                "//div[@class='pattern']//button"
        );
        public static Component PopUpConfirm = new Component(
                "PopUp Confirm",
                "Button",
                "Dealer Table Page",
                "//div[@class='popUp']//button[@class='confirm']"
        );
        public static Component PopUpNotNow = new Component(
                "PopUp Not Now",
                "Button",
                "Dealer Table Page",
                "//div[@class='popUp']//button[normalize-space()='Not Now']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component WelcomeAndGoodLuck = new Component(
                "Welcome and good luck.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Welcome and good luck')]"
        );
        public static Component ShowTimer = new Component(
                "Show Timer",
                "Label",
                "Dealer Table Page",
                "//p[@id='showTimer']"
        );
        public static Component PlaceYourBetsPlease = new Component(
                "Place your bets please",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Place your bets please')]"
        );
        public static Component ShowDealing = new Component(
                "Show Dealing",
                "Label",
                "Dealer Table Page",
                "//p[@id='showDealingWording']"
        );
        public static Component NoMoreBets = new Component(
                "No more bets",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'No more bets')]"
        );
        public static Component TableInfo = new Component(
                "Table Info",
                "Label",
                "Dealer Table Page",
                "//p[@class='table_info']"
        );
        public static Component TotalBet = new Component(
                "Total Bet",
                "Label",
                "Dealer Table Page",
                "//p[@class='total_bet']"
        );
        public static Component BalanceText = new Component(
                "Balance Text",
                "Label",
                "Dealer Table Page",
                "//div[contains(@class, 'balance_btn')]//p"
        );
        public static Component BalanceValue = new Component(
                "Balance Value",
                "Label",
                "Dealer Table Page",
                "//div[contains(@class, 'balance_btn')]//span[2]"
        );
        public static Component BetResultDices = new Component(
                "Bet Result Dices",
                "Label",
                "Dealer Table Page",
                "//div[contains(@class, 'bet_result_content')]//div[contains(@class, 'dice dice')]"
        );
        public static Component BetResultTotal = new Component(
                "Bet Result Total",
                "Label",
                "Dealer Table Page",
                "//div[contains(@class, 'bet_result_content')]//div[contains(@class, 'bet_result_total')]"
        );
        public static Component FirstNumberInResultPanel = new Component(
                "First Number In Result Panel",
                "Label",
                "Dealer Table Page",
                "//div[@class='sicbo_line_roadmap']//li[1]//p[1]"
        );
        public static Component BetsAccepted = new Component(
                "Bets accepted.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Bets accepted.')]"
        );
        public static Component ConfirmNow = new Component(
                "Confirm now?",
                "Label",
                "Dealer Table Page",
                "//p[@class='popUp_title']"
        );
        public static Component BettingIsClosing = new Component(
                "Betting is closing.",
                "Label",
                "Dealer Table Page",
                "//div[@class='popUp']//p[contains(normalize-space(), 'Betting is closing.')]"
        );
        public static Component WonValue = new Component(
                "Won Value",
                "Label",
                "Dealer Table Page",
                "//p[@class='you_won_amount_text']"
        );
        public static Component WonText = new Component(
                "Won Text",
                "Label",
                "Dealer Table Page",
                "//div[@class='you_won_title']"
        );
        public static Component GiveItATry = new Component(
                "Give It A Try",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'Give it a try?')]"
        );
        public static Component ExceededTheMaxBet = new Component(
                "You've exceeded the max bet amount.",
                "Label",
                "Dealer Table Page",
                "//p[contains(normalize-space(), 'exceeded the max bet amount.')]"
        );
        public static Component YourBetsAreBeingSettled = new Component(
                "Your bets are being settled right now. Please wait.",
                "Label",
                "Dealer Table Page",
                "//p[contains(text(),'Your bets are being settled right now. Please wait.')]"
        );
        public static Component RememberedYourChipSettings = new Component(
                "Remembered your chip settings.",
                "Label",
                "Dealer Table Page",
                "//p[contains(text(),'remembered your chip settings.')]"
        );
        public static Component NumbersInResultPanel = new Component(
                "List of Numbers In Result Panel",
                "Label",
                "Dealer Table Page",
                "(//div[contains(@class, 'sicbo_line_roadmap')]//p)[position() <= 12]"
        );
    }

    /***************************************************************************************************************
     * These are the betting options on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class BettingOption {
        public static Component getSingleDice(int singleDice) {
            return new Component(
                    "Single Dice #" + singleDice + " Betting Option",
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option single_dice_bet')]" +
                            "//div[@class='dice dice_" + singleDice + "']/ancestor::div[3]"
            );
        }
        public static Component getTwoDiceCombo(int firstDice, int secondDice) {
            return new Component(
                    "Two Dice Combo #" + firstDice + " & #" + secondDice + " Betting Option",
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option combination_bet')" +
                            " and descendant::div[@class='dice dice_" + firstDice + "']" +
                            " and descendant::div[@class='dice dice_" + secondDice + "']]"
            );
        }
        public static Component getSpecificTriple(int tripleDice) {
            return new Component(
                    "Specific Triple Dice #" + tripleDice + " Betting Option",
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option triple_bet')]" +
                            "//div[@class='dice dice_" + tripleDice + "']/ancestor::div[3]"
            );
        }
        public static Component getSpecificDouble(int doubleDice) {
            return new Component(
                    "Specific Double Dice #" + doubleDice + " Betting Option",
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option double_bet')]" +
                            "//div[@class='dice dice_" + doubleDice + "']/ancestor::div[3]"
            );
        }
        public static Component getThreeDiceTotal(int total) {
            return new Component(
                    "Three Dice Total #" + total + " Betting Option",
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option total_bet')]" +
                    "//div[normalize-space()='" + total + "']/ancestor::div[2]"
            );
        }
        public static Component getMainBet(String mainBet) {
            return new Component(
                    switch (mainBet) {
                        case "small" -> "Small Betting Option";
                        case "big" -> "Big Betting Option";
                        case "odd" -> "Odd Betting Option";
                        case "even" -> "Even Betting Option";
                        case "any_triple" -> "Any Triple Betting Option";
                        default -> "";
                    },
                    "Button",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option main_bet_" + mainBet + "')]"
            );
        }
    }

    /***************************************************************************************************************
     * These are the betting chips on the Dealer Table Page.
     ***************************************************************************************************************/

    public static class BettingChip {
        static String chipPath = "//div[contains(@class, 'chip_text')]";
        public static Component getSingleDice(int singleDice) {
            return new Component(
                    "Single Dice #" + singleDice + " Betting Chip",
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option single_dice_bet')]" +
                            "//div[@class='dice dice_" + singleDice + "']/ancestor::div[3]" +
                            chipPath
            );
        }
        public static Component getTwoDiceCombo(int firstDice, int secondDice) {
            return new Component(
                    "Two Dice Combo #" + firstDice + " & #" + secondDice + " Betting Chip",
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option combination_bet')" +
                            " and descendant::div[@class='dice dice_" + firstDice + "']" +
                            " and descendant::div[@class='dice dice_" + secondDice + "']]" +
                            chipPath
            );
        }
        public static Component getSpecificTriple(int tripleDice) {
            return new Component(
                    "Specific Triple Dice #" + tripleDice + " Betting Chip",
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option triple_bet')]" +
                            "//div[@class='dice dice_" + tripleDice + "']/ancestor::div[3]" +
                            chipPath
            );
        }
        public static Component getSpecificDouble(int doubleDice) {
            return new Component(
                    "Specific Double Dice #" + doubleDice + " Betting Chip",
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option double_bet')]" +
                            "//div[@class='dice dice_" + doubleDice + "']/ancestor::div[3]" +
                            chipPath
            );
        }
        public static Component getThreeDiceTotal(int total) {
            return new Component(
                    "Three Dice Total #" + total + " Betting Chip",
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option total_bet')]" +
                            "//div[normalize-space()='" + total + "']/ancestor::div[2]" +
                            chipPath
            );
        }
        public static Component getMainBet(String mainBet) {
            return new Component(
                    switch (mainBet) {
                        case "small" -> "Small Betting Chip";
                        case "big" -> "Big Betting Chip";
                        case "odd" -> "Odd Betting Chip";
                        case "even" -> "Even Betting Chip";
                        case "any_triple" -> "Any Triple Betting Chip";
                        default -> "";
                    },
                    "Label",
                    "Dealer Table Page",
                    "//div[contains(@class, 'bet_option main_bet_" + mainBet + "')]" +
                            chipPath
            );
        }
    }

}
