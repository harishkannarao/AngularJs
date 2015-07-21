Feature: Phone Details Page Features

  Scenario: should display phone id in the title
    Given I go to phone details page with phone id as 1
    Then I should see the title as "Google Phone Gallery: 1" on phone details page