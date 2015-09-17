package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.entity.PhoneEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.testng.Assert.assertEquals;

@ApplicationScoped
public class PhoneByIdResourceSteps extends BaseSteps {

    private static final WebTarget phoneByIdTarget = restApiBaseTarget.path("/phones/{phoneId}");

    private WebTarget target;
    private Response response;
    private String phoneId;

    private PhoneEntity getPhoneEntity() {
        return response.readEntity(new GenericType<PhoneEntity>() {});
    }

    @And("^I set the phone id as (.*) to phone by id resource$")
    public void I_set_the_phone_id_as_to_phone_by_id_resource(String phoneId) throws Throwable {
        this.phoneId = phoneId;
    }

    @Given("^I set the url to phone by id resource$")
    public void I_set_the_url_to_phone_by_id_resource() throws Throwable {
        this.target = phoneByIdTarget;
    }

    @And("^I make a GET request on phone by id resource$")
    public void I_make_a_GET_request_on_phone_by_id_resource() throws Throwable {
        this.response = this.target.resolveTemplate("phoneId", phoneId).request().get();
        this.response.bufferEntity();
    }

    @Then("^I should get http response status as (.*) from phone by id resource$")
    public void I_should_get_http_response_status_as_from_phone_by_id_resource(int statusCode) throws Throwable {
        assertEquals(response.getStatus(), statusCode);
    }

    @Then("^I should see the additional features as below from phone by id resource$")
    public void I_should_see_the_additional_features_as_below_from_phone_by_id_resource(String additionalFeatures) throws Throwable {
        String expectedAdditionalFeatures = additionalFeatures.replaceAll("[\r\n]+", "");
        String actualAdditionalFeatures = getPhoneEntity().getAdditionalFeatures().replaceAll("[\r\n]+", "");
        assertEquals(actualAdditionalFeatures, expectedAdditionalFeatures);
    }

    @Then("^I should see android os as \"(.*)\" from phone by id resource$")
    public void I_should_see_android_os_as_from_phone_by_id_resource(String androidOs) throws Throwable {
        assertEquals(getPhoneEntity().getAndroidDetails().getOs(), androidOs);
    }

    @Then("^I should see android ui as \"(.*)\" from phone by id resource$")
    public void I_should_see_android_ui_as_from_phone_by_id_resource(String androidUi) throws Throwable {
        assertEquals(getPhoneEntity().getAndroidDetails().getUi(), androidUi);
    }

    @Then("^I should see availability list as below from phone by id resource$")
    public void I_should_see_availability_list_as_below_from_phone_by_id_resource(List<String> availabilityList) throws Throwable {
        PhoneEntity phoneEntity = getPhoneEntity();
        assertEquals(phoneEntity.getAvailabilityList().size(), availabilityList.size());
        assertEquals(phoneEntity.getAvailabilityList(), availabilityList);
    }

    @Then("^I should see battery standby time as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_standby_time_as_from_phone_by_id_resource(String batteryStandbyTime) throws Throwable {
        assertEquals(getPhoneEntity().getBatteryDetails().getStandbyTime(), batteryStandbyTime);
    }

    @Then("^I should see battery talk time as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_talk_time_as_from_phone_by_id_resource(String batteryTalkTime) throws Throwable {
        assertEquals(getPhoneEntity().getBatteryDetails().getTalkTime(), batteryTalkTime);
    }

    @Then("^I should see battery type as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_type_as_from_phone_by_id_resource(String batteryType) throws Throwable {
        assertEquals(getPhoneEntity().getBatteryDetails().getType(), batteryType);
    }

    @Then("^I should see camera features as below from phone by id resource$")
    public void I_should_see_camera_features_as_below_from_phone_by_id_resource(List<String> cameraFeatures) throws Throwable {
        PhoneEntity phoneEntity = getPhoneEntity();
        assertEquals(phoneEntity.getCameraDetails().getFeatures().size(), cameraFeatures.size());
        assertEquals(phoneEntity.getCameraDetails().getFeatures(), cameraFeatures);
    }

    @And("^I should see camera primary as \"(.*)\" from phone by id resource$")
    public void I_should_see_camera_primary_as_from_phone_by_id_resource(String cameraPrimary) throws Throwable {
        assertEquals(getPhoneEntity().getCameraDetails().getPrimary(), cameraPrimary);
    }


    @Then("^I should see connectivity bluetooth as \"(.*)\" from phone by id resource$")
    public void I_should_see_connectivity_bluetooth_as_from_phone_by_id_resource(String connectivityBluetooth) throws Throwable {
        assertEquals(getPhoneEntity().getConnectivityDetails().getBluetooth(), connectivityBluetooth);

    }

    @Then("^I should see connectivity gps as (.*) from phone by id resource$")
    public void I_should_see_connectivity_gps_as_true_from_phone_by_id_resource(Boolean gps) throws Throwable {
        assertEquals(getPhoneEntity().getConnectivityDetails().getGps(), gps);
    }

    @Then("^I should see connectivity infrared as (.*) from phone by id resource$")
    public void I_should_see_connectivity_infrared_as_false_from_phone_by_id_resource(Boolean infrared) throws Throwable {
        assertEquals(getPhoneEntity().getConnectivityDetails().getInfrared(), infrared);
    }

    @Then("^I should see connectivity wifi as \"(.*)\" from phone by id resource$")
    public void I_should_see_connectivity_wifi_as_from_phone_by_id_resource(String wifi) throws Throwable {
        assertEquals(getPhoneEntity().getConnectivityDetails().getWifi(), wifi);
    }

    @Then("^I should see connectivity cell as below from phone by id resource$")
    public void I_should_see_connectivity_cell_as_below_from_phone_by_id_resource(String connectivityCell) throws Throwable {
        String actualConnectivityCell = getPhoneEntity().getConnectivityDetails().getCell().replaceAll("[\r\n]+", "");
        String expectedConnectivityCell = connectivityCell.replaceAll("[\r\n]+", "");
        assertEquals(actualConnectivityCell, expectedConnectivityCell);
    }

    @Then("^I should see description as below from phone by id resource$")
    public void I_should_see_description_as_below_from_phone_by_id_resource(String description) throws Throwable {
        String expectedDescription = description.replaceAll("[\r\n]+", "");
        String actualDescription = getPhoneEntity().getDescription().replaceAll("[\r\n]+", "");
        assertEquals(actualDescription, expectedDescription);
    }

    @Then("^I should see display screen resolution as \"(.*)\" from phone by id resource$")
    public void I_should_see_display_screen_resolution_as_from_phone_by_id_resource(String screenResolution) throws Throwable {
        assertEquals(getPhoneEntity().getDisplayDetails().getScreenResolution(), screenResolution);
    }

    @Then("^I should see display screen size as \"(.*)\" from phone by id resource$")
    public void I_should_see_display_screen_size_as_from_phone_by_id_resource(String screenSize) throws Throwable {
        assertEquals(getPhoneEntity().getDisplayDetails().getScreenSize(), screenSize);
    }

    @Then("^I should see display touch screen as (.*) from phone by id resource$")
    public void I_should_see_display_touch_screen_as_from_phone_by_id_resource(Boolean touchScreen) throws Throwable {
        assertEquals(getPhoneEntity().getDisplayDetails().getTouchScreen(), touchScreen);
    }

    @Then("^I should see hardware accelerometer as (.*) from phone by id resource$")
    public void I_should_see_hardware_accelerometer_as_from_phone_by_id_resource(Boolean accelerometer) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getAccelerometer(), accelerometer);
    }

    @Then("^I should see hardware audioJack as \"(.*)\" from phone by id resource$")
    public void I_should_see_hardware_audioJack_as_from_phone_by_id_resource(String audioJack) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getAudioJack(), audioJack);
    }

    @Then("^I should see hardware cpu as \"(.*)\" from phone by id resource$")
    public void I_should_see_hardware_cpu_as_from_phone_by_id_resource(String cpu) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getCpu(), cpu);
    }

    @Then("^I should see hardware fmRadio as (.*) from phone by id resource$")
    public void I_should_see_hardware_fmRadio_as_from_phone_by_id_resource(Boolean fmRadio) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getFmRadio(), fmRadio);
    }

    @Then("^I should see hardware physicalKeyboard as (.*) from phone by id resource$")
    public void I_should_see_hardware_physicalKeyboard_as_from_phone_by_id_resource(Boolean physicalKeyboard) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getPhysicalKeyboard(), physicalKeyboard);
    }

    @Then("^I should see hardware usb as \"(.*)\" from phone by id resource$")
    public void I_should_see_hardware_usb_as_from_phone_by_id_resource(String usb) throws Throwable {
        assertEquals(getPhoneEntity().getHardwareDetails().getUsb(), usb);
    }

    @Then("^I should see id as (\\d+) from phone by id resource$")
    public void I_should_see_id_as_from_phone_by_id_resource(Long phoneId) throws Throwable {
        assertEquals(getPhoneEntity().getId(), phoneId);
    }

    @Then("^I should see image list as below from phone by id resource$")
    public void I_should_see_image_list_as_below_from_phone_by_id_resource(List<String> imageList) throws Throwable {
        PhoneEntity phoneEntity = getPhoneEntity();
        assertEquals(phoneEntity.getImages().size(), imageList.size());
        assertEquals(phoneEntity.getImages(), imageList);
    }

    @And("^I should be able to get every image in the list from phone by id resource$")
    public void I_should_be_able_to_get_every_image_in_the_list_from_phone_by_id_resource() throws Throwable {
        PhoneEntity phoneEntity = getPhoneEntity();
        phoneEntity.getImages().forEach((String imageUrl) -> {
            Response imageResponse = serverTarget.path(imageUrl).request().get();
            assertEquals(imageResponse.getStatus(), 200);
            assertEquals(imageResponse.getHeaderString("Content-Type"), "image/jpeg");
            imageResponse.close();
        });
    }

    @Then("^I should see name as \"(.*)\" from phone by id resource$")
    public void I_should_see_name_as_from_phone_by_id_resource(String name) throws Throwable {
        assertEquals(getPhoneEntity().getName(), name);
    }

    @Then("^I should see dimensions list as below from phone by id resource$")
    public void I_should_see_dimensions_list_as_below_from_phone_by_id_resource(List<String> dimensions) throws Throwable {
        PhoneEntity phoneEntity = getPhoneEntity();
        assertEquals(phoneEntity.getSizeAndWeightDetails().getDimensions().size(), dimensions.size());
        assertEquals(phoneEntity.getSizeAndWeightDetails().getDimensions(), dimensions);
    }

    @Then("^I should see weight as \"(.*)\" from phone by id resource$")
    public void I_should_see_weight_as_from_phone_by_id_resource(String weight) throws Throwable {
        assertEquals(getPhoneEntity().getSizeAndWeightDetails().getWeight(), weight);
    }

    @Then("^I should see storage flash as \"(.*)\" from phone by id resource$")
    public void I_should_see_storage_flash_as_from_phone_by_id_resource(String storageFlash) throws Throwable {
        assertEquals(getPhoneEntity().getStorageDetails().getFlash(), storageFlash);
    }

    @Then("^I should see storage ram as \"(.*)\" from phone by id resource$")
    public void I_should_see_storage_ram_as_from_phone_by_id_resource(String storageRam) throws Throwable {
        assertEquals(getPhoneEntity().getStorageDetails().getRam(), storageRam);
    }
}
