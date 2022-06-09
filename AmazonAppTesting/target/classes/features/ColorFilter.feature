@regression
Feature: user could filter with color
  Scenario: select product(shoes) by color
    Given user login firstly
    And go to home page
    When click on all category
    And choose men fashion category
    And choose shoes category
    Then select color