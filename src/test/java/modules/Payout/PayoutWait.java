package modules.Payout;

import pages.DealerTable;
import utilities.handlers.*;
import utilities.interfaces.PayoutCase;
import utilities.objects.TestResult;
import utilities.settings.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PayoutWait extends Payout {

    static int[] roundResult = new int[3];
    static List<PayoutCase> payoutCaseList;
    static List<Integer> ignoreTestCase;

    public static void waitUntilWins(int numberOfRounds, List<PayoutCase> payoutCases) {
        testCaseList = getTestCaseList(payoutCases);
        payoutCaseList = payoutCases;

        for (int round = 1; round <= numberOfRounds; round++) {
            try {

                ignoreTestCase = new ArrayList<>();

                System.out.println();
                System.out.println("Round #" + round);
                System.out.println();

                setBeforeDealing(round);
                setRoundResult();
                setAfterDealing();

                System.out.println("    " + testCaseList.length + " Test Cases Left: " + DataTypeHandler.toString(testCaseList));
                System.out.println("    " + ignoreTestCase.size() + " Ignored Test Cases: " + DataTypeHandler.toString(ignoreTestCase));

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

    private static int[] getTestCaseList(List<PayoutCase> payoutCases) {
        Set<Integer> uniqueTestCases = payoutCases.stream()
                .map(PayoutCase::getTestCase)
                .filter(testCase -> testCase != 0)
                .collect(Collectors.toSet());
        return uniqueTestCases.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void setBeforeDealing(int round) {
        totalWinBet = 0.0;
        totalWinResult = 0.0;
        balanceBeforeBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        System.out.println("    Balance Before Betting: " + balanceBeforeBetting);

        waitBettingPhase(round == 1 ? 40 : 20, false);
        WaitHandler.waitInvisibility(DealerTable.Label.PlaceYourBetsPlease, 150);

        processPayoutCases(PayoutCase::setBetOption);
        EventHandler.click(DealerTable.Button.Confirm);
        processPayoutCases(PayoutCase::getBetOption);
    }

    private static void setRoundResult() {
        WaitHandler.waitVisibility(DealerTable.Label.ShowDealing, 150);

        tableInfo = GetHandler.getText(DealerTable.Label.TableInfo);
        totalBet = GetHandler.getDouble(DealerTable.Label.TotalBet);
        balanceAfterBetting = GetHandler.getDouble(DealerTable.Label.BalanceValue);
        System.out.println("    Balance After Betting: " + balanceAfterBetting);

        roundResult = getRoundResult();

        String fileName = tableInfo + " " + DataTypeHandler.toString(roundResult);
        FileHandler.Image.capture(fileName, "rounds", false);

        System.out.println("    Round Result: " + DataTypeHandler.toString(roundResult));
    }

    private static void setAfterDealing() {
        processPayoutCases(payoutCase -> payoutCase.computeTestCase(roundResult));

        WaitHandler.waitVisibility(DealerTable.Label.PlaceYourBetsPlease, 150);
        balanceAfterDealing = getUpdatedBalance();
        System.out.println("    Balance After Dealing: " + balanceAfterDealing);

        String fileName = tableInfo + " " + DataTypeHandler.toString(roundResult);
        FileHandler.Image.capture(fileName, "balances", false);

        processPayoutCases(payoutCase -> payoutCase.saveTestCase(roundResult));
    }

    private static void processPayoutCases(Consumer<PayoutCase> action) {
        for (PayoutCase payoutCase : payoutCaseList) {
            try {
                if (!ignoreTestCase.contains(payoutCase.getTestCase())) action.accept(payoutCase);
            } catch (Exception e) {
                ignoreTestCase.add(payoutCase.getTestCase());
                PrintHandler.printError("Test Case " + payoutCase.getTestCase() + ": " + e.getMessage());
            }
        }
    }

    public static void verify(int testCase) {
        TestResult result = ResultHandler.getTestResult(testCase, 0, Constants.Directory.PAYOUT_PATH);

        double[] expectedResult = getArrayFromExpectedResult(result.getExpectedResult());
        double[] actualResult = getArrayFromActualResult(result.getActualResult());
        double[] otherInfo = getArrayFromOtherInfo(result.getOtherInfo());

        double expectedTotalBalance = expectedResult[0];
        double expectedTotalPayout = expectedResult[1];
        double expectedTotalWinLose = expectedResult[2];
        double actualTotalBalance = actualResult[0];
        double actualTotalPayout = actualResult[1];
        double actualTotalWinLose = actualResult[2];
        double balanceBeforeBetting = otherInfo[0];
        double balanceAfterBetting = otherInfo[1];
        double balanceAfterDealing = otherInfo[2];
        double payoutOdds = otherInfo[3];
        double chipValue = otherInfo[4];
        double payout = otherInfo[5];
        double totalBet = otherInfo[6];

        System.out.println();
        System.out.println("Module: PAYOUT");
        System.out.println("Test Case: " + result.getTestCase());
        System.out.println("Table Information: " + result.getTableInfo());
        System.out.println("Round Result: " + result.getRoundResult());
        System.out.println("Bet: " + chipValue);
        System.out.println("Payout Odds: " + payoutOdds);
        System.out.println("Payout: " + payout);
        System.out.println("Total Bet: " + totalBet);
        System.out.println("Balance Before Betting: " + balanceBeforeBetting);
        System.out.println("Balance After Betting: " + balanceAfterBetting);
        System.out.println("Balance After Dealing: " + balanceAfterDealing);
        System.out.println("Expected Total Balance: " + expectedTotalBalance);
        System.out.println("Expected Total Payout: " + expectedTotalPayout);
        System.out.println("Expected Total Win/Lose: " + expectedTotalWinLose);

        String balanceMessage = "Actual Total Balance: " + actualTotalBalance;
        AssertHandler.assertEquals(expectedTotalBalance, actualTotalBalance, balanceMessage, balanceMessage);

        String payoutMessage = "Actual Total Payout: " + actualTotalPayout;
        AssertHandler.assertEquals(expectedTotalPayout, actualTotalPayout, payoutMessage, payoutMessage);

        String winLoseMessage = "Actual Total Win/Lose: " + actualTotalWinLose;
        AssertHandler.assertEquals(expectedTotalWinLose, actualTotalWinLose, winLoseMessage, winLoseMessage);

        System.out.println();
    }

}
