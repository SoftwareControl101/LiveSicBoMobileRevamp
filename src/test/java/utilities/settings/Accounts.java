package utilities.settings;

import utilities.enums.Environment;

public class Accounts {

    /***************************************************************************************************************
     * The variable 'environment' represents the chosen environment for ongoing test execution.
     ***************************************************************************************************************/
    private static Environment environment;

    /***************************************************************************************************************
     * The 'setEnvironment' and 'getEnvironment' methods are utilized to configure the environment.
     * The 'setEnvironment' method is called within the navigation class.
     ***************************************************************************************************************/

    public static void setEnvironment(Environment env) {
        environment = env;
    }

    public static Environment getEnvironment() {
        return environment;
    }

    /***************************************************************************************************************
     * These methods are meant for getting the current environment and its account information.
     ***************************************************************************************************************/

    public static String getMobileUrl() {
        return switch (environment) {
            case PRODUCTION -> Production.MOBILE_URL;
            case UAT -> UAT.MOBILE_URL;
            case STAGING -> Staging.MOBILE_URL;
        };
    }

    public static String getUsername() {
        return switch (environment) {
            case PRODUCTION -> Production.USERNAME;
            case UAT -> UAT.USERNAME;
            case STAGING -> Staging.USERNAME;
        };
    }

    public static String getPassword() {
        return switch (environment) {
            case PRODUCTION -> Production.PASSWORD;
            case UAT -> UAT.PASSWORD;
            case STAGING -> Staging.PASSWORD;
        };
    }

    /***************************************************************************************************************
     * These enums are the available accounts for each environment.
     ***************************************************************************************************************/

    private static class Production {
        public static final String MOBILE_URL = "https://play.sbobet.com/";
        public static final String USERNAME = "idrauto03";
        public static final String PASSWORD = "asdf1234**";
    }

    private static class UAT {
        public static final String MOBILE_URL = "https://play.sbotest.com/";
        public static final String USERNAME = "idrauto03";
        public static final String PASSWORD = "asdf1234**";
    }

    private static class Staging {
        public static final String MOBILE_URL = "https://play.sbotry.com/";
        public static final String USERNAME = "zirconsmamaag020";
        public static final String PASSWORD = "asdf1234*";
    }

}
