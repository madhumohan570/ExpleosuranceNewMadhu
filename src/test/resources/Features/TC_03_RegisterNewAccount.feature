@AllScenarios
Feature: Register New Account


@RegisterNewAccount
Scenario: User can able to Register New Account

Given User can able to navigate to login page
When User clicks register new account
And User provides the details of new user
Then User creates an account successfully
When User enters email and password
And Clicks login button
Then User is navigated to dashboard page
And Close browser