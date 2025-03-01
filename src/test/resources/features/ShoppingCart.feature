@cart @regression

Feature: User's shopping cart is updated correctly

  Background: User is logged in and is on the Shopping Cart page
    Given User "standard_user" logs in to the application
    Then User is on the Inventory page
    When User adds "Sauce Labs Backpack" to the shopping cart
    Then Cart count displayed on the cart icon is "1"

  Scenario: User verifies correct product has been added to the cart
    When User clicks the cart icon
    Then User lands on the shopping cart page
    And Verifies the product "Sauce Labs Backpack" in the cart is correct