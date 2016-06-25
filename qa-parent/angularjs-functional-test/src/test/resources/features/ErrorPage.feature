Feature: Error page feature

  Scenario: should be able to navigate to home page
    Given I go to error page
    Then I should be on error page
    And I click on "Home Page" link
    Then I should be on phone list page