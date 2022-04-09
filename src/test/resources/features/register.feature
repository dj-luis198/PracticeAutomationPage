@register
Scenario: The user enters his data to register on the page
Given Will enter the page http://automationpractice.com/index.php

When Click on Sign in
And Enter your email to register
And Enter your personal data
And Enter your address information
And Press the register button
Then I should be registered