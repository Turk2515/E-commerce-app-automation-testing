@regression
Feature: user should be login to the website

  #Test Case 1
  Scenario: user login with valid username and password
    When user enter valid username and password
    And user press enter button
    Then user could login successfully

  #Test Case 2
  Scenario: user login with invalid username
    When user enter invalid username
    Then user couldn't login successfully by username

  #Test Case 3
  Scenario: user login with valid username and invalid password
  When user enter valid username
  And enter invalid password
  Then user couldn't login successfully by password