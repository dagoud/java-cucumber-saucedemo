@login @regression

Feature: Login to the Sauce demo application

  Scenario: Login
    When User "standard_user" logs in to the application
    Then User has logged in (can see the logout link)