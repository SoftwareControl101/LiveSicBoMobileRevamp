package utilities.handlers;

import utilities.settings.Constants;

public class PrintHandler {

    /***************************************************************************************************************
     * The 'printError' method shows an error message.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void printError(String message) {
        System.out.println(Constants.Color.ERROR + message + Constants.Color.ANSI_RESET);
    }

    /***************************************************************************************************************
     * The 'printWarning' method shows a warning message.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void printWarning(String message) {
        System.out.println(Constants.Color.WARNING + message + Constants.Color.ANSI_RESET);
    }

    /***************************************************************************************************************
     * The 'printInfo' method shows an information message.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void printInfo(String message) {
        System.out.println(Constants.Color.INFO + message + Constants.Color.ANSI_RESET);
    }

    /***************************************************************************************************************
     * The 'printSuccess' method shows a success message.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void printSuccess(String message) {
        System.out.println(Constants.Color.SUCCESS + message + Constants.Color.ANSI_RESET);
    }

}
