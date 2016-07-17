package com.harishkannarao.angularjs.restapi.step;

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

import static org.testng.Assert.assertEquals;

@ApplicationScoped
public class AuthLogoutEndpointSteps extends BaseSteps {

    private static final WebTarget authLogoutEndpoint = restApiBaseTarget.path("/auth/logout");

    private AuthAccessEntity authAccessEntity;

    @Given("^I get auth token for user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iGetAuthTokenForUserAndPassword(String username, String password) throws Throwable {
        AuthLoginEntity authLoginEntity = new AuthLoginEntity();
        authLoginEntity.setUsername(username);
        authLoginEntity.setPassword(password);
        Response loginResponse = AuthLoginEndpointSteps.authLoginEndpoint.request(MediaType.APPLICATION_JSON).post(Entity.entity(authLoginEntity, MediaType.APPLICATION_JSON));
        loginResponse.bufferEntity();
        authAccessEntity = loginResponse.readEntity(new GenericType<AuthAccessEntity>() {
        });
    }

    @Then("^I should get http status (\\d+) from auth access endpoint$")
    public void iShouldGetHttpStatusFromAuthAccessEndpoint(int expectedStatus) throws Throwable {
        Response response = AuthAccessEndpointSteps.authAccessEndpoint.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, authAccessEntity.getAuthId())
                .header(AUTH_TOKEN_HEADER_KEY, authAccessEntity.getAuthToken())
                .get();
        response.bufferEntity();
        assertEquals(response.getStatus(), expectedStatus);
    }

    @And("^I logout with the logged in user and auth token$")
    public void iLogoutWithTheLoggedInUserAndAuthToken() throws Throwable {
        Response response = authLogoutEndpoint.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, authAccessEntity.getAuthId())
                .header(AUTH_TOKEN_HEADER_KEY, authAccessEntity.getAuthToken())
                .delete();
        response.bufferEntity();
        assertEquals(response.getStatus(), 204);
    }

    @And("^I logout with the user \"([^\"]*)\" and logged in auth token$")
    public void iLogoutWithTheUserAndLoggedInAuthToken(String username) throws Throwable {
        Response response = authLogoutEndpoint.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, username)
                .header(AUTH_TOKEN_HEADER_KEY, authAccessEntity.getAuthToken())
                .delete();
        response.bufferEntity();
        assertEquals(response.getStatus(), 204);
    }

    @And("^I logout with the logged in user and auth token as \"([^\"]*)\"$")
    public void iLogoutWithTheLoggedInUserAndAuthTokenAs(String authToken) throws Throwable {
        Response response = authLogoutEndpoint.request(MediaType.APPLICATION_JSON)
                .header(AUTH_ID_HEADER_KEY, authAccessEntity.getAuthId())
                .header(AUTH_TOKEN_HEADER_KEY, authToken)
                .delete();
        response.bufferEntity();
        assertEquals(response.getStatus(), 204);
    }
}
