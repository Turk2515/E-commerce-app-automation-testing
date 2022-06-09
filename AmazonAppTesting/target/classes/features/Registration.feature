@regression
Feature: registration into the website

  Scenario: registration with valid data
    When enter valid name
    And enter mobile number or email
    And enter password
    And re_enter password and click continue
    Then registration successfully

