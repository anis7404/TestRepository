$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyFeatureFile.feature");
formatter.feature({
  "id": "broadleaf-commerce-login-functionality",
  "description": "",
  "name": "Broadleaf Commerce Login Functionality",
  "keyword": "Feature",
  "line": 1
});
formatter.before({
  "duration": 2652709600,
  "status": "passed"
});
formatter.scenario({
  "id": "broadleaf-commerce-login-functionality;4.-add-product-to-cart",
  "tags": [
    {
      "name": "@debug",
      "line": 36
    }
  ],
  "description": "",
  "name": "4. Add product to cart",
  "keyword": "Scenario",
  "line": 37,
  "type": "scenario"
});
formatter.step({
  "name": "As a not validated user",
  "keyword": "Given ",
  "line": 38
});
formatter.step({
  "name": "Browse to the url \"http://demo.broadleafcommerce.org\"",
  "keyword": "When ",
  "line": 39
});
formatter.step({
  "name": "Broadlief home page should show",
  "keyword": "Then ",
  "line": 40
});
formatter.step({
  "name": "User click login button",
  "keyword": "When ",
  "line": 41
});
formatter.step({
  "name": "User login with userid \"iivaan@gmail.com\" and password \"ameera\"",
  "keyword": "When ",
  "line": 42
});
formatter.step({
  "name": "Welcome message shows",
  "keyword": "And ",
  "line": 43
});
formatter.match({
  "location": "HeatclinicSteps.as_a_not_validated_user()"
});
formatter.result({
  "duration": 88771600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "http://demo.broadleafcommerce.org",
      "offset": 19
    }
  ],
  "location": "HeatclinicSteps.browse_to_the_url(String)"
});
formatter.result({
  "duration": 1561250200,
  "status": "passed"
});
formatter.match({
  "location": "HeatclinicSteps.broadlief_home_page_should_show()"
});
formatter.result({
  "duration": 17127900,
  "status": "passed"
});
formatter.match({
  "location": "HeatclinicSteps.user_click_login_button()"
});
formatter.result({
  "duration": 2488828200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iivaan@gmail.com",
      "offset": 24
    },
    {
      "val": "ameera",
      "offset": 56
    }
  ],
  "location": "HeatclinicSteps.login(String,String)"
});
formatter.result({
  "duration": 6702255100,
  "status": "passed"
});
formatter.match({
  "location": "HeatclinicSteps.welcome_message_shows()"
});
formatter.result({
  "duration": 16920000,
  "status": "passed"
});
formatter.after({
  "duration": 105909900,
  "status": "passed"
});
});