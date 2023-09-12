Feature: check valid login and invalid login

  Scenario Outline: Verify Invalid login
    Given User is on SauceLabs Login Page
    When User enters the login details <username> <password> and clicks on login
    Then Error msg is shown
    Examples:
      | username | password|
      | dssdfsfs |  sdvsss |
      |   vsvs   |    sfsdf|