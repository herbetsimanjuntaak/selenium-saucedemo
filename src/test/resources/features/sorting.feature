@regress @saucedemo @sorting

Feature: Sorting

  Background: Login successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"


  Scenario Outline: Sort product base on product name
    When user selects "<Sorting Option>" from the sorting options
    Then the product list should be displayed in "<Order By>" order product name
    Examples:
      | Sorting Option | Order By   |
      | Name (A to Z)  | ascending  |
      | Name (Z to A)  | descending |

  Scenario Outline: Sort product base on product price
    When user selects "<Sorting Option>" from the sorting options
    Then the product list should be displayed in "<Order By>" order by price
    Examples:
      | Sorting Option      | Order By   |
      | Price (high to low) | descending |
      | Price (low to high) | ascending  |