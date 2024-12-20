@regress @saucedemo @checkout

Feature: Checkout

  Background: User is on the checkout page
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"
    And user add some products randomly
    And user click on icon cart
    And user click the product checkout button


  Scenario: Verify user able input buyer information when checkout
    When user input firstname "Herbet"
    And user input lastname "Simanjuntak"
    And user input postal code "10250"
    Then verify first name is "Herbet" last name is "Simanjuntak" and postal code is "10250"


  Scenario Outline: Verify system display error message when checkout with empty "< Firstname, Lastname, Postal Code, All Empty>"
    And user input firstname "<First Name>"
    And user input lastname "<Last Name>"
    And user input postal code "<Postal Code>"
    When user click on continue button
    Then system display error message "<Error Message>"
    Examples:
      | First Name | Last Name   | Postal Code | Error Message                  |
      |            | Simanjuntak | 10250       | Error: First Name is required  |
      | Herbet     |             | 10250       | Error: Last Name is required   |
      | Herbet     | Simanjuntak |             | Error: Postal Code is required |
      |            |             |             | Error: First Name is required  |


  Scenario: Verify system displays detailed purchase information before completing the transaction
    Given user successfully checkout using firstname "Herbet" lastname "Simanjuntak" and postal code "10250"
    When user click on continue button
    Then system display "Checkout: Overview" title
    And system display product with quantity and total price

  Scenario: Verify user able cancel transaction on Checkout Overview Page
    Given user successfully checkout using firstname "Herbet" lastname "Simanjuntak" and postal code "10250"
    And user click on continue button
    When user click on cancel button
    Then user views the product list

  Scenario: Verify user able cancel transaction on buyer data page
    When user click on cancel button
    Then system display "Your Cart" title

  Scenario: Verify system display message when order successfully created
    Given user successfully checkout using firstname "Herbet" lastname "Simanjuntak" and postal code "10250"
    And user click on continue button
    When user click on finish button
    Then system display order complete

  Scenario: Verify system displays a list of products by clicking the Back Home button after successfully create order
    Given user successfully checkout using firstname "Herbet" lastname "Simanjuntak" and postal code "10250"
    And user click on continue button
    And user click on finish button
    When user click on back home button
    Then user views the product list