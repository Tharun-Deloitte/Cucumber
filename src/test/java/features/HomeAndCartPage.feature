Feature: Home page and cart page scenarios
  Background: User login
    Given User is on SauceLabs Login Page
    When User enters the login details standard_user secret_sauce and clicks on login
    Then Verify user is in home page

    @home
  Scenario: Add the products and assert the change in cart count
    Given Verify user is in home page
    When User adds any one product
    And Get the cart count
    And User adds any one product
    Then Cart number increases

    @home
    Scenario: Add and delete the products asserrt the change in cart count
      Given Verify user is in home page
      When User adds any one product
      And User adds any one product
      And Get the cart count
      And Delete one product from cart
      Then Cart number decreases


    @home
    Scenario: Validate error msg in Checkout page
        Given Verfy user is in checkout page
        When User clicks continue button
        Then Error for checkout page is displayed





