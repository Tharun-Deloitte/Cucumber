Feature: Home page and cart page scenarios
  Background: User login
    Given User is on SauceLabs Login Page
    When User enters the login details standard_user secret_sauce and clicks on login
    Then Verify user is in home page


  Scenario: Add the products and assert the change in cart count
    Given Verify user is in home page
    When User adds product "Sauce Labs Onesie"
    And Get the cart count
    And User adds product "Sauce Labs Fleece Jacket"
    Then Cart number increases


    Scenario: Add and delete the products asserrt the change in cart count
      Given Verify user is in home page
      When User adds product "Sauce Labs Onesie"
      And User adds product "Sauce Labs Fleece Jacket"
      And Get the cart count
      And Delete one product from cart
      Then Cart number decreases



    Scenario: Validate error msg in Checkout page
        Given Verfy user is in checkout page
        When User clicks continue button
        Then Error for checkout page is displayed


  @home
  Scenario: Add products and verify same products are displayed in cart page
    Given Verify user is in home page
    When User adds product "Sauce Labs Onesie"
    And User adds product "Sauce Labs Fleece Jacket"
    And Go to cart page
    Then Verify same products are displayed in cart page



