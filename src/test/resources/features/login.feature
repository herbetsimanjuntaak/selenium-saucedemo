@regress @saucedemo @login

Feature: Login

  Scenario: Login successfully
    Given user access page "https://saucedemo.com/"
    When user input username "standard_user"
    And user input password "secret_sauce"
    And user click on login button
    Then system displays the burger menu

  Scenario: Logout Successfully
    Given user access page "https://saucedemo.com/"
    And user successfully using username "standard_user" and password "secret_sauce"
    When user click on burger menu button
    And user click on logout menu
    Then system display login form

  Scenario Outline: Negative Case Login with "<Locked User, Invalid User, Empty Password, Username>"
    Given user access page "https://saucedemo.com/"
    When user input username "<Username>"
    And user input password "<Password>"
    And user click on login button
    Then system display error message "<Error Message>"

    Examples:
      | Username        | Password     | Error Message                                                             |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      |                 |              | Epic sadface: Username is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | invalid_user    | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | password     | Epic sadface: Username and password do not match any user in this service |
