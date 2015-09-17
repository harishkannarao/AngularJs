package com.harishkannarao.angularjs.restapi.step;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.harishkannarao.angularjs.restapi.entity.AuthAccessEntity;
import com.harishkannarao.angularjs.restapi.entity.AuthLoginEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@ApplicationScoped
public class AuthLoginEndpointSteps extends BaseSteps {

    private static final WebTarget authLoginEndpoint = restApiBaseTarget.path("/auth/login");

    private WebTarget target;
    private Response response;
    private String username;
    private String password;

    private AuthAccessEntity getAuthAccessEntity() {
        return response.readEntity(new GenericType<AuthAccessEntity>() {});
    }

    @Given("^I set the url to auth login endpoint$")
    public void I_set_the_url_to_auth_login_endpoint() throws Throwable {
        this.target = authLoginEndpoint;
    }

    @And("^I set the username as \"(.*)\" to auth login endpoint$")
    public void I_set_the_username_as_to_auth_login_endpoint(String username) throws Throwable {
        this.username = username;
    }

    @And("^I set the password as \"(.*)\" to auth login endpoint$")
    public void I_set_the_password_as_to_auth_login_endpoint(String password) throws Throwable {
        this.password = password;
    }

    @And("^I make a POST request to auth login endpoint$")
    public void I_make_a_POST_request_to_auth_login_endpoint() throws Throwable {
        AuthLoginEntity authLoginEntity = new AuthLoginEntity();
        authLoginEntity.setUsername(username);
        authLoginEntity.setPassword(password);
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
}