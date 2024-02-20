package pages;

import utilities.objects.Component;

public class LiveCasino {

    /***************************************************************************************************************
     * These are the thumbnail components on the Live Casino Page.
     ***************************************************************************************************************/

    public static class Thumbnail {
        public static Component LiveSicBoRevamp = new Component(
                "Live Sic Bo Revamp",
                "Thumbnail",
                "Live Casino Page",
                "//span[contains(text(), 'SBO Live Sic Bo')]//ancestor::li"
        );
    }

    /***************************************************************************************************************
     * These are the button components on the Live Casino Page.
     ***************************************************************************************************************/

    public static class Button {
        public static Component CloseBanner = new Component(
                "Close Banner",
                "Button",
                "Live Casino Page",
                "//div[contains(@class, 'BannerCloseButton')]"
        );
    }

}
