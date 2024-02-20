package modules.ResultAndStatistics;

import globals.BettingOption;
import pages.DealerTable;
import pages.Statistics;
import utilities.handlers.*;
import utilities.interfaces.ResAndStatsCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResAndStatsWait extends ResAndStats {

    static int[] roundResult = new int[3];
    static List<ResAndStatsCase> resAndStatsCaseList;
    static List<Integer> ignoreTestCase, ignoreDivision;

    public static void waitUntilWins(int numberOfRounds, List<ResAndStatsCase> resAndStatsCases) {
        testCaseList = getTestCaseList(resAndStatsCases);
        divisionList = getDivisionList(resAndStatsCases);
        resAndStatsCaseList = resAndStatsCases;

        for (int round = 1; round <= numberOfRounds; round++) {
            try {

                ignoreTestCase = new ArrayList<>();
                ignoreDivision = new ArrayList<>();

                System.out.println();
                System.out.println("Round #" + round);
                System.out.println();

                setBeforeDealing(round);
                setRoundResult();
                setAfterDealing();

                System.out.println("    " + testCaseList.length + " Test Cases Left: " + DataTypeHandler.toString(testCaseList));
                System.out.println("    " + ignoreTestCase.size() + " Ignored Test Cases: " + DataTypeHandler.toString(ignoreTestCase));
                System.out.println("    " + divisionList.length + " Divisions Left: " + DataTypeHandler.toString(divisionList));
                System.out.println("    " + ignoreDivision.size() + " Ignored Divisions: " + DataTypeHandler.toString(ignoreDivision));

                if (testCaseList.length == 0) {
                    System.out.println();
                    System.out.println("Total Rounds To Complete: " + round);
                    System.out.println();
                    break;
                }

            } catch (Exception e) {
                PrintHandler.printError("Failed on Round #" + round + " Due to the Following Cause: " + e.getMessage());
            }
        }
    }

    private static int[] getTestCaseList(List<ResAndStatsCase> listCaseOfResAndStats) {
        Set<Integer> uniqueTestCases = listCaseOfResAndStats.stream()
                .map(ResAndStatsCase::getTestCase)
                .filter(testCase -> testCase != 0)
                .collect(Collectors.toSet());
        return uniqueTestCases.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] getDivisionList(List<ResAndStatsCase> listCaseOfResAndStats) {
        Set<Integer> uniqueDivisions = listCaseOfResAndStats.stream()
                .map(ResAndStatsCase::getDivision)
                .filter(division -> division != 0)
                .collect(Collectors.toSet());
        return uniqueDivisions.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void setBeforeDealing(int round) {
        waitBettingPhase(15, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);

        if (round == 1) setResAndStats();

        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.BIG));
        EventHandler.click(DealerTable.BettingOption.getMainBet(BettingOption.SMALL));
        EventHandler.click(DealerTable.Button.Confirm);
    }

    private static void setRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);
        tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        System.out.println("    Table Information: " + tableInfo);
        roundResult = getRoundResult();
        System.out.println("    Round Result: " + DataTypeHandler.toString(roundResult));
    }

    private static void setAfterDealing() {
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        setResAndStats();
        processResAndStatsCases(resAndStatsCase -> resAndStatsCase.saveTestCase(roundResult));
    }

    private static void setResAndStats() {
        EventHandler.click(DealerTable.Button.Statistics);
        totalResultHistory = getSize(Statistics.Container.AllResults);
        processResAndStatsCases(ResAndStatsCase::setStatistics);
        String fileName = tableInfo + " " + DataTypeHandler.toString(roundResult);
        FileHandler.Image.capture(fileName, "statistics", false);
        EventHandler.click(Statistics.Button.CloseStatistics);
    }

    private static void processResAndStatsCases(Consumer<ResAndStatsCase> action) {
        for (ResAndStatsCase resAndStatsCase : resAndStatsCaseList) {
            try {
                if (!ignoreTestCase.contains(resAndStatsCase.getTestCase()) &&
                        !ignoreDivision.contains(resAndStatsCase.getDivision()))
                    action.accept(resAndStatsCase);
            } catch (Exception e) {
                ignoreTestCase.add(resAndStatsCase.getTestCase());
                ignoreDivision.add(resAndStatsCase.getDivision());
                PrintHandler.printError("Test Case " + resAndStatsCase.getTestCase() +
                        " Division " + resAndStatsCase.getDivision() + ": " + e.getMessage());
            }
        }
    }

}
