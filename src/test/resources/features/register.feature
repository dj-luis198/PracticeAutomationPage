@register
Feature: Test the functionality of the page automationpractice.com
Scenario: The user enters his data to register on the page
Given Will enter the page automationpractice.com
When Click on Sign in button
And Register your email
And Press the create account button
And Enter your personal data
And Enter your address information
And Press the register button
Then I should be registered