package com.harishkannarao.angularjs.webapp.step;

import com.harishkannarao.angularjs.webapp.page.GenericPage;
import com.harishkannarao.angularjs.webapp.page.PhoneDetailsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;

import static com.harishkannarao.angularjs.webapp.util.StringUtils.convertToUnicodeString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class PhoneDetailsPageSteps {

    @Inject
    private PhoneDetailsPage phoneDetailsPage;

    @Inject
    private GenericPage genericPage;

    @Then("^I should be on phone details page$")
    public void I_should_be_on_phone_details_page() throws Throwable {
        assertTrue(phoneDetailsPage.isOnValidPage(), "Is not on Phone Details page. Current url is " + genericPage.getCurrentUrl());
    }

    @And("^I should see the phone id as (\\d+) on phone details page$")
    public void I_should_see_the_phone_id_as_on_phone_details_page(Long phoneId) throws Throwable {
        assertEquals(phoneDetailsPage.getPhoneId(), phoneId);
    }

    @Given("^I go to phone details page with phone id as (\\d+)$")
    public void I_go_to_phone_details_page_with_phone_id_as(Long phoneId) throws Throwable {
        phoneDetailsPage.navigate(phoneId);
    }

    @Then("^I should see the title as \"(.*)\" on phone details page$")
    public void I_should_see_the_title_as_on_phone_details_page(String pageTitle) throws Throwable {
        assertEquals(phoneDetailsPage.getTitle(), pageTitle);
    }

    @Then("^I should see the additional features as below on phone details page$")
    public void I_should_see_the_additional_features_as_below_on_phone_details_page(String additionalFeatures) throws Throwable {
        String expectedAdditionalFeatures = additionalFeatures.replaceAll("[\r\n]+", "");
        assertEquals(phoneDetailsPage.getAdditionalFeatures(), expectedAdditionalFeatures);
    }

    @Then("^I should see android os as \"(.*)\" on phone details page$")
    public void I_should_see_android_os_as_on_phone_details_page(String androidOs) throws Throwable {
        assertEquals(phoneDetailsPage.getAndroidOs(), androidOs);
    }

    @Then("^I should see android ui as \"(.*)\" on phone details page$")
    public void I_should_see_android_ui_as_on_phone_details_page(String androidUi) throws Throwable {
        assertEquals(phoneDetailsPage.getAndroidUi(), androidUi);
    }

    @Then("^I should see availability list as below on phone details page$")
    public void I_should_see_availability_list_as_below_on_phone_details_page(List<String> availabilityList) throws Throwable {
        assertEquals(phoneDetailsPage.getAvailabilityList().size(), availabilityList.size());
        assertEquals(phoneDetailsPage.getAvailabilityList(), availabilityList);
    }

    @Then("^I should see battery standby time as \"(.*)\" on phone details page$")
    public void I_should_see_battery_standby_time_as_on_phone_details_page(String standbyTime) throws Throwable {
        assertEquals(phoneDetailsPage.getStandbyTime(), standbyTime);
    }

    @Then("^I should see battery talk time as \"(.*)\" on phone details page$")
    public void I_should_see_battery_talk_time_as_on_phone_details_page(String talkTime) throws Throwable {
        assertEquals(phoneDetailsPage.getTalkTime(), talkTime);
    }

    @Then("^I should see battery type as \"(.*)\" on phone details page$")
    public void I_should_see_battery_type_as_on_phone_details_page(String batteryType) throws Throwable {
        assertEquals(phoneDetailsPage.getBatteryType(), batteryType);
    }

    @Then("^I should see camera features as \"(.*)\" on phone details page$")
    public void I_should_see_camera_features_as_on_phone_details_page(String cameraFeatures) throws Throwable {
        assertEquals(phoneDetailsPage.getCameraFeatures(), cameraFeatures);
    }

    @And("^I should see camera primary as \"(.*)\" on phone details page$")
    public void I_should_see_camera_primary_as_on_phone_details_page(String cameraPrimary) throws Throwable {
        assertEquals(phoneDetailsPage.getCameraPrimary(), cameraPrimary);
    }

    @Then("^I should see connectivity bluetooth as \"(.*)\" on phone details page$")
    public void I_should_see_connectivity_bluetooth_as_on_phone_details_page(String bluetooth) throws Throwable {
        assertEquals(phoneDetailsPage.getConnectivityBluetooth(), bluetooth);
    }

    @Then("^I should see connectivity cell as below on phone details page$")
    public void I_should_see_connectivity_cell_as_below_on_phone_details_page(String connectivityCell) throws Throwable {
        String expectedConnectivityCell = connectivityCell.replaceAll("[\r\n]+", "");
        assertEquals(phoneDetailsPage.getConnectivityCell(), expectedConnectivityCell);
    }

    @Then("^I should see connectivity gps as \"(.*)\" on phone details page$")
    public void I_should_see_connectivity_gps_as_on_phone_details_page(String gps) throws Throwable {
        assertEquals(convertToUnicodeString(phoneDetailsPage.getConnectivityGps()), gps);
    }

    @Then("^I should see connectivity infrared as \"(.*)\" on phone details page$")
    public void I_should_see_connectivity_infrared_as_on_phone_details_page(String infrared) throws Throwable {
        assertEquals(convertToUnicodeString(phoneDetailsPage.getConnectivityInfrared()), infrared);
    }

    @Then("^I should see connectivity wifi as \"(.*)\" on phone details page$")
    public void I_should_see_connectivity_wifi_as_on_phone_details_page(String wifi) throws Throwable {
        assertEquals(phoneDetailsPage.getConnectivityWifi(), wifi);
    }

    @Then("^I should see description as below on phone details page$")
    public void I_should_see_description_as_below_on_phone_details_page(String description) throws Throwable {
        String expectedDescription = description.replaceAll("[\r\n]+", "");
        assertEquals(phoneDetailsPage.getDescription(), expectedDescription);
    }

    @Then("^I should see display screen resolution as \"(.*)\" on phone details page$")
    public void I_should_see_display_screen_resolution_as_on_phone_details_page(String screenResolution) throws Throwable {
        assertEquals(phoneDetailsPage.getScreenResolution(), screenResolution);
    }

    @Then("^I should see display screen size as \"(.*)\" on phone details page$")
    public void I_should_see_display_screen_size_as_on_phone_details_page(String screenSize) throws Throwable {
        assertEquals(phoneDetailsPage.getScreenSize(), screenSize);
    }

    @Then("^I should see display touch screen as \"(.*)\" on phone details page$")
    public void I_should_see_display_touch_screen_as_on_phone_details_page(String touchScreen) throws Throwable {
        assertEquals(convertToUnicodeString(phoneDetailsPage.getTouchScreen()), touchScreen);
    }

    @Then("^I should see hardware accelerometer as \"(.*)\" on phone details page$")
    public void I_should_see_hardware_accelerometer_as_on_phone_details_page(String hardwareAccelerometer) throws Throwable {
        assertEquals(convertToUnicodeString(phoneDetailsPage.getHardwareAccelerometer()), hardwareAccelerometer);
    }

    @Then("^I should see hardware audioJack as \"(.*)\" on phone details page$")
    public void I_should_see_hardware_audioJack_as_on_phone_details_page(String audioJack) throws Throwable {
        assertEquals(phoneDetailsPage.getAudioJack(), audioJack);
    }

    @Then("^I should see hardware cpu as \"(.*)\" on phone details page$")
    public void I_should_see_hardware_cpu_as_on_phone_details_page(String cpu) throws Throwable {
        assertEquals(phoneDetailsPage.getCpu(), cpu);
    }

    @Then("^I should see hardware fmRadio as \"(.*)\" on phone details page$")
    public void I_should_see_hardware_fmRadio_as_on_phone_details_page(String fmRadio) throws Throwable {
        assertEquals(convertToUnicodeString(phoneDetailsPage.getFmRadio()), fmRadio);
    }

    @Then("^I should see hardware usb as \"(.*)\" on phone details page$")
    public void I_should_see_hardware_usb_as_on_phone_details_page(String usb) throws Throwable {
        assertEquals(phoneDetailsPage.getUsb(), usb);
    }

    @Then("^I should see id as (.*) on phone details page$")
    public void I_should_see_id_as_on_phone_details_page(Long phoneId) throws Throwable {
        assertEquals(phoneDetailsPage.getPhoneId(), phoneId);
    }

    @Then("^I should see image list as below on phone details page$")
    public void I_should_see_image_list_as_below_on_phone_details_page(List<String> images) throws Throwable {
        assertEquals(phoneDetailsPage.getImages(), images);
    }

    @Then("^I should see name as \"(.*)\" on phone details page$")
    public void I_should_see_name_as_on_phone_details_page(String phoneName) throws Throwable {
        assertEquals(phoneDetailsPage.getPhoneName(), phoneName);
    }

    @Then("^I should see dimensions list as below on phone details page$")
    public void I_should_see_dimensions_list_as_below_on_phone_details_page(List<String> dimensions) throws Throwable {
        assertEquals(phoneDetailsPage.getDimensions(), dimensions);
    }

    @Then("^I should see weight as \"(.*)\" on phone details page$")
    public void I_should_see_weight_as_on_phone_details_page(String weight) throws Throwable {
        assertEquals(phoneDetailsPage.getWeight(), weight);
    }

    @Then("^I should see storage flash as \"(.*)\" on phone details page$")
    public void I_should_see_storage_flash_as_on_phone_details_page(String storageFlash) throws Throwable {
        assertEquals(phoneDetailsPage.getStorageFlash(), storageFlash);
    }

    @Then("^I should see storage ram as \"(.*)\" on phone details page$")
    public void I_should_see_storage_ram_as_on_phone_details_page(String storageRam) throws Throwable {
        assertEquals(phoneDetailsPage.getStorageRam(), storageRam);
    }

    @Then("^I should see the main image url as \"(.*)\" on phone details page$")
    public void I_should_see_the_main_image_url_as_on_phone_details_page(String mainImageUrl) throws Throwable {
        assertEquals(phoneDetailsPage.getMainImageUrl(), mainImageUrl);
    }

    @When("^I click on image with url as \"(.*)\" on phone details page$")
    public void I_click_on_image_with_url_as_on_phone_details_page(String imageUrl) throws Throwable {
        phoneDetailsPage.clickOnImageWithUrl(imageUrl);
    }
}
