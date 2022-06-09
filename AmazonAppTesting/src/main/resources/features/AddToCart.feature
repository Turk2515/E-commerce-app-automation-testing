@regression
Feature: user could add different products to Shopping cart
  Scenario: add products to cart
    Given user login firstly
    And go to home page
    When click on all category
    And choose men fashion category
    And choose shoes category
    When select color
    And select item
    When select size
    And add item to cart
    Then item added to cart successfully