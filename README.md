# Sauce Demo Web UI Automation

Automated testing project for the Sauce Demo website using Selenium, Java, Maven, and Cucumber.

## Project Overview

This project automates the testing of the Sauce Demo e-commerce platform to ensure the accuracy and reliability of its
web interface. The tests cover various features, including:

* **LOGIN** - User authentication (login/logout)
* **PRODUCT** - Adding products to the cart
* **SORTING** - Sorting products by price and name
* **MENU** - Testing navigation and menu interactions
* **CART** - Managing items in the cart
* **CHECKOUT** - Completing the checkout process and validating error messages

## Tools & Technologies

* **Language**: Java
* **Build Tool**: Maven
* **Automation Framework**: Selenium WebDriver
* **Testing Framework**: Cucumber (BDD Approach)
* **Reporting**: Cucumber HTML and JSON Reports
* **Design Pattern**: Page Object Model (POM)

## Installation & Setup

1. Clone this repository using this command
   ```sh
   git clone https://github.com/herbetsimanjuntaak/selenium-saucedemo.git
   ```
2. Change directory to project directory
   ```sh
   cd saucedemo39
   ```
3. Install dependencies
   ```sh
   mvn clean install
   ```
4. Run tests
   ```sh
   mvn test
   ```

## Run tests with TestNG

- Navigate to the **testng_saucedemo.xml** file in your project root directory.
- Right-click on this file **testng_saucedemo.xml**
- Select Run.

## Documentation
- [Test Case Sauce Demo](https://docs.google.com/spreadsheets/d/1G1ycQa6dxkMWKwhEz87vKUnIZIdLpTgYxLe9NwSV8-g/edit?usp=sharing)

## 📝 Reports

![Screenshot 2024-12-21 022253](https://github.com/user-attachments/assets/e474c20c-ae75-42cf-8ac0-296d963e841c)
