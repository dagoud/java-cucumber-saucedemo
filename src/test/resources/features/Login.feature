Feature: Login to the Sauce demo application

  @Test1
  Scenario: Login
    When User "standard_user" logs in to the application
    Then User has logged in (can see the logout link)