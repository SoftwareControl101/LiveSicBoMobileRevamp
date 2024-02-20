package modules.ResultAndStatistics;

import globals.RoundCondition;
import globals.TestMethod;
import org.openqa.selenium.WebElement;
import pages.Statistics;
import utilities.handlers.DataTypeHandler;
import utilities.handlers.GetHandler;
import utilities.objects.Component;

import java.util.ArrayList;
import java.util.List;

public class ResAndStats extends TestMethod {

    protected static int[] testCaseList, divisionList;
    protected static String tableInfo;
    protected static double totalResultHistory;

    protected static String[] getActualLatestRoundResult() {
        List<WebElement> elements = GetHandler.getElements(Statistics.Label.LatestRoundResult);
        String[] dices = new String[3];
        for (int i = 0; i < 3; i++)
            dices[i] = elements.get(i).getAttribute("class").split(" ")[1].replace("dice_", "");
        String roundResult = elements.get(3).getText();
        String smallOrBig = elements.get(4).getText();
        String oddOrEven = elements.get(5).getText();
        return new String[]{dices[0], dices[1], dices[2], roundResult, smallOrBig, oddOrEven};
    }

    protected static String[] getExpectedLatestRoundResult(int[] result) {
        String[] dices = new String[3];
        for (int i = 0; i < 3; i++) dices[i] = Integer.toString(result[i]);
        String roundResult = Integer.toString(DataTypeHandler.sum(result));
        String smallOrBig = RoundCondition.isAnyTripleWin(result) ? "T" : RoundCondition.isBigWin(result) ? "B" : "S";
        String oddOrEven = RoundCondition.isAnyTripleWin(result) ? "T" : RoundCondition.isOddWin(result) ? "O" : "E";
        return new String[]{dices[0], dices[1], dices[2], roundResult, smallOrBig, oddOrEven};
    }

    protected double getPercentage(Component component) {
        double percentage;
        do percentage = GetHandler.getDouble(component);
        while (percentage == 0.0);
        return percentage;
    }

    protected static String getResultFromArray(int[] numberList, int[] counterList) {
        int capacity = (numberList.length + counterList.length) * 10;
        StringBuilder result = new StringBuilder(capacity);
        for (byte i = 0; i < numberList.length; i++) result.append('{').append(numberList[i]).append('-').append(counterList[i]).append('}');
        return result.toString();
    }

    @SuppressWarnings("all")
    protected static int[][] getArrayFromResult(String result) {
        result = result.substring(1, result.length() - 1);
        String[] parts = result.split("\\}\\{");
        List<Integer> numberList = new ArrayList<>();
        List<Integer> counterList = new ArrayList<>();
        for (String part : parts) {
            String[] tokens = part.split("-");
            if (tokens.length == 2) {
                numberList.add(Integer.parseInt(tokens[0]));
                counterList.add(Integer.parseInt(tokens[1]));
            }
        }
        int[] numbers = numberList.stream().mapToInt(Integer::intValue).toArray();
        int[] counters = counterList.stream().mapToInt(Integer::intValue).toArray();
        return new int[][] { numbers, counters };
    }

}
