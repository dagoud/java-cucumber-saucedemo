Feature: Users are able to interact with products from the Inventory

  Background:  User is logged in and is on the Inventory page
    Given User is on Login Page
    When User enters username "standard_user" and password "secret_sauce"
    And User is on the Inventory page

  Scenario: Add first product to cart and assert that 1 is displayed on the cart icon
    When User adds first product in the list to the shopping cart
    Then Cart icon displays 1 item has been added