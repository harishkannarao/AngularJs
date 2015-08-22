Feature: Properties Resource

  Scenario: should load properties file from module configuration
    Given I set the url to module on properties resource
    And I make a GET request on properties resource
    Then I should get http response status as 200 from properties resource
    And I should see sampleString as "My Sample String" from properties resource
    And I should see sampleStringArray as below from properties resource
      | Value 1 |
      | Value 2 |
      | Value 3 |
    And I should see sampleLong as 10 from properties resource
    And I should see enablePropertyChangeListener as true from properties resource

  Scenario: should change the values when the property is changes
    Given I set the url to module on properties resource
    And I make a GET request on properties resource
    Then I should see sampleString as "My Sample String" from properties resource
    And I change "sampleString" value to "Some other string" on property update resource
    And I wait for 1 seconds
    And I make a GET request on properties resource
    Then I should see sampleString as "Some other string" from properties resource
    And I change "sampleString" value to "My Sample String" on property update resource
    And I wait for 1 seconds
    And I make a GET request on properties resource
    Then I should see sampleString as "My Sample String" from properties resource