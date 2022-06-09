@regression
Feature: user could select different Categories
  Scenario: select different Categories
    Given user login firstly
    And go to home page
    When click on all category
    And choose one category
    And choose one sub-category
    Then choose a product