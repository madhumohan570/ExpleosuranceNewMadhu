@AllScenarios
Feature: Payment for Insurance

  @PaymentPage
  Scenario: Check Payment is done
    Given User is navigated to the login page
    When User enters emailid and password
    And Clicks the login button
    Then User is able to navigate to dashboard page
    And User is navigating to payment page to proceed the payment
    Then User gets the payment processing popup message
    And Quit browser
