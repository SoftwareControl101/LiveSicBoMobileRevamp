@Payout @Maintenance
Feature: Payout

  @PayoutWait
  Scenario: PO Fetch: Wait Until There Is A Round Result For Payout
    Given I Go To The Live Casino
    When I Join Live Sic Bo Revamp
    And I Enter The Dealer Table
    Then I Place A Bet Until There Is A Round Result For All Payouts
      | Small                    |
      | Big                      |
      | Even                     |
      | Odd                      |
      | Any Triple               |
      | Three Dice Total 4 & 17  |
      | Three Dice Total 5 & 16  |
      | Three Dice Total 6 & 15  |
      | Three Dice Total 7 & 14  |
      | Three Dice Total 8 & 13  |
      | Three Dice Total 9 & 12  |
      | Three Dice Total 10 & 11 |
      | 1 To 1 On One Dice       |
      | 2 To 1 On One Dice       |
      | 3 To 1 On One Dice       |
      | Specific Triple          |
      | Two Dice Combo           |
      | Specific Double          |

  @PayoutTest1
  Scenario: PO Test 1: Checking The Payout Calculation Of Small Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Small" Betting Option

  @PayoutTest2
  Scenario: PO Test 2: Checking The Payout Calculation Of Big Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Big" Betting Option

  @PayoutTest3
  Scenario: PO Test 3: Checking The Payout Calculation Of Even Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Even" Betting Option

  @PayoutTest4
  Scenario: PO Test 4: Checking The Payout Calculation Of Odd Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Odd" Betting Option

  @PayoutTest6
  Scenario: PO Test 6: Checking The Payout Calculation Of Any Triple Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Any Triple" Betting Option

  @PayoutTest7
  Scenario: PO Test 7: Checking The Payout Calculation Of Three Dice Total 4 & 17 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 4 & 17" Betting Option

  @PayoutTest8
  Scenario: PO Test 8: Checking The Payout Calculation Of Three Dice Total 5 & 16 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 5 & 16" Betting Option

  @PayoutTest9
  Scenario: PO Test 9: Checking The Payout Calculation Of Three Dice Total 6 & 15 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 6 & 15" Betting Option

  @PayoutTest10
  Scenario: PO Test 10: Checking The Payout Calculation Of Three Dice Total 7 & 14 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 7 & 14" Betting Option

  @PayoutTest11
  Scenario: PO Test 11: Checking The Payout Calculation Of Three Dice Total 8 & 13 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 8 & 13" Betting Option

  @PayoutTest12
  Scenario: PO Test 12: Checking The Payout Calculation Of Three Dice Total 9 & 12 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 9 & 12" Betting Option

  @PayoutTest13
  Scenario: PO Test 13: Checking The Payout Calculation Of Three Dice Total 10 & 11 Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Three Dice Total 10 & 11" Betting Option

  @PayoutTest14
  Scenario: PO Test 14: Checking The Payout Calculation Of 1 To 1 On One Dice Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "1 To 1 On One Dice" Betting Option

  @PayoutTest15
  Scenario: PO Test 15: Checking The Payout Calculation Of 2 To 1 On One Dice Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "2 To 1 On One Dice" Betting Option

  @PayoutTest16
  Scenario: PO Test 16: Checking The Payout Calculation Of 3 To 1 On One Dice Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "3 To 1 On One Dice" Betting Option

  @PayoutTest17
  Scenario: PO Test 17: Checking The Payout Calculation Of Specific Triple Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Specific Triple" Betting Option

  @PayoutTest18
  Scenario: PO Test 18: Checking The Payout Calculation Of Two Dice Combo Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Two Dice Combo" Betting Option

  @PayoutTest19
  Scenario: PO Test 19: Checking The Payout Calculation Of Specific Double Betting Option
    When I Check The Round Result
    Then I Verify The Payout Calculation Of "Specific Double" Betting Option