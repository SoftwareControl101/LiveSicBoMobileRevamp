package pages;

import utilities.objects.Component;

public class Settings {

    /***************************************************************************************************************
     * These are the button components on the Settings Page.
     ***************************************************************************************************************/
    public static class Button {
        public static Component Back = new Component(
                "Back",
                "Button",
                "Settings Page",
                "//div[@class='nav_bar']//button[@class='back_btn']"
        );
    }

    /***************************************************************************************************************
     * These are the radio button components on the Settings Page.
     ***************************************************************************************************************/
    public static class RadioButton {
        public static Component Music = new Component(
                "Music",
                "Radio Button",
                "Settings Page",
                "//span[normalize-space()='Music']/ancestor::div[2]//label//input"
        );
        public static Component Voice = new Component(
                "Voice",
                "Radio Button",
                "Settings Page",
                "//span[normalize-space()='Voice']/ancestor::div[2]//label//input"
        );
    }

    /***************************************************************************************************************
     * These are the label components on the Settings Page.
     ***************************************************************************************************************/
    public static class Label {
        public static Component Music = new Component(
                "Music",
                "Label",
                "Settings Page",
                "//span[normalize-space()='Music']"
        );
        public static Component Voice = new Component(
                "Voice",
                "Label",
                "Settings Page",
                "//span[normalize-space()='Voice']"
        );
    }

}
