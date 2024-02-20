@ResultAndStatistics
Feature: Result And Statistics

  @ResultAndStatisticsWait
  Scenario: RS Fetch: Wait Until There Is A Round Result For Result And Statistics
    Given I Go To The Live Casino
    When I Join Live Sic Bo Revamp
    And I Enter The Dealer Table With 300 Rounds
    Then I Place A Bet Until There Is A Round Result For All Results And Statistics
      | Big Result            |
      | Small Result          |
      | Any Triple Result     |
      | Big Percentage        |
      | Any Triple Percentage |
      | Small Percentage      |
      | Odd Percentage        |
      | Even Percentage       |
      | Dice 1 Percentage     |
      | Dice 2 Percentage     |
      | Dice 3 Percentage     |
      | Dice 4 Percentage     |
      | Dice 5 Percentage     |
      | Dice 6 Percentage     |
      | Hot Numbers Win       |
      | Cold Numbers Lose     |
      | Cold Numbers Win      |

  @ResultAndStatisticsTest1
  Scenario: RS Test 1: Checking The Data Displayed On Result Panel When Big Wins
    When I Check The Round Result
    Then I Verify The Result Panel When "Big" Wins

  @ResultAndStatisticsTest2
  Scenario: RS Test 2: Checking The Data Displayed On Result Panel When Small Wins
    When I Check The Round Result
    Then I Verify The Result Panel When "Small" Wins

  @ResultAndStatisticsTest3
  Scenario: RS Test 3: Checking The Data Displayed On Result Panel When Any Triple Wins
    When I Check The Round Result
    Then I Verify The Result Panel When "Any Triple" Wins

  @ResultAndStatisticsTest4_1
  Scenario: RS Test 1 Of 4: Checking The Big Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Big" Percentage Displayed

  @ResultAndStatisticsTest4_2
  Scenario: RS Test 2 Of 4: Checking The Any Triple Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Any Triple" Percentage Displayed

  @ResultAndStatisticsTest4_3
  Scenario: RS Test 3 Of 4: Checking The Small Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Small" Percentage Displayed

  @ResultAndStatisticsTest4_4
  Scenario: RS Test 4 Of 4: Checking The Odd Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Odd" Percentage Displayed

  @ResultAndStatisticsTest4_5
  Scenario: RS Test 5 Of 4: Checking The Even Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Even" Percentage Displayed

  @ResultAndStatisticsTest4_6
  Scenario: RS Test 6 Of 4: Checking The Dice 1 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 1" Percentage Displayed

  @ResultAndStatisticsTest4_7
  Scenario: RS Test 7 Of 4: Checking The Dice 2 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 2" Percentage Displayed

  @ResultAndStatisticsTest4_8
  Scenario: RS Test 8 Of 4: Checking The Dice 3 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 3" Percentage Displayed

  @ResultAndStatisticsTest4_9
  Scenario: RS Test 9 Of 4: Checking The Dice 4 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 4" Percentage Displayed

  @ResultAndStatisticsTest4_10
  Scenario: RS Test 10 Of 4: Checking The Dice 5 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 5" Percentage Displayed

  @ResultAndStatisticsTest4_11
  Scenario: RS Test 11 Of 4: Checking The Dice 6 Percentage Displayed On Statistics
    When I Check The Round Result
    Then I Verify The "Dice 6" Percentage Displayed

  @ResultAndStatisticsTest4_12
  Scenario: RS Test 12 Of 4: Checking The Hot Numbers Displayed On Statistics If They Win
    When I Check The Round Result
    Then I Verify The "Hot" Numbers Displayed If They "Win"

  @ResultAndStatisticsTest4_13
  Scenario: RS Test 13 Of 4: Checking The Cold Numbers Displayed On Statistics If They Did Not Win
    When I Check The Round Result
    Then I Verify The "Cold" Numbers Displayed If They "Lose"

  @ResultAndStatisticsTest4_14
  Scenario: RS Test 14 Of 4: Checking The Cold Numbers Displayed On Statistics If They Win
    When I Check The Round Result
    Then I Verify The "Cold" Numbers Displayed If They "Win"