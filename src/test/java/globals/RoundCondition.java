package globals;

import utilities.handlers.DataTypeHandler;

import java.util.Arrays;

public class RoundCondition {

    /***************************************************************************************************************
     * These methods checks the results of each round in the Live Roulette Revamp Game.
     ***************************************************************************************************************/

    public static boolean isSingleDiceWin(int[] result, int dice) {
        return DataTypeHandler.find(dice, result);
    }

    public static boolean isSpecificDoubleWin(int[] result, int dice) {
        return Arrays.stream(result).filter(value -> value == dice).count() >= 2;
    }

    public static boolean isAnyDoubleWin(int[] result) {
        return Arrays.stream(result).anyMatch(value -> Arrays.stream(result).filter(v -> v == value).count() >= 2);
    }

    public static boolean isTwoDiceComboWin(int[] result, int firstDice, int secondDice) {
        return Arrays.stream(result).anyMatch(value -> value == firstDice) &&
                Arrays.stream(result).anyMatch(value -> value == secondDice);
    }

    public static boolean isSpecificTripleWin(int[] result, int dice) {
        return Arrays.stream(result).filter(value -> value == dice).count() == 3;
    }

    public static boolean isThreeDiceTotalWin(int[] result, int number) {
        return DataTypeHandler.sum(result) == number;
    }

    public static boolean isAnyTripleWin(int[] result) {
        for (int i = 1; i < result.length; i++) if (result[i] != result[0]) return false;
        return true;
    }

    public static boolean isBigWin(int[] result) {
        if (isAnyTripleWin(result)) return false;
        int total = DataTypeHandler.sum(result);
        return total >= 11 && total <= 17;
    }

    public static boolean isSmallWin(int[] result) {
        if (isAnyTripleWin(result)) return false;
        int total = DataTypeHandler.sum(result);
        return total >= 4 && total <= 10;
    }

    public static boolean isOddWin(int[] result) {
        if (isAnyTripleWin(result)) return false;
        return DataTypeHandler.sum(result) % 2 != 0;
    }

    public static boolean isEvenWin(int[] result) {
        if (isAnyTripleWin(result)) return false;
        return DataTypeHandler.sum(result) % 2 == 0;
    }

}
