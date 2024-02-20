@BetInformation @Maintenance
Feature: Bet Information

  Background:
    Given I Go To The Live Casino
    And I Join Live Sic Bo Revamp
    And I Enter The Dealer Table

  @BetInformationTest1
  Scenario: BI Test 1: Checking Bet Information With Win Result
    When I Place Bet On Any Betting Option Until "Win"
    And I Go To My Bets On The Menu
    And I Click Bet Details
    Then I Verify The Bet Details Information With "Win Result"

  @BetInformationTest2
  Scenario: BI Test 2: Checking Bet Information With Lose Result
    When I Place Bet On Any Betting Option Until "Lose"
    And I Go To My Bets On The Menu
    And I Click Bet Details
    Then I Verify The Bet Details Information With "Lose Result"

  @BetInformationTest3
  Scenario: BI Test 3: Checking Bet Information With Multiple Bets
    When I Place Bet On Any Betting Option Until "Round Complete"
    And I Go To My Bets On The Menu
    And I Click Bet Details
    Then I Verify The Bet Details Information With "Multiple Bets"