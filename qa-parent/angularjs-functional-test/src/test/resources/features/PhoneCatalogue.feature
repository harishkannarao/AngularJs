Feature: Phone Catalogue Features
  Scenario: should filter the phone list as a user types into the search box
    Given I go to index page
    Then I should see total number of phones as 3 on index page
    When I enter query as nexus on index page
    Then I should see total number of phones as 1 on index page
    When I enter query as motorola on index page
    Then I should see total number of phones as 2 on index page

  Scenario: should display greeting on the pone list page
    Given I go to index page
    Then I should see the name as World on index page

  Scenario: should display filter query on page title
    Given I go to index page
    Then I should see the title as Google Phone Gallery: on index page
    When I enter query as nexus on index page
    Then I should see the title as Google Phone Gallery: nexus on index page