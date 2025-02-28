Feature: Login

  @Test1
  Scenario: Login
    Given User is on Login Page
    When User fill username and password
    And User click Login button
    Then User will redirect to Products page