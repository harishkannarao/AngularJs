Feature: Home page feature

  Scenario: should redirect to phone list page for application url
    Given I go to application home page
    Then I should be on phone list page

  Scenario: should redirect to https url
    Given I go to application home page on http
    Then I should be on phone list page
    And I should see url as "https://localhost:8443/angularjs/app/index.html#/phones"
