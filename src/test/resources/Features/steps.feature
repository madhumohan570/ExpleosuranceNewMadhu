Feature: Expleo Insurance Demo

@LoginStep
Scenario: Check login is successful with correct credentials

Given User is in login page
When User enters valid email and password
And Clicks login
Then User is navigated to dashboard
And Close the browser

#@RegisterNewAccount
#Scenario: User can able to Register New Account
#
#Given User is in login page
#When User clicks register new account
#And User provides the details of new user
#Then User creates an account successfully
#When User enters valid email and password
#And Clicks login
#Then User is navigated to dashboard
#And Close the browser
#
#@NewInsurance
#Scenario: User can able to apply new insurance
#
#Given User is in login page
#When User enters valid email and password
#And Clicks login
#Then User is navigated to dashboard
#And User is applying for a new insurance
#Then User successfully created a new insurance policy
#
#@ForgotPassword
#Scenario: User is changing the password
#
#Given User is in login page
#When User changes the password
#And Close the browser
#
#@PaymentPage
#Given User is in login page
#When User enters valid email and password
#And Clicks login
#Then User is navigated to dashboard
#And User is navigating to payment page to proceed the payment
#Then User gets the payment processing popup message
#
#@ClaimsManagement
#Given User is in login page
#When User enters valid email and password
#And Clicks login
#Then User is navigated to dashboard
#And User is navigating to claims management page
#Then User views the claim list
#
