@regress @saucedemo @cart

Feature: Cart

  Background: Login successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"


  Scenario: Verify system display cart page with click on cart icon
    When user click on icon cart
    Then system display "Your Cart" title

  Scenario: Verify system display product list with click on button Continue shopping
    When user click on icon cart
    And user click continue shopping
    Then system display "Products" title

  Scenario: Verify system remove product with click on button Remove on product list page
    And user add some products randomly
    When user user clicks on a random Remove button from the product list
    And user click on the cart link
    Then The removed product should not appear in the cart

  Scenario: Verify system clears all items from the cart by clicking on Reset App State
    And user add some products randomly
    And user click on burger menu button
    When user click on reset app state
    Then number of product on cart icon empty

  Scenario: Verify system remove product with click on button Remove on cart page
    And user add some products randomly
    And user click on icon cart
    When user user clicks on a random Remove button from the cart page
    Then The removed product should not appear in the cart
    And user click continue shopping
    And system should display "Add to cart" button for product
