package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.datatable.PhoneSummaryDataTable;
import com.harishkannarao.angularjs.restapi.entity.PhoneSummaryEntity;
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

    private static final WebTarget phonesTarget = restApiBaseTarget.path("/phones");

    private WebTarget target;
    private Response response;

    @Given("^I set the url to getAllPhones on phone resource$")
    public void I_set_the_url_to_getAllPhones_on_phone_resource() throws Throwable {
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

    @And("^I should see number of phone summaries as (\\d+) from phone resource$")
    public void I_should_see_number_of_phone_summaries_as_from_phone_resource(int phoneCount) throws Throwable {
        List<PhoneSummaryEntity> phoneSummaryList = response.readEntity(new GenericType<List<PhoneSummaryEntity>>() {});
        assertEquals(phoneSummaryList.size(), phoneCount);
    }

    @And("^I should see the following phone summary from phone resource$")
    public void I_should_see_the_following_phone_summary_from_phone_resource(List<PhoneSummaryDataTable> phoneSummaryDataTableList) throws Throwable {
        List<PhoneSummaryEntity> phoneSummaryList = response.readEntity(new GenericType<List<PhoneSummaryEntity>>() {});
        Map<String, PhoneSummaryEntity> mappedPhoneList = phoneSummaryList.stream().collect(Collectors.toMap(PhoneSummaryEntity::getName, phoneEntity -> phoneEntity));
        phoneSummaryDataTableList.stream().forEach(phoneSummaryDataTable -> {
            PhoneSummaryEntity phoneSummaryEntity = mappedPhoneList.get(phoneSummaryDataTable.getName());
            assertEquals(phoneSummaryEntity.getId(), phoneSummaryDataTable.getId());
            assertEquals(phoneSummaryEntity.getName(), phoneSummaryDataTable.getName());
            assertEquals(phoneSummaryEntity.getAge(), phoneSummaryDataTable.getAge());
            assertEquals(phoneSummaryEntity.getDescription(), phoneSummaryDataTable.getSnippet());
        });
    }

    @Then("^I should be able to get image for every phone summary from phone resource$")
    public void I_should_be_able_to_get_image_for_every_phone_summary_from_phone_resource() throws Throwable {
        List<PhoneSummaryEntity> phoneSummaryList = response.readEntity(new GenericType<List<PhoneSummaryEntity>>() {});
        phoneSummaryList.forEach(phoneEntity -> {
            Response imageResponse = serverTarget.path(phoneEntity.getImageUrl()).request().get();
            assertEquals(imageResponse.getStatus(), 200);
            assertEquals(imageResponse.getHeaderString("Content-Type"), "image/jpeg");
            imageResponse.close();
        });
    }
}
