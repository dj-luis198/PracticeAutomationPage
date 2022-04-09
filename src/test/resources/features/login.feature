@test
Feature: Test the functionality of the page automationpractice.com
  Scenario Outline: We will log in to access our user profile
    Given Will enter the page http://automationpractice.com/index.php

    When Click on Sign in
    And Enter your email <email>
    And Enter your password <pass>
    And Click on the Sign In button
    Then takes me to the user profile

      Examples:

        |email                |pass  |
        |mycuenta@gmail.com   |pass1   |


