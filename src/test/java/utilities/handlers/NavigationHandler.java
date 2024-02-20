package utilities.handlers;

import utilities.settings.Variables;

import java.net.HttpURLConnection;
import java.net.URL;

public class NavigationHandler extends Variables {

    /***************************************************************************************************************
     * The 'goTo' method is used for navigating to the website.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void goTo(String url) {
        try {
            driver.get(url);
            if (getStatus() == 404) throw new RuntimeException("404 Not Found Error");
        } catch (Exception e) {
            PrintHandler.printError("Failed to go to the URL of " + url);
            throw e;
        }
    }

    /***************************************************************************************************************
     * The 'getStatus' method is used to get the status of navigating to the website.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    private static int getStatus() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (Exception e) { return -1; }
    }

    /***************************************************************************************************************
     * The 'refresh' method is used for reloading the website.
     ***************************************************************************************************************/

    public static void refresh() { jsExecutor.executeScript("location.reload();"); }

}
