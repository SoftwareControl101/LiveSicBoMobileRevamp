package pages;

import utilities.objects.Component;

public class LimitsAndPayouts {

    /***************************************************************************************************************
     * These are the button components on the Limits And Payouts Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "Limits And Payouts Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Limits And Payouts Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component TableName = new Component(
                "Table Name",
                "Label",
                "Limits And Payouts Page",
                "//h3[contains(normalize-space(), 'Sic Bo')]"
        );
        public static Component TableLimit = new Component(
                "Table Limit",
                "Label",
                "Limits And Payouts Page",
                "//h3[contains(normalize-space(), 'Sic Bo')]//span"
        );
        public static Component SmallLimit = new Component(
                "Small Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Small']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component SmallPayout = new Component(
                "Small Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Small']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component BigLimit = new Component(
                "Big Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Big']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component BigPayout = new Component(
                "Big Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Big']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component EvenLimit = new Component(
                "Even Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Even']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component EvenPayout = new Component(
                "Even Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Even']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component OddLimit = new Component(
                "Odd Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Odd']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component OddPayout = new Component(
                "Odd Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Odd']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component SingleNumberLimit = new Component(
                "Single Number Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Single Number']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component OneOnSinglePayout = new Component(
                "1:1 on Single Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='1:1 on Single']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TwoOnSinglePayout = new Component(
                "2:1 on Double Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='2:1 on Double']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component ThreeOnSinglePayout = new Component(
                "3:1 on Triple Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='3:1 on Triple']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TwoDiceComboLimit = new Component(
                "Two Dice Combo Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Two Dice Combo']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TwoDiceComboPayout = new Component(
                "Two Dice Combo Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Two Dice Combo']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf4Or17Limit = new Component(
                "Total of 4 or 17 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 4 or 17']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf4Or17Payout = new Component(
                "Total of 4 or 17 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 4 or 17']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf5Or16Limit = new Component(
                "Total of 5 or 16 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 5 or 16']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf5Or16Payout = new Component(
                "Total of 5 or 16 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 5 or 16']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf6Or15Limit = new Component(
                "Total of 6 or 15 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 6 or 15']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf6Or15Payout = new Component(
                "Total of 6 or 15 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 6 or 15']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf7Or14Limit = new Component(
                "Total of 7 or 14 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 7 or 14']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf7Or14Payout = new Component(
                "Total of 7 or 14 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 7 or 14']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf8Or13Limit = new Component(
                "Total of 8 or 13 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 8 or 13']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf8Or13Payout = new Component(
                "Total of 8 or 13 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 8 or 13']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf9Or12Limit = new Component(
                "Total of 9 or 12 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 9 or 12']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf9Or12Payout = new Component(
                "Total of 9 or 12 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 9 or 12']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component TotalOf10Or11Limit = new Component(
                "Total of 10 or 11 Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 10 or 11']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component TotalOf10Or11Payout = new Component(
                "Total of 10 or 11 Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Total of 10 or 11']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component SpecificDoubleLimit = new Component(
                "Specific Double Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Specific Double']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component SpecificDoublePayout = new Component(
                "Specific Double Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Specific Double']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component AnyTripleLimit = new Component(
                "Any Triple Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Any Triple']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component AnyTriplePayout = new Component(
                "Any Triple Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Any Triple']/ancestor::div[1]//div[@class='row_item'][3]"
        );
        public static Component SpecificTripleLimit = new Component(
                "Specific Triple Limit",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Specific Triple']/ancestor::div[1]//div[@class='row_item'][2]"
        );
        public static Component SpecificTriplePayout = new Component(
                "Specific Triple Payout",
                "Label",
                "Limits And Payouts Page",
                "//div[normalize-space()='Specific Triple']/ancestor::div[1]//div[@class='row_item'][3]"
        );
    }

}
