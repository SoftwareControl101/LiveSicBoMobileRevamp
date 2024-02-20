package pages;

import utilities.objects.Component;

public class ChipSettings {

    /***************************************************************************************************************
     * These are the container components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Container {
        public static Component MyChips = new Component(
                "List of My Chips",
                "Container",
                "Chip Settings Page",
                "//div[@class='chips']//button[@class='chip']"
        );
        public static Component ChipSelections = new Component(
                "List of Chip Selections",
                "Container",
                "Chip Settings Page",
                "//div[@class='chips chips_selections']//button[not(contains(@style, 'display: none'))]"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component Cancel = new Component(
                "Cancel",
                "Button",
                "Chip Settings Page",
                "//button[@class='btn_cancel']"
        );
        public static Component Save = new Component(
                "Save",
                "Button",
                "Chip Settings Page",
                "//button[normalize-space()='Save']"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Label {
        public static Component MyChips = new Component(
                "My Chips",
                "Label",
                "Chip Settings Page",
                "//span[normalize-space()='My Chips']"
        );
        public static Component ChipSelections = new Component(
                "Chip Selections",
                "Label",
                "Chip Settings Page",
                "//span[normalize-space()='Selections']"
        );
    }

    /***************************************************************************************************************
     * These are the methods on the Chip Settings Page.
     ***************************************************************************************************************/

    public static class Method {
        public static Component getChipSelection(String chipValue) {
            return new Component(
                    "#" + chipValue + " Chip Selection",
                    "Button",
                    "Chip Settings Page",
                    "//div[@class='chips chips_selections']" +
                            "//button[not(contains(@style, 'display: none'))]" +
                            "//p[text()='" + chipValue + "']/ancestor::button"
            );
        }
    }

}
