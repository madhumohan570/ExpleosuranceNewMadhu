@AllScenarios
Feature: Forgot Password

  @ForgotPassword
  Scenario: User is changing the password
    Given User is in the login page
    When User changes the password
    And Closes the browser
