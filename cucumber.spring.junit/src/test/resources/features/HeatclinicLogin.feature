Feature: Broadleaf Commerce Login Functionality

Background:
  Given As a not validated user
    When Browse to the application
    Then Broadlief home page should show
    

  Scenario: 1. Invalid user valid password
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message display as "The e-mail address and/or password entered do not match our records. Please try again"

@functional @debug
  Scenario: 2. Invalid user invalid password
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameeraxxx" as password
    And Click login
    Then Invalid email or password message display as "The xe-mail address and/or password entered do not match our records. Please try again"

  Scenario: 3. Valid user valid password
    When User click login button
    And Enter "iivaan@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows

@debug    
  Scenario Outline: 4. Verious invalid user and invalid password 
    When User click login button
    And Enter "<emailaddress>" as emaill address
    And Enter "<password>" as password
    And Click login
    Then Invalid email or password message display as "The e-mail address and/or password entered do not match our records. Please try again"

Examples:
|emailaddress         |password|
|1eivaan@gmail.com    |invalid |
|2eivaan@gmail.com    |invalid |
|3eivaan@gmail.com    |invalid |
|4eivaan@gmail.com    |invalid |
|xyz@gmail.com        |xyz1234 |