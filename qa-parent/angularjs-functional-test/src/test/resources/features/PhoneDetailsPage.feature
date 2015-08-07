Feature: Phone Details Page Features

  Scenario: should display phone name in the title on phone details page
    Given I go to phone details page with phone id as 1
    Then I should see the title as "Google Phone Gallery: Nexus S" on phone details page

  Scenario: should display additional features of phone on phone details page
    Given I go to phone details page with phone id as 1
    Then I should see the additional features as below on phone details page
    """
    Contour Display, Near Field Communications (NFC),
     Three-axis gyroscope, Anti-fingerprint display coating,
     Internet Calling support (VoIP/SIP)
    """

  Scenario: should display android details of phone on phone details page
    Given I go to phone details page with phone id as 1
    Then I should see android os as "Android 2.3" on phone details page
    Then I should see android ui as "Android" on phone details page

  Scenario: should display availability list of phone on phone details page
    Given I go to phone details page with phone id as 1
    Then I should see availability list as below on phone details page
      | M1       |
      | O2       |
      | Orange   |
      | Singtel  |
      | StarHub  |
      | T-Mobile |
      | Vodafone |

  Scenario: should display availability list with single empty string
    Given I go to phone details page with phone id as 2
    Then I should see availability list as below on phone details page
      | |

  Scenario: should display availability list with single string value
    Given I go to phone details page with phone id as 3
    Then I should see availability list as below on phone details page
      | Verizon |

#  Scenario: should display battery details on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see battery standby time as "428 hours" on phone details page
#    Then I should see battery talk time as "6 hours" on phone details page
#    Then I should see battery type as "Lithium Ion (Li-Ion) (1500 mAH)" on phone details page
#
#  Scenario: should display camera details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see camera features as below on phone details page
#      | Flash   |
#      | Video   |
#    And I should see camera primary as "5.0 megapixels" on phone details page
#
#  Scenario: should display connectivity details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see connectivity bluetooth as "Bluetooth 2.1" on phone details page
#    Then I should see connectivity cell as below on phone details page
#      """
#      Quad-band GSM: 850, 900, 1800, 1900
#      Tri-band HSPA: 900, 2100, 1700
#      HSPA type: HSDPA (7.2Mbps) HSUPA (5.76Mbps)
#      """
#    Then I should see connectivity gps as true on phone details page
#    Then I should see connectivity infrared as false on phone details page
#    Then I should see connectivity wifi as "802.11 b/g/n" on phone details page
#
#  Scenario: should display connectivity cell as empty string for phone on phone details page
#    Given I go to phone details page with phone id as 2
#    Then I should see connectivity cell as below on phone details page
#      """
#      """
#
#  Scenario: should display description of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see description as below on phone details page
#    """
#    Nexus S is the next generation of Nexus devices, co-developed by Google and Samsung.
#     The latest Android platform (Gingerbread), paired with a 1 GHz Hummingbird processor and 16GB of memory,
#     makes Nexus S one of the fastest phones on the market. It comes pre-installed with the best of Google
#     apps and enabled with new and popular features like true multi-tasking, Wi-Fi hotspot, Internet Calling,
#     NFC support, and full web browsing. With this device, users will also be the first to receive
#     software upgrades and new Google mobile apps as soon as they become available. For more details,
#     visit http://www.google.com/nexus.
#    """
#
#  Scenario: should display display details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see display screen resolution as "WVGA (800 x 480)" on phone details page
#    Then I should see display screen size as "4.0 inches" on phone details page
#    Then I should see display touch screen as true on phone details page
#
#  Scenario: should display hardware details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see hardware accelerometer as true on phone details page
#    Then I should see hardware audioJack as "3.5mm" on phone details page
#    Then I should see hardware cpu as "1GHz Cortex A8 (Hummingbird) processor" on phone details page
#    Then I should see hardware fmRadio as false on phone details page
#    Then I should see hardware physicalKeyboard as false on phone details page
#    Then I should see hardware usb as "USB 2.0" on phone details page
#
#  Scenario: should display id of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see id as 1 on phone details page
#
#  Scenario: should display image list of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see image list as below on phone details page
#      | /restapi/img/phones/nexus-s.0.jpg   |
#      | /restapi/img/phones/nexus-s.1.jpg   |
#      | /restapi/img/phones/nexus-s.2.jpg   |
#      | /restapi/img/phones/nexus-s.3.jpg   |
#    And I should be able to get every image in the list on phone details page
#
#  Scenario: should display name of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see name as "Nexus S" on phone details page
#
#  Scenario: should display size and weight details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see dimensions list as below on phone details page
#      | 63.0 mm (w)  |
#      | 123.9 mm (h) |
#      | 10.88 mm (d) |
#    Then I should see weight as "129.0 grams" on phone details page
#
#  Scenario: should display storage details of phone on phone details page
#    Given I go to phone details page with phone id as 1
#    Then I should see storage flash as "16384MB" on phone details page
#    Then I should see storage ram as "512MB" on phone details page