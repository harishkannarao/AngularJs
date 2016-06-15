Feature: Login page feature

  Scenario: should be able to perform basic login and logout
    Given I go to index page
    Then I should be on phone list page
    And I click on Login link
    Then I should be on login page