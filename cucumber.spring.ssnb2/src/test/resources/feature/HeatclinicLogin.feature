Feature: Broadleaf Commerce Login Functionality

@debug
Scenario: 1. Invalid user valid password 
    Given As a not validated user
    When Browse to the "http://demo.broadleafcommerce.org/"
    Then Broadlief home page should show
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message display as "The ex-mail address and/or password entered do not match our records. Please try again"

