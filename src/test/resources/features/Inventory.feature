@inventory @regression

Feature: User is able to interact with products from the Inventory

  Background: User is logged in and is on the Inventory page
    Given User "standard_user" logs in to the application
    Then User is on the Inventory page

  Scenario: Add first product to cart and assert that 1 is displayed on the cart icon
    When User adds first product in the list to the shopping cart
    Then Cart count displayed on the cart icon is "1"