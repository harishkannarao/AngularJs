package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.entity.ApplicationPropertyEntity;
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
public class PropertiesResourceSteps extends BaseSteps {

    private static final WebTarget modulePropertiesTarget = restApiBaseTarget.path("/properties/module");

    private WebTarget target;
    private Response response;

    private ApplicationPropertyEntity getApplicationPropertyEntity() {
        return response.readEntity(new GenericType<ApplicationPropertyEntity>() {});
    }

    @Given("^I set the url to module on properties resource$")
    public void I_set_the_url_to_phones_resource() throws Throwable {
        target = modulePropertiesTarget;
    }

    @And("^I make a GET request on properties resource$")
    public void I_make_a_GET_request_on_properties_resource() throws Throwable {
        response = target.request().get();
        response.bufferEntity();
    }

    @Then("^I should get http response status as (\\d+) from properties resource$")
    public void I_should_get_http_response_status_as_from_properties_resource(int httpStatusCode) throws Throwable {
        assertEquals(response.getStatus(), httpStatusCode);
    }

    @And("^I should see sampleString as \"(.*)\" from properties resource$")
    public void I_should_see_sampleString_as_from_properties_resource(String sampleStringValue) throws Throwable {
        assertEquals(getApplicationPropertyEntity().getSampleString(), sampleStringValue);
    }

    @And("^I should see sampleStringArray as below from properties resource$")
    public void I_should_see_sampleStringArray_as_below_from_properties_resource(List<String> sampleStringArrayValues) throws Throwable {
        ApplicationPropertyEntity applicationPropertyEntity = getApplicationPropertyEntity();

        assertEquals(applicationPropertyEntity.getListOfString().size(), sampleStringArrayValues.size());
        assertEquals(applicationPropertyEntity.getListOfString(), sampleStringArrayValues);
    }

    @And("^I should see sampleLong as (\\d+) from properties resource$")
    public void I_should_see_sampleLong_as_from_properties_resource(Long sampleLongValue) throws Throwable {
        assertEquals(getApplicationPropertyEntity().getSampleLong(), sampleLongValue);
    }

    @And("^I should see enablePropertyChangeListener as (.*) from properties resource$")
    public void I_should_see_enablePropertyChangeListener_as_from_properties_resource(Boolean enablePropertyChangeListenerValue) throws Throwable {
        assertEquals(getApplicationPropertyEntity().getEnablePropertyChangeListener(), enablePropertyChangeListenerValue);
    }
}
