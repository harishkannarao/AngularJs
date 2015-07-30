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
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getAdditionalFeatures(), additionalFeatures);
    }

    @Then("^I should see android os as \"(.*)\" from phone by id resource$")
    public void I_should_see_android_os_as_from_phone_by_id_resource(String androidOs) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getAndroidDetails().getOs(), androidOs);
    }

    @Then("^I should see android ui as \"(.*)\" from phone by id resource$")
    public void I_should_see_android_ui_as_from_phone_by_id_resource(String androidUi) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getAndroidDetails().getUi(), androidUi);
    }

    @Then("^I should see availability list as below from phone by id resource$")
    public void I_should_see_availability_list_as_below_from_phone_by_id_resource(List<String> availabilityList) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getAvailabilityList().size(), availabilityList.size());
        assertEquals(phoneEntity.getAvailabilityList(), availabilityList);
    }

    @Then("^I should see battery standby time as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_standby_time_as_from_phone_by_id_resource(String batteryStandbyTime) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getBatteryDetails().getStandbyTime(), batteryStandbyTime);
    }

    @Then("^I should see battery talk time as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_talk_time_as_from_phone_by_id_resource(String batteryTalkTime) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getBatteryDetails().getTalkTime(), batteryTalkTime);
    }

    @Then("^I should see battery type as \"(.*)\" from phone by id resource$")
    public void I_should_see_battery_type_as_from_phone_by_id_resource(String batteryType) throws Throwable {
        PhoneEntity phoneEntity = response.readEntity(new GenericType<PhoneEntity>() {});
        assertEquals(phoneEntity.getBatteryDetails().getType(), batteryType);
    }
}
