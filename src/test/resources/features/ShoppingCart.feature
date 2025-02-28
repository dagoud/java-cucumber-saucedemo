Feature: User's shopping cart is updated

  Background:  User adds an item to their shopping cart
    Given
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks Login button
    Then User will redirect to Inventory page

  Scenario: Add first product to cart and assert that 1 is displayed on the cart icon
    When User adds first product in the list to the shopping cart
    Then Cart icon displays 1 item has been added