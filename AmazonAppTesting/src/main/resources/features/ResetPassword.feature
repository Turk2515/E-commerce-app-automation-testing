@regression
Feature: reset user password

  Scenario: rest password successfully
    Given user login firstly
    When user go to account security settings to reset password
    And enter old password
    And enter new password
    And re_enter new password and click save changes
    Then password reset successfully