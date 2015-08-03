Feature: Phone by id resource

  Scenario: should get phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should get http response status as 200 from phone by id resource

  Scenario: should get additional features of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see the additional features as below from phone by id resource
    """
    Contour Display, Near Field Communications (NFC),
     Three-axis gyroscope, Anti-fingerprint display coating,
     Internet Calling support (VoIP/SIP)
    """

  Scenario: should get android details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see android os as "Android 2.3" from phone by id resource
    Then I should see android ui as "Android" from phone by id resource

  Scenario: should get availability list of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see availability list as below from phone by id resource
      | M1       |
      | O2       |
      | Orange   |
      | Singtel  |
      | StarHub  |
      | T-Mobile |
      | Vodafone |

  Scenario: should get battery details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see battery standby time as "428 hours" from phone by id resource
    Then I should see battery talk time as "6 hours" from phone by id resource
    Then I should see battery type as "Lithium Ion (Li-Ion) (1500 mAH)" from phone by id resource

  Scenario: should get camera details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see camera features as below from phone by id resource
      | Flash   |
      | Video   |
    And I should see camera primary as "5.0 megapixels" from phone by id resource

  Scenario: should get connectivity details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see connectivity bluetooth as "Bluetooth 2.1" from phone by id resource
    Then I should see connectivity cell as below from phone by id resource
      """
      Quad-band GSM: 850, 900, 1800, 1900
      Tri-band HSPA: 900, 2100, 1700
      HSPA type: HSDPA (7.2Mbps) HSUPA (5.76Mbps)
      """
    Then I should see connectivity gps as true from phone by id resource
    Then I should see connectivity infrared as false from phone by id resource
    Then I should see connectivity wifi as "802.11 b/g/n" from phone by id resource

  Scenario: should get description of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see description as below from phone by id resource
    """
    Nexus S is the next generation of Nexus devices, co-developed by Google and Samsung.
     The latest Android platform (Gingerbread), paired with a 1 GHz Hummingbird processor and 16GB of memory,
     makes Nexus S one of the fastest phones on the market. It comes pre-installed with the best of Google
     apps and enabled with new and popular features like true multi-tasking, Wi-Fi hotspot, Internet Calling,
     NFC support, and full web browsing. With this device, users will also be the first to receive
     software upgrades and new Google mobile apps as soon as they become available. For more details,
     visit http://www.google.com/nexus.
    """

  Scenario: should get display details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see display screen resolution as "WVGA (800 x 480)" from phone by id resource
    Then I should see display screen size as "4.0 inches" from phone by id resource
    Then I should see display touch screen as true from phone by id resource
