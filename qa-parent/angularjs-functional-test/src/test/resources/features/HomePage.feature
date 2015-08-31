Feature: Home page feature

  Scenario: should redirect to phone list page for application url
    Given I go to application home page
    Then I should be on phone list page
