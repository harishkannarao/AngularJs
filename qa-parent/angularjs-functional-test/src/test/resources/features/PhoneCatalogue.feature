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

  Scenario: should select age as the default sort order
    Given I go to index page
    Then I should see the value of sort by as age on index page

  Scenario: should be able to sort without query
    Given I go to index page
    When I set sort by as name on index page
    Then I should see the list of phone names as below on index page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
      | Nexus S |
    When I set sort by as age on index page
    Then I should see the list of phone names as below on index page
      | Nexus S |
      | Motorola XOOM with Wi-Fi |
      | MOTOROLA XOOM |
    When I set sort by as -age on index page
    Then I should see the list of phone names as below on index page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
      | Nexus S |

  Scenario: should be able to sort with query
    Given I go to index page
    And I enter query as moto on index page
    When I set sort by as name on index page
    Then I should see the list of phone names as below on index page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
    When I set sort by as age on index page
    Then I should see the list of phone names as below on index page
      | Motorola XOOM with Wi-Fi |
      | MOTOROLA XOOM |
    When I set sort by as -age on index page
    Then I should see the list of phone names as below on index page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
