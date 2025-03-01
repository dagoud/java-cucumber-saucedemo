@inventory @regression

Feature: User is able to interact with products from the Inventory

  Background: User is logged in and is on the Inventory page
    Given User "standard_user" logs in to the application
    Then User is on the Inventory page

  Scenario: User is able to add and remove first product in th shopping cart
    When User adds product 1 in the inventory to the shopping cart
    Then Cart count displayed on the cart icon is 1
    When User clicks remove product 1 in the inventory
    Then No cart count is displayed
