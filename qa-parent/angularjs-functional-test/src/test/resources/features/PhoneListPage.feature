Feature: Phone List Page Features
  Scenario: should filter the phone list as a user types into the search box
    Given I go to phone list page
    Then I should see total number of phones as 3 on phone list page
    When I enter query as nexus on phone list page
    Then I should see total number of phones as 1 on phone list page
    When I enter query as motorola on phone list page
    Then I should see total number of phones as 2 on phone list page

  Scenario: should display greeting on the pone list page
    Given I go to phone list page
    Then I should see the name as World on phone list page

  Scenario: should display filter query on page title
    Given I go to phone list page
    Then I should see the title as Google Phone Gallery on phone list page
    When I enter query as nexus on phone list page
    Then I should see the title as Google Phone Gallery: nexus on phone list page
    When I clear the query on phone list page
    Then I should see the title as Google Phone Gallery on phone list page

  Scenario: should select age as the default sort order
    Given I go to phone list page
    Then I should see the value of sort by as age on phone list page

  Scenario: should be able to sort without query
    Given I go to phone list page
    When I set sort by as name on phone list page
    Then I should see the list of phone names as below on phone list page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
      | Nexus S |
    When I set sort by as age on phone list page
    Then I should see the list of phone names as below on phone list page
      | Nexus S |
      | Motorola XOOM with Wi-Fi |
      | MOTOROLA XOOM |
    When I set sort by as -age on phone list page
    Then I should see the list of phone names as below on phone list page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
      | Nexus S |

  Scenario: should be able to sort with query
    Given I go to phone list page
    And I enter query as moto on phone list page
    When I set sort by as name on phone list page
    Then I should see the list of phone names as below on phone list page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |
    When I set sort by as age on phone list page
    Then I should see the list of phone names as below on phone list page
      | Motorola XOOM with Wi-Fi |
      | MOTOROLA XOOM |
    When I set sort by as -age on phone list page
    Then I should see the list of phone names as below on phone list page
      | MOTOROLA XOOM |
      | Motorola XOOM with Wi-Fi |

  Scenario: should display the description on phone list view
    Given I go to phone list page
    Then I should see the list of phone snippet as below on phone list page
      | Fast just got faster with Nexus S.  |
      | The Next, Next Generation tablet.   |
      | The Next, Next Generation tablet.   |

  Scenario: should display image on phone list view
    Given I go to phone list page
    Then I should see image for every phone on phone list page

  Scenario: should go to phone details page by clicking on phone image
    Given I go to phone list page
    And I click on phone image with id as 2 on phone list page
    Then I should be on phone details page
    And I should see the phone id as 2 on phone details page

  Scenario: should go to phone details page by clicking on phone name
    Given I go to phone list page
    And I click on phone name with id as 2 on phone list page
    Then I should be on phone details page
    And I should see the phone id as 2 on phone details page
