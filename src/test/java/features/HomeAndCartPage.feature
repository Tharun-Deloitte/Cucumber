Feature: Home page and cart page scenarios
  Background: User login
    Given User is on SauceLabs Login Page
    When User enters the login details standard_user secret_sauce and clicks on login
    Then Verify user is in home page

  @home
  Scenario: Add and delete products
    Given Verify user is in home page
    When User adds the "Sauce Labs Onesie"
    And Get the cart count
    And User adds the "Sauce Labs Bike Light"
    Then Cart number increases

