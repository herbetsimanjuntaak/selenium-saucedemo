@regress @saucedemo @product

Feature: Product

  Background: Login successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"


  Scenario: Verify system display button Add to Cart by default for all product
    And user views the product list
    Then system displays the Add to Cart button for all products

  Scenario: Verify "Remove" button appears after adding a product to cart
    When user adds product to the cart
    Then system should display "Remove" button for product

  Scenario: Verify system increases the number of items added each time a user adds a product
    When user add some products randomly
    Then number of product on cart icon equal to the number of product added previously

  Scenario: Verify system reduces the number of items added each time a user deletes a product
    And user add some products randomly
    When user user clicks on a random Remove button from the product list
    Then number of product on cart icon equal to the number of product added previously

