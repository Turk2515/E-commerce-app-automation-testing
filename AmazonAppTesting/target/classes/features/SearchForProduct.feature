@regression
Feature: User could search for any product

  Scenario: User could search for any product successfully
    Given user login firstly
    And go to home page
    Then click on search field successfully
