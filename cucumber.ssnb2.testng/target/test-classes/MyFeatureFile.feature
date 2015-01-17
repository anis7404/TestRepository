Feature: Broadleaf Commerce Login Functionality


  Scenario: 1. Invalid user valid password
    Given As a not validated user
    When Browse to the url "http://demo.broadleafcommerce.org"
    Then Broadlief home page should show
    When User click login button
    And Enter "iivaan_NotValid@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message display

  Scenario: 2. Valid user invalid password
    Given As a not validated user
    When Browse to the url "http://demo.broadleafcommerce.org"
    Then Broadlief home page should show
    When User click login button
    And Enter "iivaan@Gmail.com" as emaill address
    And Enter "ameera_notvalid" as password
    And Click login
    Then Invalid email or password message display

 Scenario: 3. Valid user valid password
    Given As a not validated user
    When Browse to the url "http://demo.broadleafcommerce.org"
    Then Broadlief home page should show
    When User click login button
    And Enter "iivaan@Gmail.com" as emaill address
    And Enter "ameera" as password
    And Click login
    Then Invalid email or password message not display
    And Welcome message shows


@debug 
 Scenario: 4. Add product to cart
    Given As a not validated user
    When Browse to the url "http://demo.broadleafcommerce.org"
    Then Broadlief home page should show
    When User click login button
    When User login with userid "iivaan@gmail.com" and password "ameera"
    And Welcome message shows
