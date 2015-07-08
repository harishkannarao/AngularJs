package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.datatable.PhoneDataTable;
import com.harishkannarao.angularjs.restapi.entity.PhoneEntity;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

@ApplicationScoped
public class PhoneResourceSteps extends BaseSteps {

    private static final WebTarget phonesTarget = baseTarget.path("/phones");

    private WebTarget target;
    private Response response;

    @Given("^I set the url to get all phones on phone resource$")
    public void I_set_the_url_to_get_all_phones_on_phone_resource() throws Throwable {
        target = phonesTarget;
    }

    @And("^I make a GET request on phone resource$")
    public void I_make_a_GET_request_on_phone_resource() throws Throwable {
        response = target.request().get();
        response.bufferEntity();
    }

    @Then("^I should get http response status as (\\d+) from phone resource$")
    public void I_should_get_http_response_status_as_from_phone_resource(int status) throws Throwable {
        assertEquals(response.getStatus(), status);
    }

    @And("^I should see number of phones as (\\d+) from phone resource$")
    public void I_should_see_number_of_phones_as_from_phone_resource(int phoneCount) throws Throwable {
        List<PhoneEntity> phoneList = response.readEntity(new GenericType<List<PhoneEntity>>() {});
        assertEquals(phoneList.size(), phoneCount);
    }

    @And("^I should see the following phone details from phone resource$")
    public void I_should_see_the_following_phone_details_from_phone_resource(List<PhoneDataTable> phoneDataTableList) throws Throwable {
        List<PhoneEntity> phoneList = response.readEntity(new GenericType<List<PhoneEntity>>() {});
        Map<String, PhoneEntity> mappedPhoneList = phoneList.stream().collect(Collectors.toMap(PhoneEntity::getName, phoneEntity -> phoneEntity));
        phoneDataTableList.stream().forEach(phoneDataTable -> {
            PhoneEntity phoneEntity = mappedPhoneList.get(phoneDataTable.getName());
            assertEquals(phoneEntity.getName(), phoneDataTable.getName());
            assertEquals(phoneEntity.getAge(), phoneDataTable.getAge());
            assertEquals(phoneEntity.getDescription(), phoneDataTable.getSnippet());
        });
    }
}
