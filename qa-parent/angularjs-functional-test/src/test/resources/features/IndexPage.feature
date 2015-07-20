Feature: Index page feauture

  Scenario: should load phone details page as default home page
    Given I go to index page
    Then I should be on phone list page

  Scenario: should load phone details page non-existing urls
    Given I go to a non-existing page
    Then I should be on phone list page