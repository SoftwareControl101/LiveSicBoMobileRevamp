package utilities.handlers;

import org.junit.Assert;

import java.util.Objects;

public class AssertHandler {

    /***************************************************************************************************************
     * These methods handle the assertion of each condition during the verification process.
     ***************************************************************************************************************/

    @SuppressWarnings("unused")
    public static void assertTrue(boolean condition, String successMessage, String errorMessage) {
        if (!condition) PrintHandler.printError(errorMessage);
        Assert.assertTrue(errorMessage, condition);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertFalse(boolean condition, String successMessage, String errorMessage) {
        if (condition) PrintHandler.printError(errorMessage);
        Assert.assertFalse(errorMessage, condition);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertEquals(String expected, String actual, String successMessage, String errorMessage) {
        if (!Objects.equals(expected, actual)) PrintHandler.printError(errorMessage);
        Assert.assertEquals(errorMessage, expected, actual);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertNotEquals(String expected, String actual, String successMessage, String errorMessage) {
        if (Objects.equals(expected, actual)) PrintHandler.printError(errorMessage);
        Assert.assertNotEquals(errorMessage, expected, actual);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertEquals(double expected, double actual, String successMessage, String errorMessage) {
        if (expected != actual) PrintHandler.printError(errorMessage);
        Assert.assertEquals(errorMessage, expected, actual, 0.0);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertNotEquals(double expected, double actual, String successMessage, String errorMessage) {
        if (expected == actual) PrintHandler.printError(errorMessage);
        Assert.assertNotEquals(errorMessage, expected, actual, 0.0);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertEquals(int expected, int actual, String successMessage, String errorMessage) {
        if (expected != actual) PrintHandler.printError(errorMessage);
        Assert.assertEquals(errorMessage, expected, actual);
        PrintHandler.printSuccess(successMessage);
    }

    @SuppressWarnings("unused")
    public static void assertNotEquals(int expected, int actual, String successMessage, String errorMessage) {
        if (expected == actual) PrintHandler.printError(errorMessage);
        Assert.assertNotEquals(errorMessage, expected, actual);
        PrintHandler.printSuccess(successMessage);
    }

}
