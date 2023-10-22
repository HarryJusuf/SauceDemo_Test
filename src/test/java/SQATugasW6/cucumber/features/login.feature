Feature: Login SauceDemo

  Scenario: Success Login
    Given sauceDemo Login Page
    When input Username
    And input Password
    And click login button
    Then user in Main Content Page


  Scenario: Failed Login
    Given sauceDemo Login Page
    When input Username
    And input Invalid Password
    And click login button
    Then shown error login message


  Scenario: Locked Out User Login
    Given sauceDemo Login Page
    When input Locked Username
    And input Password
    And click login button
    Then shown locked user message


  Scenario: Unknown User Login
    Given sauceDemo Login Page
    When input Unknown Username
    And input Password
    And click login button
    Then shown error login message
