package com.harishkannarao.angularjs.restapi.step;

import com.harishkannarao.angularjs.restapi.datatable.ParameterViolationDataTable;
import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;
import com.harishkannarao.angularjs.restapi.entity.AuthLoginEntity;
import com.harishkannarao.angularjs.restapi.entity.ValidationResponseEntity;
import com.harishkannarao.angularjs.restapi.holder.EntityHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

@ApplicationScoped
public class AuthLoginEndpointSteps extends BaseSteps {

    public static final WebTarget authLoginEndpoint = restApiBaseTarget.path("/auth/login");

    private boolean emptyPayLoad;
    private String username;
    private String password;

    @Inject
    private EntityHolder entityHolder;

    private AuthAccessEntity getAuthAccessEntity() {
        return response.readEntity(new GenericType<AuthAccessEntity>() {});
    }

    @Given("^I set the url to auth login endpoint$")
    public void setUrl() throws Throwable {
        this.target = authLoginEndpoint;
    }


    @And("^I set empty pay load to auth login endpoint$")
    public void I_set_empty_pay_load_to_auth_login_endpoint() throws Throwable {
        this.emptyPayLoad = true;
    }

    @And("^I set the username as \"(.*)\" to auth login endpoint$")
    public void setUsername(String username) throws Throwable {
        this.username = username;
    }

    @And("^I set the username as null to auth login endpoint$")
    public void I_set_the_username_as_null_to_auth_login_endpoint() throws Throwable {
        this.username = null;
    }

    @And("^I set the password as \"(.*)\" to auth login endpoint$")
    public void setPassword(String password) throws Throwable {
        this.password = password;
    }

    @And("^I set the password as null to auth login endpoint$")
    public void I_set_the_password_as_null_to_auth_login_endpoint() throws Throwable {
        this.password = null;
    }

    @And("^I make a POST request to auth login endpoint$")
    public void makePostRequest() throws Throwable {
        AuthLoginEntity authLoginEntity = null;
        if (!emptyPayLoad) {
            authLoginEntity = new AuthLoginEntity();
            authLoginEntity.setUsername(username);
            authLoginEntity.setPassword(password);
        }
        this.response = this.target.request(MediaType.APPLICATION_JSON).post(Entity.entity(authLoginEntity, MediaType.APPLICATION_JSON));
        this.response.bufferEntity();
    }

    @Then("^I should get http response status as (\\d+) from auth login endpoint$")
    public void I_should_get_http_response_status_as_from_auth_login_endpoint(int httpStatus) throws Throwable {
        assertEquals(response.getStatus(), httpStatus);
    }

    @And("^I should see authId as \"(.*)\" from auth login endpoint$")
    public void I_should_see_authId_as_from_auth_login_endpoint(String authId) throws Throwable {
        assertEquals(getAuthAccessEntity().getAuthId(), authId);
    }

    @And("^I should see non empty authToken from auth login endpoint$")
    public void I_should_see_non_empty_authToken_from_auth_login_endpoint() throws Throwable {
        assertNotNull(getAuthAccessEntity().getAuthToken());
        assertTrue(getAuthAccessEntity().getAuthToken().length() > 0);
    }

    @And("^I should see empty authPermissions from auth login endpoint$")
    public void I_should_see_empty_authPermissions_from_auth_login_endpoint() throws Throwable {
        assertNotNull(getAuthAccessEntity().getAuthPermissions());
        assertTrue(getAuthAccessEntity().getAuthPermissions().isEmpty());
    }

    @And("^I should see authPermissions from auth login endpoint as below$")
    public void I_should_see_authPermissions_from_auth_login_endpoint_as_below(List<String> authPermissions) throws Throwable {
        AuthAccessEntity authAccessEntity = getAuthAccessEntity();
        assertEquals(authAccessEntity.getAuthPermissions().size(), authPermissions.size());
        assertEquals(authAccessEntity.getAuthPermissions(), authPermissions);
    }

    @And("^I should see validation response as below from auth login endpoint$")
    public void I_should_see_validation_response_as_below_from_auth_login_endpoint(List<ParameterViolationDataTable> parameterViolationDataTableList) throws Throwable {
        ValidationResponseEntity validationResponseEntity = getValidationResponseEntity();
        assertEquals(validationResponseEntity.getParameterViolations().size(), parameterViolationDataTableList.size());
        List<ValidationResponseEntity.ParameterViolation> sortedParameterViolation =  validationResponseEntity.getParameterViolations().stream().sorted((o1, o2) -> o1.getPath().compareTo(o2.getPath())).collect(Collectors.toList());
        List<ParameterViolationDataTable> sortedParameterViolationDataTable = parameterViolationDataTableList.stream().sorted((o1, o2) -> o1.getPath().compareTo(o2.getPath())).collect(Collectors.toList());
        for (int i=0;i<sortedParameterViolation.size();i++) {
            ValidationResponseEntity.ParameterViolation currentParameterViolation = sortedParameterViolation.get(i);
            ParameterViolationDataTable currentParameterViolationDataTable = sortedParameterViolationDataTable.get(i);
            assertEquals(currentParameterViolation.getConstraintType(), currentParameterViolationDataTable.getConstraintType());
            assertEquals(currentParameterViolation.getPath(), currentParameterViolationDataTable.getPath());
            assertEquals(currentParameterViolation.getMessage(), currentParameterViolationDataTable.getMessage());
            assertEquals(currentParameterViolation.getValue(), currentParameterViolationDataTable.getValue());
        }
    }

    @And("^I should see validation-exception header as \"(.*)\" from auth login endpoint$")
    public void I_should_see_validation_exception_header_as_from_auth_login_endpoint(String headerValue) throws Throwable {
        assertEquals(response.getHeaderString(VALIDATION_HEADER_KEY), headerValue);
    }

    @And("^I should see application-validation-exception header as \"(.*)\" from auth login endpoint$")
    public void I_should_see_application_validation_exception_header_as_from_auth_login_endpoint(String headerValue) throws Throwable {
        assertEquals(response.getHeaderString(APPLICATION_VALIDATION_HEADER_KEY), headerValue);
    }

    @Given("^I authenticate with user \"(.*)\" and password \"(.*)\" with auth login endpoint$")
    public void I_authenticate_with_user_and_password_with_auth_login_endpoint(String user, String password) throws Throwable {
        setUrl();
        setUsername(user);
        setPassword(password);
        makePostRequest();
        entityHolder.setAuthAccessEntity(getAuthAccessEntity());
    }
}
