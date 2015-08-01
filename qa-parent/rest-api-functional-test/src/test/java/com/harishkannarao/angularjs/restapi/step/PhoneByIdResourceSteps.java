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
        assertEquals(response.getStatus(), statusCode);;
    }

    @Then("^I should see the additional features as \"(.*)\" from phone by id resource$")
    public void I_should_see_the_additional_features_as_from_phone_by_id_resource(String additionalFeatures) throws Throwable {
        assertEquals(getPhoneEntity().getAdditionalFeatures(), additionalFeatures);
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
        String expectedDescription = description.replaceAll("\n", "");
        assertEquals(getPhoneEntity().getDescription(), expectedDescription);
    }
}
