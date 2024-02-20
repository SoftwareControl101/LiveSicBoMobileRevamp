package utilities.settings;

public class Constants {

    /***************************************************************************************************************
     * These constants are used to create folder, directory, and file names for every module.
     ***************************************************************************************************************/

    public static class Directory {
        private static final String USER_DIR = System.getProperty("user.dir");
        private static final String RESULTS_PATH = USER_DIR + "\\results";
        public static final String USER_INTERFACE_PATH = RESULTS_PATH + "\\UserInterface";
        public static final String BET_INFORMATION_PATH = RESULTS_PATH + "\\BetInformation";
        public static final String GAMEPLAY_PATH = RESULTS_PATH + "\\Gameplay";
        public static final String FUNCTIONALITY_PATH = RESULTS_PATH + "\\Functionality";
        public static final String PAYOUT_PATH = RESULTS_PATH + "\\Payout";
        public static final String RESULT_AND_STATS_PATH = RESULTS_PATH + "\\ResultAndStatistics";
        public static final String SCREENSHOTS_FOLDER = "\\screenshots";
        public static final String DATA_FILE = "\\data.txt";
    }

    /***************************************************************************************************************
     * These constants adjust the colors of test results displayed in the run console.
     ***************************************************************************************************************/

    public static class Color {
        private static final String ANSI_GREEN = "\u001B[32m";
        private static final String ANSI_YELLOW = "\u001B[33m";
        private static final String ANSI_BLUE = "\u001B[34m";
        private static final String ANSI_ORANGE = "\u001B[38;5;208m";
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String SUCCESS = ANSI_GREEN;
        public static final String ERROR = ANSI_YELLOW;
        public static final String INFO = ANSI_BLUE;
        public static final String WARNING = ANSI_ORANGE;
    }

}
