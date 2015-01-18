Feature: Broadleaf Commerce Login Functionality

Background:
  Given As a not validated user
    When Browse to the application
    Then Broadlief home page should show
    
@debug
  Scenario: 1. Invalid user valid password
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message display as "The e-mail address and/or password entered do not match our records. Please try again"


  Scenario: 2. Invalid user invalid password
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameeraxxx" as password
    And Click login
    Then Invalid email or password message display as "The e-mail address and/or password entered do not match our records. Please try again"


  Scenario: 3. Valid user valid password
    When User click login button
    And Enter "iivaan@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows
