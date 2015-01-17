Feature: Broadleaf Commerce Data driven Login Functionality

   
Scenario Outline: 1. Verious invalid user and invalid password 
    Given As a not validated user
    When Browse to the url "http://demo.broadleafcommerce.org"
    Then Broadlief home page should show
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