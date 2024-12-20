@regress @saucedemo @menu

Feature: Menu

  Background: Login successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"


  Scenario: Verify system direct to https://saucelabs.com/ when click on About Menu
    Given user click on burger menu button
    And user should see display sidebar menu
    When user click About link from the menu options
    Then the system should redirect to "https://saucelabs.com/"

  Scenario: Verify system direct to product list after click on All Items Menu
    When user click on icon cart
    And user click on burger menu button
    And user click on the All Items link in the sidebar
    Then system display "Products" title

  Scenario: Verify system hide left menu when click icon X on list menu
    Given user click on burger menu button
    When user click cross button sidebar menu
    Then system not display cross burger menu button



